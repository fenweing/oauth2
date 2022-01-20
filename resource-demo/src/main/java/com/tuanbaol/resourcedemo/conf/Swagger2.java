package com.tuanbaol.resourcedemo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tuanbaol"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(getParameterList());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://www.zing-tech.com/")
                .termsOfServiceUrl("http://www.zing-tech.com")
                .contact("ygl")
                .version("1.0")
                .build();
    }

    private List<Parameter> getParameterList() {
        ParameterBuilder tokenPair = new ParameterBuilder();
        tokenPair.name("Authorization").description("Authorization").modelRef(new ModelRef("string"))
                .parameterType("header").required(false);
        return CollectionUtil.ofList(tokenPair.build());
    }
}
