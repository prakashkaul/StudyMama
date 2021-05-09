package sg.com.studymama.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import sg.com.studymama.Entity.Post;
import sg.com.studymama.Entity.UserData;
//@Repository
public interface RecommendationRepository extends Neo4jRepository<Post, Long>{

	@Query("MATCH (p:Post) RETURN p ORDER BY p.creationDate DESC LIMIT 5")
	public Collection<Post> getAll();

	Post save(Post post);
	
	UserData saveUser(UserData user);
}
