package sg.com.studymama.Entity;

import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import sg.com.studymama.model.DAOUser;
import javax.persistence.Table;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
@Table(name = "user")
public class UserData {
	
	@Id@GeneratedValue
	Long id;
	
	private String username;
	
	private String role;
	
	@Relationship(type="POST", direction=Relationship.INCOMING)
	private List<Post> posts;
	
	 public UserData() {

	    }
	 
	public UserData(DAOUser user) {
		// TODO Auto-generated constructor stub
	    this.id = user.getUser_profile_id();
	    this.username = user.getUsername();
	    this.role = user.getRole();		
		}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
