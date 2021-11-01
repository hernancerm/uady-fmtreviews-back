package hercerm.uady.fmtreviewsback.services.impl;

import hercerm.uady.fmtreviewsback.config.FsResourcesConfig;
import hercerm.uady.fmtreviewsback.dtos.ProfessorDto;
import hercerm.uady.fmtreviewsback.entities.Professor;
import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.mappers.impl.ProfessorMapper;
import hercerm.uady.fmtreviewsback.repositories.ProfessorRepository;
import hercerm.uady.fmtreviewsback.services.ProfessorService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    private final ProfessorMapper professorMapper;

    private final FsResourcesConfig fsResourcesConfig;

    private final String fsUserHome = System.getProperty("user.home");

    public ProfessorServiceImpl(ProfessorRepository professorRepository,
                                ProfessorMapper professorMapper,
                                FsResourcesConfig fsResourcesConfig) {
        this.professorRepository = professorRepository;
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
}
