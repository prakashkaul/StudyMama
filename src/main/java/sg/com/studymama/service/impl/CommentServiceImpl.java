package sg.com.studymama.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.com.studymama.DTO.CommentDTO;
import sg.com.studymama.Entity.CommentEntity;
import sg.com.studymama.repository.CommentRepository;
import sg.com.studymama.service.CommentService;
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public CommentEntity save(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		CommentEntity entity = convertToEntity(commentDTO);
		
		return commentRepository.save(entity);
		
	}

	private CommentEntity convertToEntity(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		CommentEntity entity = new CommentEntity();
		entity.setAccountId(commentDTO.getAccountId());
		entity.setCommentId(commentDTO.getCommentId());
		entity.setDescription(commentDTO.getDescription());
		entity.setPostId(commentDTO.getPostId());
		
		entity.setCommentDate(Timestamp.valueOf(LocalDateTime.now()));
		
		return entity;
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		commentRepository.deleteByCommentId(commentId);
		
	}

}
