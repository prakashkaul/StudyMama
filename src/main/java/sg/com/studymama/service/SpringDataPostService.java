package sg.com.studymama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import sg.com.studymama.model.PostData;

import java.util.List;
import java.util.Optional;

public interface SpringDataPostService {

  PostData createPost(PostData post);

  Optional<PostData> getPost(String id);

  void deletePost(String id);

  Iterable<PostData> insertBulkPost(Page<PostData> Posts);

  Page<PostData> getPostsByCategory(String category,Pageable pageable);

  Page<PostData> getAllPost(Pageable pageable);

  Page<PostData> searchPostBySimilarTitle(String title,Pageable pageable);
  SearchPage<PostData> searchPostByName(String title, Pageable pageable);

  Page<PostData> searchPostBySimilarCategory(String category,Pageable pageable);

  Page<PostData> searchPostByCategory(String category,Pageable pageable);

  Page<PostData> searchPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable);

  SearchPage<PostData> searchWithin(GeoPoint geoPoint, Double distance, String unit, Pageable pageable);
}
