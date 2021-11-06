package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.config.FsResourcesConfig;
import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterDto;
import hercerm.uady.fmtreviewsback.dtos.StudentSatisfactionParameterPointedDto;
import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameter;
import hercerm.uady.fmtreviewsback.entities.StudentSatisfactionParameterPointed;
import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.mappers.impl.ProfessorMapper;
import hercerm.uady.fmtreviewsback.repositories.ProfessorRepository;
import hercerm.uady.fmtreviewsback.repositories.StudentSatisfactionParameterRepository;
import hercerm.uady.fmtreviewsback.services.ProfessorService;
import hercerm.uady.fmtreviewsback.services.StudentSatisfactionParameterService;
import hercerm.uady.fmtreviewsback.utils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final StudentSatisfactionParameterRepository studentSatisfactionParameterRepository;

    private final StudentSatisfactionParameterService studentSatisfactionParameterService;

    private final ProfessorMapper professorMapper;

    private final FsResourcesConfig fsResourcesConfig;

    private final String fsUserHome = System.getProperty("user.home");


    public ProfessorServiceImpl(ProfessorRepository professorRepository,
                                StudentSatisfactionParameterService studentSatisfactionParameterService,
                                StudentSatisfactionParameterRepository studentSatisfactionParameterRepository,
                                ProfessorMapper professorMapper,
                                FsResourcesConfig fsResourcesConfig) {
        this.professorRepository = professorRepository;
        this.studentSatisfactionParameterRepository = studentSatisfactionParameterRepository;
        this.studentSatisfactionParameterService = studentSatisfactionParameterService;
        this.professorMapper = professorMapper;
        this.fsResourcesConfig = fsResourcesConfig;
    }

    @Override
    public List<ProfessorDto> getAll() {
        return professorRepository.findAll().stream()
                .map(professorMapper::entity2dto).collect(Collectors.toList());
    }

    @Override
    public ProfessorDto getById(Long professorId) {
        return professorRepository.findById(professorId)
                .map(professorMapper::entity2dto)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found"));
    }

    @Override
    public byte[] getProfileImage(Long professorId) throws FileNotFoundException {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found"));

        byte[] byteArrayImage;

        try {
            Path imagePath = Paths.get(fsUserHome, fsResourcesConfig.getRootDir(),
                    fsResourcesConfig.getProfessorImagesPath(), professor.getProfileImage());
            InputStream inputStream = new FileInputStream(imagePath.toAbsolutePath().toString());

            byteArrayImage = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new FileNotFoundException("Unexpected error retrieving profile image");
        }

        return byteArrayImage;
    }

    @Override
    public ProfessorDto update(ProfessorDto professorDto) {
        // TODO: Validate professorDto

        Professor fetchedProfessor = professorRepository.findById(professorDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Professor not found"));

        BeanUtils.copyProperties(professorDto, fetchedProfessor);

        // TODO: Refactor this parameter setting to method (see its use also in ProfessorReviewServiceImpl#create)
        // Set student satisfaction parameters with saved entities.
        List<StudentSatisfactionParameterPointed> parameterScores =  professorDto.getStudentSatisfactionScores()
                .stream()
                .map(parameterScoreDto -> StudentSatisfactionParameterPointed.builder()
                        .points(parameterScoreDto.getPoints())
                        .studentSatisfactionParameter(studentSatisfactionParameterService.mapDtoToSavedEntity(
                                parameterScoreDto.getStudentSatisfactionParameter()))
                        .build())
                .collect(Collectors.toList());
        fetchedProfessor.setStudentSatisfactionScores(parameterScores);

        Professor updatedProfessor = professorRepository.save(fetchedProfessor);
        return professorMapper.entity2dto(updatedProfessor);
    }

    @Override
    public ProfessorDto create(ProfessorDto professorDto) {
        // TODO: Validate professorDto

        Professor mappedProfessor = professorMapper.dto2entity(professorDto);

        List<StudentSatisfactionParameter> parameters =
                studentSatisfactionParameterRepository.findAll();

        List<StudentSatisfactionParameterPointed> parametersPointed = new ArrayList<>();

        parameters.forEach(parameter -> parametersPointed.add(
                new StudentSatisfactionParameterPointed(0.0, parameter)
        ));
        // Set student satisfaction grades on the mapped professor
        mappedProfessor.setStudentSatisfactionScores(parametersPointed);

        Professor savedProfessor = professorRepository.save(mappedProfessor);
        return professorMapper.entity2dto(savedProfessor);
    }

    @Override
    public void saveProfileImage(Long professorId, byte[] profileImage) {
        Professor fetchedProfessor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found"));

        String filenamePrefix = "profile_image";
        String filenameDiscriminator = String.format("%s_%s", // TODO: Add professor ID in discriminator.
                StringUtils.stripAccents(fetchedProfessor.getFirstNames()).toLowerCase(),
                StringUtils.stripAccents(fetchedProfessor.getLastNames()).toLowerCase());
        String filename = String.format("%s__%s.png", filenamePrefix, filenameDiscriminator);

        // TODO: Implement image saving with proper filename.

        fetchedProfessor.setProfileImage(filename);
        professorRepository.save(fetchedProfessor);
    }
}
