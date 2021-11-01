package hercerm.uady.fmtreviewsback.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Data
public class HttpHostConfig {
    @Value("${server.port}")
    private int port;

    private String address;

    {
        String hostAddress = "";

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        address = hostAddress;
    }
}
