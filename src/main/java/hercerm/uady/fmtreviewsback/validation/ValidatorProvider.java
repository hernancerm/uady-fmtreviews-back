package hercerm.uady.fmtreviewsback.validation;

import javax.validation.Validator;

public interface ValidatorProvider {
    Validator getValidator();
}
