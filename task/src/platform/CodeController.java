package platform;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/code")
public class CodeController {

    CodeService codeService = new CodeService();

    @GetMapping
    public String getHtmlCode(Model model) {

        model.addAttribute("code", codeService.getCode());

        return "code";
    }

}
