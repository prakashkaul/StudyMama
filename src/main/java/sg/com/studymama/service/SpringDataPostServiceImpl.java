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
import sg.com.studymama.model.Post;
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


  public Post createPost(Post Post) {

    return postRepository.save(Post);
  }

  public Optional<Post> getPost(String id) {
    return postRepository.findById(id);
  }

  public void deletePost(String id) {
    postRepository.deleteById(id);
  }

  @Override
  public Iterable<Post> insertBulkPost(Page<Post>Posts) {
    return postRepository.saveAll(Posts);
  }

  @Override
  public Page<Post>getPostsByCategory(String category,Pageable pageable) {
    return postRepository.findAllByCategory(category,pageable);
  }

  @Override
  public Page<Post> getAllPost(Pageable pageable) {
    return postRepository.findAll(pageable);
  }

  @Override
  public Page<Post>searchPostBySimilarTitle(String title,Pageable pageable) {
    return postRepository.findPostBySimilarTitle(title,pageable);
  }

  @Override
  public Page<Post>searchPostBySimilarCategory(String category,Pageable pageable) {
    return postRepository.findPostBySimilarCategory(category,pageable);
  }

  @Override
  public Page<Post>searchPostByCategory(String category,Pageable pageable) {
    return postRepository.findAllByCategory(category,pageable);
  }

  @Override
  public Page<Post>searchPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable) {
    return postRepository.findPostsByByKeywordInTitleDescriptionCategory(keyword,pageable);
  }

  public Iterable<Post> insertBulk(Page<Post>Posts) {
    return postRepository.saveAll(Posts);
  }

  public Page<Post> getPostsByName(String name,Pageable pageable) {
    return postRepository.findAllByCategory(name,pageable);
  }



  public SearchPage<Post> searchWithin(GeoPoint geoPoint, Double distance, String unit, Pageable pageable) {

    GeoDistanceQueryBuilder builder = QueryBuilders.geoDistanceQuery("location").point(geoPoint.getLat(), geoPoint.getLon())
            .distance(distance, DistanceUnit.METERS);

    GeoDistanceSortBuilder sortBuilder = SortBuilders.geoDistanceSort("location",geoPoint.getLat(),geoPoint.getLon())
            .point(geoPoint.getLat(), geoPoint.getLon())
            .unit(DistanceUnit.METERS)
            .order(SortOrder.DESC);
    NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withFilter(builder).withSort(sortBuilder).withPageable(pageable);
    Query searchQuery = builder1.build();



    return     SearchHitSupport.searchPageFor(operations.search(searchQuery, Post.class),pageable);
  }

  @Override
  public SearchPage<Post> searchPostByName(String title, Pageable pageable){
    Criteria criteria = new Criteria("title").contains(title);

    Query searchQuery = new CriteriaQuery(criteria,pageable);
    Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC,"post_dt.keyword"));
    searchQuery.addSort(sort);

    return  SearchHitSupport.searchPageFor(operations
            .search(searchQuery,
                    Post.class),pageable);
  }

  private List<Post>toResultData(List<SearchHit<Post>> searchHits) {
    System.out.println("searchHits.size() "+searchHits.size());

    return searchHits.stream()
            .map(searchHit -> {
              Post post = searchHit.getContent();
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
