package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import hercerm.uady.fmtreviewsback.services.ProfessorCharacteristicService;
import hercerm.uady.fmtreviewsback.services.StudentSatisfactionParameterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentSatisfactionParameterController.class) // SUT
class StudentSatisfactionParameterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentSatisfactionParameterService studentSatisfactionParameterService;

    @Test
    void getAllStudentSatisfactionParameters() throws Exception {
        // setup - data
        List<StudentSatisfactionParameterDto> professorSatisfactionParameters = List.of(
                new StudentSatisfactionParameterDto(StudentSatisfactionParameter.EXPERTISE),
                new StudentSatisfactionParameterDto(StudentSatisfactionParameter.AD_HOC_HELP),
                new StudentSatisfactionParameterDto(StudentSatisfactionParameter.EXPLANATIONS)
        );

        // setup - mocks
        when(studentSatisfactionParameterService.getAll()).thenReturn(professorSatisfactionParameters);

        // exercise
        mockMvc.perform(get(StudentSatisfactionParameterController.BASE_URL))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(professorSatisfactionParameters.size())));

        // verify - mocks
        verify(studentSatisfactionParameterService).getAll();
    }
}