package sg.com.studymama.service;

import java.util.List;

import sg.com.studymama.DTO.PostDTO;
import sg.com.studymama.Entity.PostEntity;
import sg.com.studymama.model.PaginationParamDTO;
import sg.com.studymama.model.PaginationResultDTO;

public interface PostService {
	
	public List<PostDTO> getAllPost();//?
	
	public List<PostDTO> getPosts(Integer accountId);
	
	public PostDTO findById(Integer postId);
	
	public PostEntity save(PostDTO dto);
	
	public Integer deletePost(Integer postId);

}
