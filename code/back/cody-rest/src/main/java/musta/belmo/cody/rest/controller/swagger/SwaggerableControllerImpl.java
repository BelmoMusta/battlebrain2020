package musta.belmo.cody.rest.controller.swagger;

import io.swagger.annotations.SwaggerDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SwaggerDefinition
@Component
/**
 * just to load configuration
 * and do not delegate swagger configuration to the rest controllers ;)
 */
public class SwaggerableControllerImpl implements SwaggerableController {
    @Override
    public Docket toDocket() {
        return null;
    }
}
