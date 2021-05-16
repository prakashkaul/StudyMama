package sg.com.studymama.service;

import sg.com.studymama.DTO.CommentDTO;
import sg.com.studymama.Entity.CommentEntity;

public interface CommentService {

	public CommentEntity save(CommentDTO commentDTO);

	public void deleteComment(Integer commentId);

}
