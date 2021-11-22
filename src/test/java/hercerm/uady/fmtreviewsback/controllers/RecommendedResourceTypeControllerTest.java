package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceTypeDto;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import hercerm.uady.fmtreviewsback.services.RecommendedResourceTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecommendedResourceTypeController.class) // SUT
class RecommendedResourceTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecommendedResourceTypeService recommendedResourceTypeService;

    @Test
    void getAllRecommendedResourceTypes() throws Exception {
        // setup - data
        List<RecommendedResourceTypeDto> recommendedResources = List.of(
                new RecommendedResourceTypeDto(RecommendedResourceType.BOOK),
                new RecommendedResourceTypeDto(RecommendedResourceType.VIDEO),
                new RecommendedResourceTypeDto(RecommendedResourceType.WEBSITE)
        );

        // setup - mocks
        when(recommendedResourceTypeService.getAll()).thenReturn(recommendedResources);

        // exercise
        mockMvc.perform(get(RecommendedResourceTypeController.BASE_URL))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(recommendedResources.size())));

        // verify - mocks
        verify(recommendedResourceTypeService).getAll();
    }
}