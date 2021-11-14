package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.services.ProfessorService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfessorController.class) // SUT
class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessorService professorService;

    @Test
    void getAllProfessors() throws Exception {
        // setup - data
        List<ProfessorDto> professors = List.of(
                ProfessorDto.builder().firstNames("Gina").lastNames("Down").build(),
                ProfessorDto.builder().firstNames("Eloise").lastNames("Fisher").build()
        );

        // setup - mocks
        when(professorService.getAll()).thenReturn(professors);

        // exercise
        mockMvc.perform(get(ProfessorController.BASE_URL))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(professors.size())));

        // verify - mocks
        verify(professorService).getAll();
    }

    @Test
    void getProfessorById() throws Exception {
        // setup - data
        ProfessorDto professorDto = ProfessorDto.builder().id(1L).firstNames("Gina").lastNames("Down").build();

        // setup - mocks
        when(professorService.getById(1L)).thenReturn(professorDto);

        // exercise
        mockMvc.perform(get(ProfessorController.BASE_URL + "/1"))

                // verify - data
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstNames", is("Gina")))
                .andExpect(jsonPath("$.lastNames", is("Down")));

        // verify - mocks
        verify(professorService).getById(1L);
    }

    @Test
    void getProfessorProfileImageById() throws Exception {
        // setup - data
        byte[] image = new byte[0]; // empty image.

        // setup - mocks
        when(professorService.getProfileImage(1L)).thenReturn(image);

        // exercise
        mockMvc.perform(get(ProfessorController.BASE_URL + "/1/profile-image"))

                // verify - data
                .andExpect(header().string("Content-Type", MediaType.IMAGE_PNG_VALUE))
                .andExpect(status().isOk());

        // verify - mocks
        verify(professorService).getProfileImage(1L);
    }
}