package musta.belmo.cody.rest.controller.swagger;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

public interface SwaggerableController {

    default Docket buildDocket(String docketName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(docketName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(getClass()
                        .getPackage().getName()))
                .paths(PathSelectors.any()).build()
                .apiInfo(getApiInfo())
                .securitySchemes(Collections.emptyList())
                .securityContexts(Collections.emptyList())
                .useDefaultResponseMessages(false)
                //.globalResponseMessage(RequestMethod.GET, getResponseMessages())
                //.globalResponseMessage(RequestMethod.POST, getResponseMessages())
                ;
    }

    default ApiInfo getApiInfo() {
        return new ApiInfo("", "", "", "", null, "", "", Arrays.asList());
    }

    Docket toDocket();

}
