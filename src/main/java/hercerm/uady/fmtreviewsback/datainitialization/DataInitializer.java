package hercerm.uady.fmtreviewsback.datainitialization;

import com.google.gson.Gson;
import hercerm.uady.fmtreviewsback.dtos.*;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.entities.RecommendedResourceType;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import hercerm.uady.fmtreviewsback.services.*;
import hercerm.uady.fmtreviewsback.utils.StringPlaceholders;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProfessorService professorService;
    private final ProfessorReviewService professorReviewService;
    private final ProfessorCharacteristicService professorCharacteristicService;
    private final StudentSatisfactionParameterService studentSatisfactionParameterService;

    private final CourseService courseService;

    private final RecommendedResourceService recommendedResourceService;
    private final RecommendedResourceTypeService recommendedResourceTypeService;

    private final Gson gson;

    public DataInitializer(ProfessorService professorService,
                           ProfessorReviewService professorReviewService,
                           ProfessorCharacteristicService professorCharacteristicService,
                           StudentSatisfactionParameterService studentSatisfactionParameterService,

                           CourseService courseService,

                           RecommendedResourceService recommendedResourceService,
                           RecommendedResourceTypeService recommendedResourceTypeService,

                           Gson gson) {
        this.professorService = professorService;
        this.professorReviewService = professorReviewService;
        this.professorCharacteristicService = professorCharacteristicService;
        this.studentSatisfactionParameterService = studentSatisfactionParameterService;

        this.courseService = courseService;

        this.recommendedResourceService = recommendedResourceService;
        this.recommendedResourceTypeService = recommendedResourceTypeService;

        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {

        // Professor characteristics
        ProfessorCharacteristicDto characteristic1 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.INTERESTED_IN_SUBJECT);
        ProfessorCharacteristicDto characteristic2 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.REQUIRES_ENGLISH);
        ProfessorCharacteristicDto characteristic3 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.GRADES_TRANSPARENTLY);
        ProfessorCharacteristicDto characteristic4 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.TEACHES_MOST_CLASSES);
        ProfessorCharacteristicDto characteristic5 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.PROVIDES_USEFUL_RESOURCES);
        ProfessorCharacteristicDto characteristic6 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.TIMELINESS_REQUIRED);

        ProfessorCharacteristicDto savedCharacteristic1 = professorCharacteristicService.create(characteristic1);
        ProfessorCharacteristicDto savedCharacteristic2 = professorCharacteristicService.create(characteristic2);
        ProfessorCharacteristicDto savedCharacteristic3 = professorCharacteristicService.create(characteristic3);
        ProfessorCharacteristicDto savedCharacteristic4 = professorCharacteristicService.create(characteristic4);
        ProfessorCharacteristicDto savedCharacteristic5 = professorCharacteristicService.create(characteristic5);
        ProfessorCharacteristicDto savedCharacteristic6 = professorCharacteristicService.create(characteristic6);

        // Student satisfaction parameters
        StudentSatisfactionParameterDto parameter1 = new StudentSatisfactionParameterDto(
                StudentSatisfactionParameter.EXPERTISE
        );
        StudentSatisfactionParameterDto parameter2 = new StudentSatisfactionParameterDto(
                StudentSatisfactionParameter.EXPLANATIONS
        );
        StudentSatisfactionParameterDto parameter3 = new StudentSatisfactionParameterDto(
                StudentSatisfactionParameter.AD_HOC_HELP
        );

        StudentSatisfactionParameterDto savedParameter1 =  studentSatisfactionParameterService.create(parameter1);
        StudentSatisfactionParameterDto savedParameter2 =  studentSatisfactionParameterService.create(parameter2);
        StudentSatisfactionParameterDto savedParameter3 =  studentSatisfactionParameterService.create(parameter3);

        // Professor 1
        ProfessorDto professor1 = ProfessorDto.builder()
                .firstNames("Juan")
                .lastNames("García")
                .build();

        ProfessorReviewDto professor1review1 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_MEDIUM)
                .professorCharacteristics(List.of(savedCharacteristic1, savedCharacteristic2, savedCharacteristic5))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(3.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(4.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter3)
                ))
                .build();

        ProfessorReviewDto professor1review2 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_LONG)
                .professorCharacteristics(List.of(savedCharacteristic2, savedCharacteristic3, savedCharacteristic4))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(2.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(3.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter3)
                ))
                .build();

        ProfessorReviewDto professor1review3 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic5, savedCharacteristic6, savedCharacteristic1))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(4.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(4.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter3)
                ))
                .build();

        // Professor 2
        ProfessorDto professor2 = ProfessorDto.builder()
                .firstNames("María")
                .lastNames("Ayala")
                .build();

        ProfessorReviewDto professor2review1 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_TINY)
                .professorCharacteristics(List.of(savedCharacteristic2, savedCharacteristic3, savedCharacteristic6))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(2.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(3.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(3.0, savedParameter3)
                ))
                .build();

        ProfessorReviewDto professor2review2 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic1, savedCharacteristic2, savedCharacteristic4))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(2.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(3.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(4.0, savedParameter3)
                ))
                .build();

        ProfessorReviewDto professor2review3 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic3, savedCharacteristic5, savedCharacteristic2))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(2.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(3.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(2.0, savedParameter3)
                ))
                .build();

        // Professor 3
        ProfessorDto professor3 = ProfessorDto.builder()
                .firstNames("Josué")
                .lastNames("Suárez")
                .build();

        ProfessorReviewDto professor3review1 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_TINY)
                .professorCharacteristics(List.of(savedCharacteristic2, savedCharacteristic3, savedCharacteristic6))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(4.0, savedParameter3)
                ))
                .build();

        ProfessorReviewDto professor3review2 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic1, savedCharacteristic2, savedCharacteristic4))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter3)
                ))
                .build();

        ProfessorReviewDto professor3review3 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic3, savedCharacteristic5, savedCharacteristic2))
                .studentSatisfactionGrades(List.of(
                        new StudentSatisfactionParameterPointedDto(4.0, savedParameter1),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter2),
                        new StudentSatisfactionParameterPointedDto(5.0, savedParameter3)
                ))
                .build();


        /* Persist professor data - what hasn't been persisted yet */

        // Professors
        ProfessorDto savedProfessor1 = professorService.create(professor1);
        ProfessorDto savedProfessor2 = professorService.create(professor2);
        ProfessorDto savedProfessor3 = professorService.create(professor3);

        // Profile images
        professorService.saveProfileImage(savedProfessor1.getId(), new byte[0]);
        professorService.saveProfileImage(savedProfessor2.getId(), new byte[0]);
        professorService.saveProfileImage(savedProfessor3.getId(), new byte[0]);

        // Reviews
        professorReviewService.create(savedProfessor1.getId(), professor1review1);
        professorReviewService.create(savedProfessor1.getId(), professor1review2);
        professorReviewService.create(savedProfessor1.getId(), professor1review3);

        professorReviewService.create(savedProfessor2.getId(), professor2review1);
        professorReviewService.create(savedProfessor2.getId(), professor2review2);
        professorReviewService.create(savedProfessor2.getId(), professor2review3);

        professorReviewService.create(savedProfessor3.getId(), professor3review1);
        professorReviewService.create(savedProfessor3.getId(), professor3review2);
        professorReviewService.create(savedProfessor3.getId(), professor3review3);


        // Courses
        CourseDto course1 = new CourseDto("Inferencia Estadística");
        CourseDto course2 = new CourseDto("Programación Orientada a Objetos");

        CourseDto savedCourse1 = courseService.create(course1);
        CourseDto savedCourse2 = courseService.create(course2);

        // Course recommended resource types
        RecommendedResourceTypeDto resourceType1 = new RecommendedResourceTypeDto(RecommendedResourceType.BOOK);
        RecommendedResourceTypeDto resourceType2 = new RecommendedResourceTypeDto(RecommendedResourceType.VIDEO);
        RecommendedResourceTypeDto resourceType3 = new RecommendedResourceTypeDto(RecommendedResourceType.WEBSITE);

        RecommendedResourceTypeDto savedResourceType1 = recommendedResourceTypeService.create(resourceType1);
        RecommendedResourceTypeDto savedResourceType2 = recommendedResourceTypeService.create(resourceType2);
        RecommendedResourceTypeDto savedResourceType3 = recommendedResourceTypeService.create(resourceType3);

        // Course recommended resources

        // For "Inferencia estadística"
        RecommendedResourceBookDto ieResourceBook1 = RecommendedResourceBookDto.builder()
                .title("Inferencia Estadística Para Dummies")
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .build();

        RecommendedResourceVideoDto ieResourceVideo1 = RecommendedResourceVideoDto.builder()
                .title("¿Qué son los intervalos de confianza?")
                .description(StringPlaceholders.LOREM_IPSUM_MEDIUM)
                .build();

        RecommendedResourceWebsiteDto ieResourceWebsite1 = RecommendedResourceWebsiteDto.builder()
                .title("Fundamentos del curso")
                .description("https://inferencia_estadistica.com")
                .build();

        recommendedResourceService.create(gson.toJson(ieResourceBook1), RecommendedResourceType.BOOK, savedCourse1.getId());
        recommendedResourceService.create(gson.toJson(ieResourceVideo1), RecommendedResourceType.VIDEO, savedCourse1.getId());
        recommendedResourceService.create(gson.toJson(ieResourceWebsite1), RecommendedResourceType.WEBSITE, savedCourse1.getId());

        // For "Programación Orientada a Objetos"
        RecommendedResourceBookDto pooResourceBook1 = RecommendedResourceBookDto.builder()
                .title("POO Para Dummies")
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .build();

        RecommendedResourceVideoDto pooResourceVideo1 = RecommendedResourceVideoDto.builder()
                .title("Polimorfismo vs. Herencia")
                .description(StringPlaceholders.LOREM_IPSUM_MEDIUM)
                .build();

        RecommendedResourceWebsiteDto pooResourceWebsite1 = RecommendedResourceWebsiteDto.builder()
                .title("Fundamentos del curso")
                .description("https://poo.com")
                .build();

        recommendedResourceService.create(gson.toJson(pooResourceBook1), RecommendedResourceType.BOOK, savedCourse2.getId());
        recommendedResourceService.create(gson.toJson(pooResourceVideo1), RecommendedResourceType.VIDEO, savedCourse2.getId());
        recommendedResourceService.create(gson.toJson(pooResourceWebsite1), RecommendedResourceType.WEBSITE, savedCourse2.getId());
    }
}
