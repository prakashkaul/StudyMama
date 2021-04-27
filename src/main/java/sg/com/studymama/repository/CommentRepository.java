package sg.com.studymama.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import sg.com.studymama.Entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	
	final String deleteByCommentId = "delete from studymama.comment c "
			+ "where (c.comment_id = ?1 ) ";
	
	@Modifying
	@Transactional
	@Query(value=deleteByCommentId, nativeQuery=true)
	public void deleteByCommentId(Integer commentId);

}
