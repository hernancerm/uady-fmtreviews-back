package hercerm.uady.fmtreviewsback.controllers;

import com.google.gson.Gson;
import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterPointedDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfessorReviewController.class) // SUT
class ProfessorReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private ProfessorReviewService professorReviewService;

    @Test
    void getAllByProfessorId() throws Exception {
        // setup - data
        List<ProfessorReviewDto> professorReviews = List.of(
                ProfessorReviewDto.builder().description("Stub review 1").build(),
                ProfessorReviewDto.builder().description("Stub review 2").build()
        );

        // setup - mocks
        when(professorReviewService.getAllByProfessorId(1L)).thenReturn(professorReviews);

        // exercise
        mockMvc.perform(get(ProfessorController.BASE_URL + "/1/reviews"))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(professorReviews.size())));

        // verify - mocks
        verify(professorReviewService).getAllByProfessorId(1L);
    }

    @Test
    void createProfessorReview() throws Exception {

        // setup - data
        StudentSatisfactionParameterDto parameter1 = new StudentSatisfactionParameterDto(
                StudentSatisfactionParameter.EXPERTISE);
        StudentSatisfactionParameterDto parameter2 = new StudentSatisfactionParameterDto(
                StudentSatisfactionParameter.EXPLANATIONS);
        StudentSatisfactionParameterDto parameter3 = new StudentSatisfactionParameterDto(
                StudentSatisfactionParameter.AD_HOC_HELP);

        ProfessorCharacteristicDto characteristic1 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.REQUIRES_ENGLISH);
        ProfessorCharacteristicDto characteristic2 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.TEACHES_MOST_CLASSES);
        ProfessorCharacteristicDto characteristic3 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.TIMELINESS_REQUIRED);

        ProfessorReviewDto submittedProfessorReview = ProfessorReviewDto.builder()
                .description("Stub review description")
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(4.0, parameter1),
                        new StudentSatisfactionParameterPointedDto(3.0, parameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, parameter3)
                ))
                .professorCharacteristics(List.of(characteristic1, characteristic2, characteristic3))
                .build();

        ProfessorReviewDto savedProfessorReview = ProfessorReviewDto.builder()
                .id(1L)
                .description("Stub review description")
                .studentSatisfactionGrade(4.0)
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(4.0, parameter1),
                        new StudentSatisfactionParameterPointedDto(3.0, parameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, parameter3)
                ))
                .professorCharacteristics(List.of(characteristic1, characteristic2, characteristic3))
                .build();

        // setup - mocks
        when(professorReviewService.create(1L, submittedProfessorReview)).thenReturn(savedProfessorReview);

        // exercise
        mockMvc.perform(post(ProfessorController.BASE_URL + "/1/reviews")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(submittedProfessorReview)))

                // verify - data
                .andExpect(status().isCreated())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                // Verify that fields which were not in the original request are now populated.
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.studentSatisfactionGrade", is(4.0)));

        // verify - mocks
        verify(professorReviewService).create(1L, submittedProfessorReview);
    }
}