package mcb.blogs.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import mcb.blogs.publisher.BlogRepository;
import mcb.blogs.publisher.restmodel.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@Controller
@RequestMapping("/authenticate")
@Scope("request")
public class AuthenticationService {
    private BlogUser user;
    private UserRepository repository;
    @Autowired
    public AuthenticationService(BlogUser user,UserRepository repository) {
        this.user = user;
    }

    @PostMapping
    public ResponseEntity authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        // generate JWT

        return ResponseEntity.ok(generateJWT(request.getUsername()));
    }

    public String generateJWT(String username) throws Exception {

            Algorithm algorithm = Algorithm.HMAC256(AuthenticationFilter.SECRET_KEY);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(username)
                    .withExpiresAt(new Date(2342342342344L))
                    .withClaim("username", username)
                    .sign(algorithm);
            return token;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResponseEntity validate(@RequestBody ValidateTokenRequest request) throws Exception {

        String token = request.getToken();
        Algorithm algorithm = Algorithm.HMAC256(AuthenticationFilter.SECRET_KEY);
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return ResponseEntity.ok(decodedJWT);

    }

        @PostMapping
    public Mono<ResponseEntity> createUser(@RequestBody Mono<CreateUserRequest> request) {
        return request.map(r -> this.repository.save(new BlogUser(r.getName())))
                .map(BlogUser::getId)
                .map(id -> ResponseEntity.created(URI.create("/users/" + id)).build());
    }

}
