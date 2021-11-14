package hercerm.uady.fmtreviewsback.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSatisfactionParameterDto {

    private Long id;

    private String name;

    public StudentSatisfactionParameterDto(String name) {
        this.name = name;
    }
}
