package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.services.StudentSatisfactionParameterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(StudentSatisfactionParameterController.BASE_URL)
public class StudentSatisfactionParameterController {

    public static final String BASE_URL =
            ProfessorController.BASE_URL + "/student-satisfaction-parameters";

    private final StudentSatisfactionParameterService studentSatisfactionParameterService;

    public StudentSatisfactionParameterController(
            StudentSatisfactionParameterService studentSatisfactionParameterService) {
        this.studentSatisfactionParameterService = studentSatisfactionParameterService;
    }

    @GetMapping
    public List<StudentSatisfactionParameterDto> getAllStudentSatisfactionParameters() {
        return studentSatisfactionParameterService.getAll();
    }
}
