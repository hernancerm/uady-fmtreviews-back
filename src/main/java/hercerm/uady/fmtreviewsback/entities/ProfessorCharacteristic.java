package hercerm.uady.fmtreviewsback.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorCharacteristic {

    public static final String INTERESTED_IN_SUBJECT = "Muestra interés por la materia";
    public static final String REQUIRES_ENGLISH = "Requiere inglés para algunas tareas";
    public static final String GRADES_TRANSPARENTLY = "Calcula de forma transparente las calificaciones";
    public static final String TEACHES_MOST_CLASSES = "No se salta las clases";
    public static final String Provides_USEFUL_RESOURCES = "Proporciona recursos útiles para el curso";
    public static final String TIMELINESS_REQUIRED = "Espera puntualidad por parte de los alumnos";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public ProfessorCharacteristic(String description) {
        this.description = description;
    }
}
