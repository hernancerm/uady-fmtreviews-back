package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendedResourceWebsite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 40)
    private String title;

    @NotBlank
    @Size(min = 1, max = 800)
    private String description;

    @ManyToOne
    private RecommendedResourceType type;

    @ManyToOne
    private Course course;
}
