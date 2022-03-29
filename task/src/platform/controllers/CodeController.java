package platform.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.services.CodeService;

@Controller
@RequestMapping("/code")
public class CodeController {

    CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public String getHtmlCode(@PathVariable int id, Model model) {

        model.addAttribute("code", codeService.getCode(id));

        return "code";
    }

    @GetMapping("/new")
    public String getCodeForm() {
        return "new-code";
    }

    @GetMapping("/latest")
    public String getLatestCodes(Model model) {
        model.addAttribute("codes", codeService.getLatestCodeSnippets());

        return "codes";
    }

}
