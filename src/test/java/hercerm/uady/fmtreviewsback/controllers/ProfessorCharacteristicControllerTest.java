package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.services.ProfessorCharacteristicService;
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

@WebMvcTest(ProfessorCharacteristicController.class) // SUT
class ProfessorCharacteristicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessorCharacteristicService professorCharacteristicService;

    @Test
    void getAllProfessorCharacteristics() throws Exception {
        // setup - data
        List<ProfessorCharacteristicDto> professorCharacteristics = List.of(
                new ProfessorCharacteristicDto(ProfessorCharacteristic.TIMELINESS_REQUIRED),
                new ProfessorCharacteristicDto(ProfessorCharacteristic.TEACHES_MOST_CLASSES),
                new ProfessorCharacteristicDto(ProfessorCharacteristic.REQUIRES_ENGLISH)
        );

        // setup - mocks
        when(professorCharacteristicService.getAll()).thenReturn(professorCharacteristics);

        // exercise
        mockMvc.perform(get(ProfessorCharacteristicController.BASE_URL))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(professorCharacteristics.size())));

        // verify - mocks
        verify(professorCharacteristicService).getAll();
    }
}