package sg.com.studymama.Entity;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class User {
	
	@Id@GeneratedValue
	Long id;
	
//	private String firstName;
//	
//	private String lastName;
	
	private String contact;
	
	private String address;
	
//	@Relationship(type="POST", direction=Relationship.INCOMING)
//	private List<Post> posts;
	
	 public User() {

	    }

	public Long getId() {
		return id;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}

	public String getContact() {
		return contact;
	}

	public String getAddress() {
		return address;
	}

//	public List<Post> getPosts() {
//		return posts;
//	}
}
