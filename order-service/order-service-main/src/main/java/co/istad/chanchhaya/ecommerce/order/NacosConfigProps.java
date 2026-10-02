package co.istad.chanchhaya.ecommerce.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "service")
@Getter
@Setter
@NoArgsConstructor
public class NacosConfigProps {

    private String name;
    private String basicInfo;
    private String version;

}
