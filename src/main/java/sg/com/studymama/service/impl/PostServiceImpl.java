package sg.com.studymama.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.com.studymama.DTO.PostsDTO;
import sg.com.studymama.Entity.CommentEntity;
import sg.com.studymama.Entity.PostsEntity;
import sg.com.studymama.Entity.RateEntity;
import sg.com.studymama.repository.PostRepository;
import sg.com.studymama.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepository postRepository;
	
	private static final String ACTIVE = "ACTIVE";
	private static final String INACTIVE = "CLOSED";

	@Override
	public Integer deletePost(Integer postId) {
		return postRepository.deleteByPostId(postId);
	}

	@Override
	public List<PostsDTO> getAllPost() {
		// TODO Auto-generated method stub
		List<PostsDTO> dtos = new ArrayList<PostsDTO>();
		List<PostsEntity> entity = postRepository.findAll();
		if(entity != null && entity.size()>0) {
			for(PostsEntity post : entity) {
				dtos.add(convertToDTO(post));
			}
		}
		
		return dtos;
	}

	private PostsDTO convertToDTO(PostsEntity post) {
		// TODO Auto-generated method stub
		PostsDTO dto = new PostsDTO();
		
		dto.setAccountId(post.getAccountId());
		dto.setPostId(post.getPostId());
		dto.setCategory(post.getCategory());
		dto.setContact(post.getContact());
		dto.setDescription(post.getDescription());
		dto.setTitle(post.getTitle());
		dto.setGpsX(Optional.ofNullable(post.getGpsX()).orElse(null));
		dto.setGpsY(Optional.ofNullable(post.getGpsY()).orElse(null));
		dto.setImages(Optional.ofNullable(post.getImages()).orElse(null));
		dto.setPrice(Optional.ofNullable(post.getPrice()).orElse(null));
		dto.setWebsite(Optional.ofNullable(post.getWebsite()).orElse(null));
		if(post.getStatus()== "0" ) {
			dto.setStatus(ACTIVE);
		} else {
			dto.setStatus(INACTIVE);
		}
		
		if(post.getRateEntity() !=null && post.getRateEntity().size()>0) {
			int sum=0;
			for(RateEntity rate:post.getRateEntity()) {
				int score =rate.getrateScore();
				sum += score;
			}
			
			BigDecimal avg = BigDecimal.valueOf(sum/post.getRateEntity().size());
			dto.setScore(avg);
		}
		
		if(post.getCommentEntity() != null && post.getCommentEntity().size()>0) {
			List<String> comments = new ArrayList<String>();
			for(CommentEntity entity : post.getCommentEntity()) {
				comments.add(entity.getDescription());
			}
			dto.setComments(comments);
		}
		return dto;
	}

	@Override
	public PostsDTO findById(Integer postId) {
		// TODO Auto-generated method stub
		PostsDTO dto = new PostsDTO();
		PostsEntity entity =postRepository.findByPostId(postId);
		if(entity!=null) {
			dto = convertToDTO(entity);
		}
		
		return dto;
	}

	@Override
	public PostsEntity save(PostsDTO dto) {
		// TODO Auto-generated method stub
		PostsEntity entity = convertToEntity(dto);
		if(entity.getPostId()==null) {
			//entity.setLastUpdatedDate(Optional.ofNullable(Timestamp.valueOf("2020-01-02 00:00:00")).orElse(null));
			entity.setLastUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
		}
		
		//entity.setLastUpdatedDate(Optional.ofNullable(Timestamp.valueOf("2020-01-02 00:00:00")).orElse(null));
		entity.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
	
		return postRepository.save(entity);
	}

	private PostsEntity convertToEntity(PostsDTO dto) {
		// TODO Auto-generated method stub
		PostsEntity entity = new PostsEntity();
		//boolean bCreate = true;
		
//		if(dto.getPostId() != null && dto.getPostId()>0) {
//			entity = postRepository.findByPostId(dto.getPostId());
//			//entity.setLastUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
//			entity.setLastUpdatedDate(Optional.ofNullable(Timestamp.valueOf("2020-01-02 00:00:00")).orElse(null));
//		} else {
//			//entity.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
//			entity.setLastUpdatedDate(Optional.ofNullable(Timestamp.valueOf("2020-01-02 00:00:00")).orElse(null));
//		}
		
		entity.setAccountId(dto.getAccountId());
		entity.setCategory(dto.getCategory());
		entity.setContact(dto.getContact());
		entity.setDescription(dto.getDescription());
		entity.setGpsX(Optional.ofNullable(dto.getGpsX()).orElse(null));
		entity.setGpsY(Optional.ofNullable(dto.getGpsY()).orElse(null));
		entity.setImages(Optional.ofNullable(dto.getImages()).orElse(null));
		entity.setPostId(dto.getPostId());
		entity.setPrice(Optional.ofNullable(dto.getPrice()).orElse(null));
		if(dto.getStatus()== ACTIVE) {
			entity.setStatus("0");
		} else {
			entity.setStatus("1");
		}
		
		entity.setTitle(dto.getTitle());
		entity.setWebsite(Optional.ofNullable(dto.getWebsite()).orElse(null));
		
		return entity;
	}

	@Override
	public List<PostsDTO> getPosts(Integer accountId) {
		// TODO Auto-generated method stub
		List<PostsEntity> postDTOList = new ArrayList<>();
		postDTOList = postRepository.findByAccountId(accountId);
		
		List<PostsDTO> postDTO = new ArrayList<>();
		if(postDTOList != null && postDTOList.size() > 0) {
			for (PostsEntity post : postDTOList) {
				postDTO.add(convertToDTO(post));
			}
		}
		
		return postDTO;
	}

}
