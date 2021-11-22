package hercerm.uady.fmtreviewsback.controllers;

import com.google.gson.Gson;
import hercerm.uady.fmtreviewsback.dtos.*;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import hercerm.uady.fmtreviewsback.services.RecommendedResourceService;
import hercerm.uady.fmtreviewsback.utils.StringPlaceholders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecommendedResourceController.class) // SUT
class RecommendedResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    Gson gson;

    @MockBean
    private RecommendedResourceService recommendedResourceService;

    @Test
    void getRecommendedResourcesByCourseId() throws Exception {

        // setup - data
        List<RecommendedResourceBookDto> books = List.of(RecommendedResourceBookDto.builder()
                .title("Inferencia Estadística Para Dummies")
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .build());

        List<RecommendedResourceVideoDto> videos = List.of(RecommendedResourceVideoDto.builder()
                .title("¿Qué son los intervalos de confianza?")
                .description(StringPlaceholders.LOREM_IPSUM_MEDIUM)
                .build());

        List<RecommendedResourceWebsiteDto> websites = List.of(RecommendedResourceWebsiteDto.builder()
                .title("Fundamentos del curso")
                .description("https://inferencia_estadistica.com")
                .build());

        RecommendedResourceTypeDto resourceBookType = new RecommendedResourceTypeDto(RecommendedResourceType.BOOK);
        RecommendedResourceTypeDto resourceVideoType = new RecommendedResourceTypeDto(RecommendedResourceType.VIDEO);
        RecommendedResourceTypeDto resourceWebsiteType = new RecommendedResourceTypeDto(RecommendedResourceType.WEBSITE);

        List<RecommendedResourceAggregatorDto<?>> resourcesForTheCourse = List.of(
                new RecommendedResourceAggregatorDto<>(resourceBookType, books),
                new RecommendedResourceAggregatorDto<>(resourceVideoType, videos),
                new RecommendedResourceAggregatorDto<>(resourceWebsiteType, websites)
        );

        // setup - mocks
        when(recommendedResourceService.getByCourseId(anyLong())).thenReturn(resourcesForTheCourse);

        // exercise
        mockMvc.perform(get(CourseController.BASE_URL + "/1/recommended-resources"))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(3)));

        // verify - mocks
        verify(recommendedResourceService).getByCourseId(anyLong());
    }

    @Test
    void createRecommendedResource_book() throws Exception {

        // setup - data
        RecommendedResourceTypeDto resourceBookType = new RecommendedResourceTypeDto(1L, RecommendedResourceType.BOOK);

        CourseDto course = new CourseDto(1L, "Course");

        RecommendedResourceBookDto requestBook = RecommendedResourceBookDto.builder()
                .title("Title")
                .description("Description")
                .build();

        RecommendedResourceBookDto responseBook = RecommendedResourceBookDto.builder()
                .id(1L)
                .title("Title")
                .description("Description")
                .type(resourceBookType)
                .course(course)
                .build();

        // setup - mocks
        when(recommendedResourceService.create(gson.toJson(requestBook), RecommendedResourceType.BOOK, 1L))
                .thenReturn(responseBook);

        // exercise
        mockMvc.perform(post(CourseController.BASE_URL + "/1/recommended-resources")
                        .queryParam("resourceTypeName", RecommendedResourceType.BOOK)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(requestBook)))

                // verify - data
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                // Verify that fields which were not in the original request are now populated.
                .andExpect(jsonPath("$.course.id", is(1)))
                .andExpect(jsonPath("$.type.id", is(1)));


        // verify - mocks
        verify(recommendedResourceService).create(gson.toJson(requestBook), RecommendedResourceType.BOOK, 1L);
    }

    @Test
    void createRecommendedResource_video() throws Exception {

        // setup - data
        RecommendedResourceTypeDto resourceBookType = new RecommendedResourceTypeDto(1L, RecommendedResourceType.VIDEO);

        CourseDto course = new CourseDto(1L, "Course");

        RecommendedResourceVideoDto requestVideo = RecommendedResourceVideoDto.builder()
                .title("Title")
                .description("Description")
                .build();

        RecommendedResourceVideoDto responseVideo = RecommendedResourceVideoDto.builder()
                .id(1L)
                .title("Title")
                .description("Description")
                .type(resourceBookType)
                .course(course)
                .build();

        // setup - mocks
        when(recommendedResourceService.create(gson.toJson(requestVideo), RecommendedResourceType.VIDEO, 1L))
                .thenReturn(responseVideo);

        // exercise
        mockMvc.perform(post(CourseController.BASE_URL + "/1/recommended-resources")
                        .queryParam("resourceTypeName", RecommendedResourceType.VIDEO)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(requestVideo)))

                // verify - data
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                // Verify that fields which were not in the original request are now populated.
                .andExpect(jsonPath("$.course.id", is(1)))
                .andExpect(jsonPath("$.type.id", is(1)));


        // verify - mocks
        verify(recommendedResourceService).create(gson.toJson(requestVideo), RecommendedResourceType.VIDEO, 1L);
    }

    @Test
    void createRecommendedResource_website() throws Exception {

        // setup - data
        RecommendedResourceTypeDto resourceWebsiteType = new RecommendedResourceTypeDto(1L, RecommendedResourceType.WEBSITE);

        CourseDto course = new CourseDto(1L, "Course");

        RecommendedResourceWebsiteDto requestWebsite = RecommendedResourceWebsiteDto.builder()
                .title("Title")
                .description("Description")
                .build();

        RecommendedResourceWebsiteDto responseWebsite = RecommendedResourceWebsiteDto.builder()
                .id(1L)
                .title("Title")
                .description("Description")
                .type(resourceWebsiteType)
                .course(course)
                .build();

        // setup - mocks
        when(recommendedResourceService.create(gson.toJson(requestWebsite), RecommendedResourceType.WEBSITE, 1L))
                .thenReturn(responseWebsite);

        // exercise
        mockMvc.perform(post(CourseController.BASE_URL + "/1/recommended-resources")
                        .queryParam("resourceTypeName", RecommendedResourceType.WEBSITE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(requestWebsite)))

                // verify - data
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                // Verify that fields which were not in the original request are now populated.
                .andExpect(jsonPath("$.course.id", is(1)))
                .andExpect(jsonPath("$.type.id", is(1)));


        // verify - mocks
        verify(recommendedResourceService).create(gson.toJson(requestWebsite), RecommendedResourceType.WEBSITE, 1L);
    }
}