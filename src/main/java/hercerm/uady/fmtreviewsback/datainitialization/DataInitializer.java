package hercerm.uady.fmtreviewsback.datainitialization;

import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.entities.ProfessorCharacteristic;
import hercerm.uady.fmtreviewsback.entities.ProfessorReview;
import hercerm.uady.fmtreviewsback.repositories.ProfessorCharacteristicRepository;
import hercerm.uady.fmtreviewsback.repositories.ProfessorRepository;
import hercerm.uady.fmtreviewsback.repositories.ProfessorReviewRepository;
import hercerm.uady.fmtreviewsback.utils.StringPlaceholders;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static hercerm.uady.fmtreviewsback.math.ProfessorScores.populateProfessorScores;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProfessorRepository professorRepository;
    private final ProfessorReviewRepository professorReviewRepository;
    private final ProfessorCharacteristicRepository professorCharacteristicRepository;

    public DataInitializer(ProfessorRepository professorRepository,
                           ProfessorReviewRepository professorReviewRepository,
                           ProfessorCharacteristicRepository professorCharacteristicRepository) {
        this.professorRepository = professorRepository;
        this.professorReviewRepository = professorReviewRepository;
        this.professorCharacteristicRepository = professorCharacteristicRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Professor characteristics
        ProfessorCharacteristic characteristic1 = new ProfessorCharacteristic(
                ProfessorCharacteristic.INTERESTED_IN_SUBJECT);
        ProfessorCharacteristic characteristic2 = new ProfessorCharacteristic(
                ProfessorCharacteristic.REQUIRES_ENGLISH);
        ProfessorCharacteristic characteristic3 = new ProfessorCharacteristic(
                ProfessorCharacteristic.GRADES_TRANSPARENTLY);
        ProfessorCharacteristic characteristic4 = new ProfessorCharacteristic(
                ProfessorCharacteristic.TEACHES_MOST_CLASSES);
        ProfessorCharacteristic characteristic5 = new ProfessorCharacteristic(
                ProfessorCharacteristic.Provides_USEFUL_RESOURCES);
        ProfessorCharacteristic characteristic6 = new ProfessorCharacteristic(
                ProfessorCharacteristic.TIMELINESS_REQUIRED);

        professorCharacteristicRepository.save(characteristic1);
        professorCharacteristicRepository.save(characteristic2);
        professorCharacteristicRepository.save(characteristic3);
        professorCharacteristicRepository.save(characteristic4);
        professorCharacteristicRepository.save(characteristic5);
        professorCharacteristicRepository.save(characteristic6);

        // Professor 1
        Professor professor1 = Professor.builder()
                .firstNames("Juan")
                .lastNames("García")
                .profileImage("profile_image__juan_garcia.png")
                .build();

        ProfessorReview professor1review1 = ProfessorReview.builder()
                .professor(professor1)
                .description(StringPlaceholders.LOREM_IPSUM_MEDIUM)
                .professorCharacteristics(Set.of(characteristic1, characteristic2, characteristic5))
                .sspExpertise(3)
                .sspExplanationQuality(4)
                .sspWillingnessToHelp(5)
                .build();

        ProfessorReview professor1review2 = ProfessorReview.builder()
                .professor(professor1)
                .description(StringPlaceholders.LOREM_IPSUM_LONG)
                .professorCharacteristics(Set.of(characteristic2, characteristic3, characteristic4))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(5)
                .build();

        ProfessorReview professor1review3 = ProfessorReview.builder()
                .professor(professor1)
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(Set.of(characteristic5, characteristic6, characteristic1))
                .sspExpertise(4)
                .sspExplanationQuality(4)
                .sspWillingnessToHelp(5)
                .build();

        // Professor 2
        Professor professor2 = Professor.builder()
                .firstNames("María")
                .lastNames("Ayala")
                .profileImage("profile_image__maria_ayala.png")
                .build();

        ProfessorReview professor2review1 = ProfessorReview.builder()
                .professor(professor2)
                .description(StringPlaceholders.LOREM_IPSUM_TINY)
                .professorCharacteristics(Set.of(characteristic2, characteristic3, characteristic6))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(3)
                .build();

        ProfessorReview professor2review2 = ProfessorReview.builder()
                .professor(professor2)
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(Set.of(characteristic1, characteristic2, characteristic4))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(4)
                .build();

        ProfessorReview professor2review3 = ProfessorReview.builder()
                .professor(professor2)
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(Set.of(characteristic3, characteristic5, characteristic2))
                .sspExpertise(2)
                .sspExplanationQuality(3)
                .sspWillingnessToHelp(2)
                .build();

        // Professor 3
        Professor professor3 = Professor.builder()
                .firstNames("Josué")
                .lastNames("Suárez")
                .profileImage("profile_image__josue_suarez.png")
                .build();

        ProfessorReview professor3review1 = ProfessorReview.builder()
                .professor(professor2)
                .description(StringPlaceholders.LOREM_IPSUM_TINY)
                .professorCharacteristics(Set.of(characteristic2, characteristic3, characteristic6))
                .sspExpertise(1)
                .sspExplanationQuality(2)
                .sspWillingnessToHelp(3)
                .build();

        ProfessorReview professor3review2 = ProfessorReview.builder()
                .professor(professor2)
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(Set.of(characteristic1, characteristic2, characteristic4))
                .sspExpertise(1)
                .sspExplanationQuality(1)
                .sspWillingnessToHelp(2)
                .build();

        ProfessorReview professor3review3 = ProfessorReview.builder()
                .professor(professor2)
                .description(StringPlaceholders.LOREM_IPSUM_SHORT)
                .professorCharacteristics(Set.of(characteristic3, characteristic5, characteristic2))
                .sspExpertise(2)
                .sspExplanationQuality(2)
                .sspWillingnessToHelp(3)
                .build();

        populateProfessorScores(professor1, List.of(professor1review1, professor1review2, professor1review3));
        populateProfessorScores(professor2, List.of(professor2review1, professor2review2, professor2review3));
        populateProfessorScores(professor2, List.of(professor3review1, professor3review2, professor3review3));

        professorRepository.save(professor1);
        professorRepository.save(professor2);
        professorRepository.save(professor3);

        professorReviewRepository.save(professor1review1);
        professorReviewRepository.save(professor1review2);
        professorReviewRepository.save(professor1review3);

        professorReviewRepository.save(professor2review1);
        professorReviewRepository.save(professor2review2);
        professorReviewRepository.save(professor2review3);

        professorReviewRepository.save(professor3review1);
        professorReviewRepository.save(professor3review2);
        professorReviewRepository.save(professor3review3);
    }
}
