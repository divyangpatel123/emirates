package com.emirates.flight.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author divyang.patel
 * The Class SwaggerConfig for swagger related configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    /**
     * Flight api.
     *
     * @return the docket
     */
    @Bean
    public Docket flightApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emirates.flight.controllers"))
                .paths(regex("/flight/seat.*"))
                .build()
                .apiInfo(metaData());
    }
    
    /**
     * Meta data.
     *
     * @return the api info
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Emirates Flight REST API",
                "Spring Boot Emirates Flight REST API for booking",
                "1.0",
                "Terms of service",
                new Contact("Divyang Patel", "", "divyangpatel74@gmail.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
