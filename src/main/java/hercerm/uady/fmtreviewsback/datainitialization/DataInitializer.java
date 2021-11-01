package hercerm.uady.fmtreviewsback.datainitialization;

import hercerm.uady.fmtreviewsback.dtos.ProfessorCharacteristicDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.ProfessorReviewDto;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.services.ProfessorCharacteristicService;
import hercerm.uady.fmtreviewsback.services.ProfessorReviewService;
import hercerm.uady.fmtreviewsback.services.ProfessorService;
import hercerm.uady.fmtreviewsback.utils.StringPlaceholders;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProfessorService professorService;
    private final ProfessorReviewService professorReviewService;
    private final ProfessorCharacteristicService professorCharacteristicService;

    public DataInitializer(ProfessorService professorService,
                           ProfessorReviewService professorReviewService,
                           ProfessorCharacteristicService professorCharacteristicService) {
        this.professorService = professorService;
        this.professorReviewService = professorReviewService;
        this.professorCharacteristicService = professorCharacteristicService;
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
                ProfessorCharacteristic.Provides_USEFUL_RESOURCES);
        ProfessorCharacteristicDto characteristic6 = new ProfessorCharacteristicDto(
                ProfessorCharacteristic.TIMELINESS_REQUIRED);

        ProfessorCharacteristicDto savedCharacteristic1 = professorCharacteristicService.create(characteristic1);
        ProfessorCharacteristicDto savedCharacteristic2 = professorCharacteristicService.create(characteristic2);
        ProfessorCharacteristicDto savedCharacteristic3 = professorCharacteristicService.create(characteristic3);
        ProfessorCharacteristicDto savedCharacteristic4 = professorCharacteristicService.create(characteristic4);
        ProfessorCharacteristicDto savedCharacteristic5 = professorCharacteristicService.create(characteristic5);
        ProfessorCharacteristicDto savedCharacteristic6 = professorCharacteristicService.create(characteristic6);

        // Professor 1
        ProfessorDto professor1 = ProfessorDto.builder()
                .firstNames("Juan")
                .lastNames("García")
                .profileImage("profile_image__juan_garcia.png")
                .build();

        ProfessorReviewDto professor1review1 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_MEDIUM)
                .professorCharacteristics(List.of(savedCharacteristic1, savedCharacteristic2, savedCharacteristic5))
                .sspExpertise(3)
                .sspExplanationQuality(4)
                .sspWillingnessToHelp(5)
                .build();

        ProfessorReviewDto professor1review2 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_LONG)
                .professorCharacteristics(List.of(savedCharacteristic2, savedCharacteristic3, savedCharacteristic4))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(5)
                .build();

        ProfessorReviewDto professor1review3 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic5, savedCharacteristic6, savedCharacteristic1))
                .sspExpertise(4)
                .sspExplanationQuality(4)
                .sspWillingnessToHelp(5)
                .build();

        // Professor 2
        ProfessorDto professor2 = ProfessorDto.builder()
                .firstNames("María")
                .lastNames("Ayala")
                .profileImage("profile_image__maria_ayala.png")
                .build();

        ProfessorReviewDto professor2review1 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_TINY)
                .professorCharacteristics(List.of(savedCharacteristic2, savedCharacteristic3, savedCharacteristic6))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(3)
                .build();

        ProfessorReviewDto professor2review2 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic1, savedCharacteristic2, savedCharacteristic4))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(4)
                .build();

        ProfessorReviewDto professor2review3 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic3, savedCharacteristic5, savedCharacteristic2))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(2)
                .build();

        // Professor 3
        ProfessorDto professor3 = ProfessorDto.builder()
                .firstNames("Josué")
                .lastNames("Suárez")
                .profileImage("profile_image__josue_suarez.png")
                .build();

        ProfessorReviewDto professor3review1 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_TINY)
                .professorCharacteristics(List.of(savedCharacteristic2, savedCharacteristic3, savedCharacteristic6))
                .sspExpertise(1)
                .sspExplanationQuality(2)
                .sspWillingnessToHelp(3)
                .build();

        ProfessorReviewDto professor3review2 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic1, savedCharacteristic2, savedCharacteristic4))
                .sspExpertise(1)
                .sspExplanationQuality(1)
                .sspWillingnessToHelp(2)
                .build();

        ProfessorReviewDto professor3review3 = ProfessorReviewDto.builder()
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(List.of(savedCharacteristic3, savedCharacteristic5, savedCharacteristic2))
                .sspExpertise(2)
                .sspExplanationQuality(2)
                .sspWillingnessToHelp(3)
                .build();

        ProfessorDto savedProfessor1 = professorService.create(professor1);
        ProfessorDto savedProfessor2 = professorService.create(professor2);
        ProfessorDto savedProfessor3 = professorService.create(professor3);

        professorReviewService.create(savedProfessor1.getId(), professor1review1);
        professorReviewService.create(savedProfessor1.getId(), professor1review2);
        professorReviewService.create(savedProfessor1.getId(), professor1review3);

        professorReviewService.create(savedProfessor2.getId(), professor2review1);
        professorReviewService.create(savedProfessor2.getId(), professor2review2);
        professorReviewService.create(savedProfessor2.getId(), professor2review3);

        professorReviewService.create(savedProfessor3.getId(), professor3review1);
        professorReviewService.create(savedProfessor3.getId(), professor3review2);
        professorReviewService.create(savedProfessor3.getId(), professor3review3);
    }
}
