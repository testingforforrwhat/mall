package com.test.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
@EnableOpenApi
@Data
public class SwaggerConfiguration {


    @Bean
    public Docket orderDoc(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("订单服务")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atstudy"))
                .paths(PathSelectors.ant("/order/**"))
                .build();
    }


    @Bean
    public Docket customerDoc(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("客户服务")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atstudy"))
                .paths(PathSelectors.ant("/customer/**"))
                .build();
    }

    @Bean
    public Docket productDoc(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("商品服务")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atstudy"))
                .paths(PathSelectors.ant("/product/**"))
                .build();
    }
    /*api信息*/
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 头部信息
                .title("学掌门商城")
                // 描述
                .description("商城接口文档")
                // 作者，网站和邮箱
                .contact(new Contact("atatudy","http://www.atstudy.com","123456789@qq.com"))
                // 版本号
                .version("V1.0")
                .build();

    }
}