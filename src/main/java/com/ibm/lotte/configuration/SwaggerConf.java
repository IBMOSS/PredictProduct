package com.ibm.lotte.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConf {

//    @Bean
//    public Docket api() {
//        return new Docket( DocumentationType.SWAGGER_2 ).select().apis( RequestHandlerSelectors.basePackage( "com.ibm.lotte" ) )
//                .paths( PathSelectors.any() ).build();
//    }

    @Bean
    public Docket apiPackage() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .select()
                .apis( or( RequestHandlerSelectors.withClassAnnotation( RepositoryRestController.class ), basePackage( "com.ibm.lotte" ) ) )
                .paths( PathSelectors.any() )
                .build();
    }


}