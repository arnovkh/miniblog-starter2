import {Injectable} from '@angular/core';
import {BlogPost} from './BlogPost';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class BlogService {

  private _blogs: BlogPost[];


  constructor(private http: HttpClient) {
    this._blogs = [];
    this.RefreshPosts();
  }


  RefreshPosts()  {
    this.http.get<BlogPost[]>('http://localhost:8083/blogs')
      .subscribe( blogs =>   { this._blogs = blogs; } );
  }

}
