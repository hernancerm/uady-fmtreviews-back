package hercerm.uady.fmtreviewsback.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class FsResourcesConfig {
    @Value("${fs-resources.root}")
    private String rootDir;

    @Value("${fs-resources.professors-profile-images}")
    private String professorImagesPath;
}
