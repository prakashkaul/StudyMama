package sg.com.studymama.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import sg.com.studymama.Entity.PostsEntity;


public interface PostRepository extends JpaRepository<PostsEntity, Integer> {
	
	final String deleteById = "delete from studymama.post p "
			+ "where (p.post_id = ?1 ) ";
	
	@Modifying
	@Transactional
	@Query(value=deleteById, nativeQuery=true)
	public Integer deleteByPostId(Integer postId);

	public PostsEntity findByPostId(Integer id);
	
	public List<PostsEntity> findByAccountId(Integer accountId);


}
