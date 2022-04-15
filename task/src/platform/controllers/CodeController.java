package platform.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import platform.models.SnippetResponse;
import platform.services.CodeService;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/code")
public class CodeController {

    CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public String getHtmlCode(@PathVariable UUID id, Model model) {
        Optional<SnippetResponse> code = codeService.getCode(id);
        SnippetResponse snippetResponse = code.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("code", snippetResponse);
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
