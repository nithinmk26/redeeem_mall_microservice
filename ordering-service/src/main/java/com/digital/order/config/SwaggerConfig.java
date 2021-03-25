/**
 * 
 */
package com.digital.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author M1056182
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                 
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))            
          .paths(PathSelectors.any())                         
          .build()
          .apiInfo(metaData());


    }
    private ApiInfo metaData() {
           
        @SuppressWarnings("deprecation")
        ApiInfo apiInfo = new ApiInfo(
                "Order Service Management",
                "OrderService", "REST API", "Spring Boot ", "Nithin Kambesh", "Version 1.0 ", "Copyright - MINDTREE LTD ");
       
        return apiInfo; 
    }
    
}
