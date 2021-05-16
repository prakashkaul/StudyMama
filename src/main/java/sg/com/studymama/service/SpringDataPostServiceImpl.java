package sg.com.studymama.service;


import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;
import sg.com.studymama.model.PostData;
import sg.com.studymama.repository.PostElasticSearchRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Service
public class SpringDataPostServiceImpl implements SpringDataPostService {

  @Autowired
  private PostElasticSearchRepository postRepository;

  @Autowired
  private  ElasticsearchOperations operations;


  public PostData createPost(PostData Post) {

    return postRepository.save(Post);
  }

  public Optional<PostData> getPost(String id) {
    return postRepository.findById(id);
  }

  public void deletePost(String id) {
    postRepository.deleteById(id);
  }

  @Override
  public Iterable<PostData> insertBulkPost(Page<PostData>Posts) {
    return postRepository.saveAll(Posts);
  }

  @Override
  public Page<PostData>getPostsByCategory(String category,Pageable pageable) {
    return postRepository.findAllByCategory(category,pageable);
  }

  @Override
  public Page<PostData> getAllPost(Pageable pageable) {
    return postRepository.findAll(pageable);
  }

  @Override
  public Page<PostData>searchPostBySimilarTitle(String title,Pageable pageable) {
    return postRepository.findPostBySimilarTitle(title,pageable);
  }

  @Override
  public Page<PostData>searchPostBySimilarCategory(String category,Pageable pageable) {
    return postRepository.findPostBySimilarCategory(category,pageable);
  }

  @Override
  public Page<PostData>searchPostByCategory(String category,Pageable pageable) {
    return postRepository.findAllByCategory(category,pageable);
  }

  @Override
  public Page<PostData>searchPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable) {
    return postRepository.findPostsByByKeywordInTitleDescriptionCategory(keyword,pageable);
  }

  public Iterable<PostData> insertBulk(Page<PostData>Posts) {
    return postRepository.saveAll(Posts);
  }

  public Page<PostData> getPostsByName(String name,Pageable pageable) {
    return postRepository.findAllByCategory(name,pageable);
  }



  public SearchPage<PostData> searchWithin(GeoPoint geoPoint, Double distance, String unit, Pageable pageable) {

    GeoDistanceQueryBuilder builder = QueryBuilders.geoDistanceQuery("location").point(geoPoint.getLat(), geoPoint.getLon())
            .distance(distance, DistanceUnit.METERS);

    GeoDistanceSortBuilder sortBuilder = SortBuilders.geoDistanceSort("location",geoPoint.getLat(),geoPoint.getLon())
            .point(geoPoint.getLat(), geoPoint.getLon())
            .unit(DistanceUnit.METERS)
            .order(SortOrder.DESC);
    NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withFilter(builder).withSort(sortBuilder).withPageable(pageable);
    Query searchQuery = builder1.build();



    return     SearchHitSupport.searchPageFor(operations.search(searchQuery, PostData.class),pageable);
  }

  @Override
  public SearchPage<PostData> searchPostByName(String title, Pageable pageable){
    Criteria criteria = new Criteria("title").contains(title);

    Query searchQuery = new CriteriaQuery(criteria,pageable);
    Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"post_dt.keyword"));
    searchQuery.addSort(sort);

    return  SearchHitSupport.searchPageFor(operations
            .search(searchQuery,
                    PostData.class),pageable);
  }

  private List<PostData>toResultData(List<SearchHit<PostData>> searchHits) {
    System.out.println("searchHits.size() "+searchHits.size());

    return searchHits.stream()
            .map(searchHit -> {
              PostData post = searchHit.getContent();
              return post;
            }).collect(Collectors.toList());
  }

//  private List<SearchHit<Post>> searchByCategory(String category){
//    Criteria criteria = new Criteria("category").contains(category);
//
//    Query searchQuery = new CriteriaQuery(criteria);
//    Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"post_dt.keyword"));
//    searchQuery.addSort(sort);
//
//    return  operations
//            .search(searchQuery,
//                    Post.class).getSearchHits();
//  }
}
