package Model;

import java.util.List;

public class Post {
    private String id;
    private String name;
    private String timestamp;
    private String productId;
    private Integer upvote=0;
    private Integer downvote=0;

    public Post(String id, String name, String timestamp, String productId, Integer upvote, Integer downvote) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.productId = productId;
        this.upvote = upvote;
        this.downvote = downvote;
    }
    public Post()
    {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }
}
