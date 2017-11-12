package example.com.timtro.models;

/**
 * Created by Admin on 3/11/2017.
 */

public class SuCo {
    private String id;
    private String email;
    private String review;

    public SuCo(){}

    public SuCo(String id, String topic, String email, String review) {
        this.id = id;
        this.email = email;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
