package musta.belmo.cody.rest.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(hidden = true)
@Controller
@RequestMapping("/")
public class RootController {
    @GetMapping()
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}
