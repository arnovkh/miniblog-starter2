package mcb.blogs.publisher.restmodel;

public class CreateBlogRequest {
    private String title;
    private String body;
    private Long userId;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }


}
