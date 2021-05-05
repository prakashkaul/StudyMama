package sg.com.studymama.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;


import sg.com.studymama.Entity.Post;
import sg.com.studymama.Entity.User;
//@Repository
public interface RecommendationRepository extends Neo4jRepository<User, Long>{

	//@Query("MATCH (p:Post) RETURN p ORDER BY p.creationDate DESC LIMIT 5")
	@Query("MATCH (u:User) RETURN u")
	public Collection<User> getAll();

	//public void save(Post post);
}
