package inteviews.ordinia.WordCount.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class OpenApiConfig {

    @Bean
    public Docket api(final ApiInfo apiInfo) {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("inteviews.ordinia.WordCount.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo(
                "WebFrequency",
                "Demo project for word frequency",
                "0.0.1-snapshot",
                "API Terms of Service",
                "PetrusOrio@gmail.com",
                null,
                null
        );
    }
}

