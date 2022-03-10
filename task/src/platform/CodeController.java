package platform;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/code")
public class CodeController {

    CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    public String getHtmlCode(Model model) {

        model.addAttribute("code", codeService.getCode());

        return "code";
    }

    @GetMapping("/new")
    public String getCodeForm(Model model) {

        model.addAttribute("new-code", codeService.getCode());
        return "new-code";
    }

}
