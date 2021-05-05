package sg.com.studymama.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sg.com.studymama.model.PostData;

import java.util.List;

public interface PostElasticSearchRepository extends ElasticsearchRepository<PostData, String> {

  Page<PostData> findAllByCategory(String category,Pageable pageable);

  @Query("{\"match_all\":{}}")
  Page<PostData> findAll(Pageable pageable);

  @Query("{\"match_bool_prefix\":{\"title\":\"?0\"}}")
  Page<PostData> findPostBySimilarTitle(String title,Pageable pageable);

  @Query("{\"match_bool_prefix\":{\"category\":\"?0\"}}")
  Page<PostData> findPostBySimilarCategory(String category,Pageable pageable);


  @Query("{\"multi_match\":{\"query\":\"?0\", \"type\":\"phrase_prefix\",\n\"fields\": [ \"title\", \"description\",\"category\"] }}")
  Page<PostData> findPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable);


}
