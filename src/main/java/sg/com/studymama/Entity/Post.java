package sg.com.studymama.Entity;

import java.sql.Timestamp;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Post {
	
	@GraphId
	Long id; 
	
	private String title;
//	
//	private String description;
//	
//	private String category;
//	
//	private String contact;
//	
//	private GeoPoint location;
	
	private Timestamp creationDate;
	
	


	public Post(PostsEntity post) {
		// TODO Auto-generated constructor stub
		  this.id = Long.valueOf(post.getPostId());
          this.title = post.getTitle();
          //this.contact = post.getContact();
          //this.description = post.getDescription();
          //this.location = new GeoPoint(post.getGpsX(),post.getGpsY());
          this.creationDate = post.getCreationDate();
          //this.category = post.getCategory();		
	}

	public Post() {
	
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//	public String getContact() {
//		return contact;
//	}
//
//	public GeoPoint getLocation() {
//		return location;
//	}

	public Timestamp getCreationDate() {
		return creationDate;
	}
}
