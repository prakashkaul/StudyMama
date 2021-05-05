package sg.com.studymama.Entity;

import java.sql.Timestamp;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Post {
	
	@Id@GeneratedValue
	Long id; 
	
	private String title;
	
	private String description;
	
	private String category;
	
	private String contact;
	
	private GeoPoint location;
	
	private String creationDate;
	
	public Post(PostsEntity post) {
		// TODO Auto-generated constructor stub
		  this.id = Long.valueOf(post.getPostId());
          this.title = post.getTitle();
          this.contact = post.getContact();
          this.description = post.getDescription();
          this.location = new GeoPoint(post.getGpsX(),post.getGpsY());
          this.creationDate = String.valueOf(post.getCreationDate());
          this.category = post.getCategory();		
	}

	public Post() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public void setLocation(GeoPoint location) {
		this.location = location;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
}
