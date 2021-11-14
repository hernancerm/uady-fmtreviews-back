package hercerm.uady.fmtreviewsback.errors;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ErrorMessage implements Serializable {
    private final String error;

    public ErrorMessage(String error) {
        this.error = error;
    }
}
