package hercerm.uady.fmtreviewsback.utils;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonUtilClasses {

    @Bean
    public Gson getGsonInstance() {
        return new Gson();
    }
}
