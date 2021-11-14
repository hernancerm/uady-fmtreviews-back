package hercerm.uady.fmtreviewsback.validation.impl;

import hercerm.uady.fmtreviewsback.validation.ValidatorProvider;
import org.apache.bval.jsr.ApacheValidationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ApacheValidatorProvider implements ValidatorProvider {

    private final ValidatorFactory apacheValidatorFactory =
            Validation.byProvider(ApacheValidationProvider.class).configure().buildValidatorFactory();

    /**
     * <p>
     *     Returns a {@link javax.validation.Validator} implemented by <a href="https://bval.apache.org/">Apache BVal</a>.
     * </p>
     * @return a {@link javax.validation.Validator}
     */
    @Bean
    @Override
    public Validator getValidator() {
        return apacheValidatorFactory.getValidator();
    }
}
