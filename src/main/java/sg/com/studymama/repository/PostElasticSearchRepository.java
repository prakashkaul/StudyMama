package sg.com.studymama.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sg.com.studymama.model.Post;

import java.util.List;

public interface PostElasticSearchRepository extends ElasticsearchRepository<Post, String> {

  Page<Post> findAllByCategory(String category,Pageable pageable);

  @Query("{\"match_all\":{}}")
  Page<Post> findAll(Pageable pageable);

  @Query("{\"match_bool_prefix\":{\"title\":\"?0\"}}")
  Page<Post> findPostBySimilarTitle(String title,Pageable pageable);

  @Query("{\"match_bool_prefix\":{\"category\":\"?0\"}}")
  Page<Post> findPostBySimilarCategory(String category,Pageable pageable);


  @Query("{\"multi_match\":{\"query\":\"?0\", \"type\":\"phrase_prefix\",\n\"fields\": [ \"title\", \"description\",\"category\"] }}")
  Page<Post> findPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable);


}
