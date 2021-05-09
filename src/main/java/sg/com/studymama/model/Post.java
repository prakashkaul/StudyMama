package sg.com.studymama.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import sg.com.studymama.DTO.PostsDTO;
import sg.com.studymama.Entity.PostsEntity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Document(indexName = "post")
public class Post implements Serializable {

    @Id
    private String id;

    private String title;

    private String description;

    private String website;

    private GeoPoint location;

    private String status;

    private Timestamp post_dt;

    private Timestamp edited_dt;

    private String price;

    private String category;

    private String picture;

    private String accountId;

    public  Post(PostsEntity postsDTO){
        this.id = postsDTO.getPostId().toString();
        this.title = postsDTO.getTitle();
        this.description = postsDTO.getDescription();
        this.website = postsDTO.getWebsite();
        this.location = new GeoPoint(postsDTO.getGpsX(),postsDTO.getGpsY());
        this.status = postsDTO.getStatus();
        this.post_dt = postsDTO.getCreationDate();
        this.edited_dt = postsDTO.getLastUpdatedDate();
        this.price = postsDTO.getPrice();
        this.category = postsDTO.getCategory();
        this.picture = postsDTO.getImages();
        this.accountId = postsDTO.getAccountId().toString();
    }




    public Post() {
    }


    public Timestamp getPost_dt() {
        return post_dt;
    }

    public void setPost_dt(Timestamp post_dt) {
        this.post_dt = post_dt;
    }

    public Timestamp getEdited_dt() {
        return edited_dt;
    }

    public void setEdited_dt(Timestamp edited_dt) {
        this.edited_dt = edited_dt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }



    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", location=" + location +
                ", status='" + status + '\'' +
                ", post_dt='" + post_dt + '\'' +
                ", edited_dt='" + edited_dt + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", picture=" + picture +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}