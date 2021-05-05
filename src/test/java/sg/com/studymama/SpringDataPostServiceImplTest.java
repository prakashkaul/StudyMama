package sg.com.studymama;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import sg.com.studymama.model.PostData;
import sg.com.studymama.repository.PostElasticSearchRepository;
import sg.com.studymama.service.SpringDataPostServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SpringDataPostServiceImplTest {
    @Mock
    private PostElasticSearchRepository postRepository;

    @InjectMocks
    private SpringDataPostServiceImpl springDataPostService;

    List<PostData> posts;

    @Before
    public void setUp() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //read json file and convert to customer object
         posts = objectMapper.readValue(new File("sample_data.json"), new TypeReference<List<PostData>>(){});
        //print customer details
        System.out.println(Arrays.toString(posts.toArray()));
    }

    @Test
    public void createPostTest() throws IOException {
        final PostData post = posts.get(0);
        when(postRepository.save(post))
                .thenReturn(post);

        final PostData result = springDataPostService.createPost(post);
        assertEquals(result,post);

    }

    @Test
    public void getPostTest() throws IOException {
        when(postRepository.findById("1"))
                .thenReturn(Optional.ofNullable(posts.get(0)));
        final Optional<PostData> result = springDataPostService.getPost("1");
        assertEquals(result.get(),posts.get(0));

    }

    @Test
    public void deletePostTest() throws IOException {
        PostData post = posts.get(5);
        doNothing().when(postRepository).deleteById("1");
        springDataPostService.deletePost("1");
        verify(postRepository).deleteById(any(String.class));

    }

    @Test
    public void getPostsByCategoryTest() throws IOException {
        PostData post = posts.get(5);
        doNothing().when(postRepository).deleteById("1");
        springDataPostService.deletePost("1");
        verify(postRepository).deleteById(any(String.class));

    }


//    Optional<Post> getPost(String id);
//
//    void deletePost(String id);
//
//    Iterable<Post> insertBulkPost(Page<Post> Posts);
//
//    Page<Post> getPostsByCategory(String category, Pageable pageable);
//
//    Page<Post> getAllPost(Pageable pageable);
//
//    Page<Post> searchPostBySimilarTitle(String title,Pageable pageable);
//    SearchPage<Post> searchPostByName(String title, Pageable pageable);
//
//    Page<Post> searchPostBySimilarCategory(String category,Pageable pageable);
//
//    Page<Post> searchPostByCategory(String category,Pageable pageable);
//
//    Page<Post> searchPostsByByKeywordInTitleDescriptionCategory(String keyword,Pageable pageable);
//
//    SearchPage<Post> searchWithin(GeoPoint geoPoint, Double distance, String unit, Pageable pageable);
}
