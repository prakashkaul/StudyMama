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
public class PostData implements Serializable {

    @Id
    private String id;

    private String title;

    private String description;

    private String website;

    private GeoPoint location;

    private String status;

    private Long post_dt;

    private Long edited_dt;

    private String price;

    private String category;

    private String picture;

    private String accountId;

    public  PostData(PostsEntity postsDTO){
        this.id = postsDTO.getPostId().toString();
        this.title = postsDTO.getTitle();
        this.description = postsDTO.getDescription();
        this.website = postsDTO.getWebsite();
        if(postsDTO.getGpsX()!=null&&postsDTO.getGpsY()!=null){
            this.location = new GeoPoint(postsDTO.getGpsX(),postsDTO.getGpsY());
        }
        this.status = postsDTO.getStatus();
        this.post_dt = postsDTO.getCreationDate().getTime();
        this.edited_dt = postsDTO.getLastUpdatedDate().getTime();
        this.price = postsDTO.getPrice();
        this.category = postsDTO.getCategory();
        this.picture = postsDTO.getImages();
        this.accountId = postsDTO.getAccountId().toString();
    }



    public PostData() {
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


    public Long getPost_dt() {
        return post_dt;
    }

    public void setPost_dt(Long post_dt) {
        this.post_dt = post_dt;
    }

    public Long getEdited_dt() {
        return edited_dt;
    }

    public void setEdited_dt(Long edited_dt) {
        this.edited_dt = edited_dt;
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