package sg.com.studymama.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import sg.com.studymama.Util;
import sg.com.studymama.model.Post;
import sg.com.studymama.model.UserDTO;
import sg.com.studymama.service.SpringDataPostService;
import sg.com.studymama.service.SpringDataPostServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PostControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SpringDataPostService springDataPostService;

    private  List<Post> posts;

    @Before
    public void setUp() throws IOException {
        // get all rows from DB
        LOGGER.info("Loading POI data...");
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to customer object
        posts = objectMapper.readValue(new File("sample_data.json"), new TypeReference<List<Post>>(){});


        //print customer details
        System.out.println(Arrays.toString(posts.toArray()));
        LOGGER.info("Finished loading POI data.");
    }

    @Test
    public  void findAllTest() throws Exception {
        String uri = "/postService/allPost";
        Pageable paging = PageRequest.of(0, 3);

        final Page<Post> page = new PageImpl<>(posts, paging, posts.size());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("currentPage", "0");
        map.add("pageSize", "3");

        when(springDataPostService.getAllPost(any(Pageable.class))).thenReturn(page);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).queryParams(map))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }



}
