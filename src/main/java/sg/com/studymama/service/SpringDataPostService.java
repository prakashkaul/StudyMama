package sg.com.studymama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import sg.com.studymama.model.Post;

import java.util.List;
import java.util.Optional;

public interface SpringDataPostService {

  Post createPost(Post post);

  Optional<Post> getPost(String id);

  void deletePost(String id);

  Iterable<Post> insertBulkPost(Page<Post> Posts);

  Page<Post> getPostsByCategory(String category,Pageable pageable);

  Page<Post> getAllPost(Pageable pageable);

  Page<Post> searchPostBySimilarTitle(String title,Pageable pageable);
  SearchPage<Post> searchPostByName(String title, Pageable pageable);

  Page<Post> searchPostBySimilarCategory(String category,Pageable pageable);

  Page<Post> searchPostByCategory(String category,Pageable pageable);

  Page<Post> searchPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable);

  SearchPage<Post> searchWithin(GeoPoint geoPoint, Double distance, String unit, Pageable pageable);
}
