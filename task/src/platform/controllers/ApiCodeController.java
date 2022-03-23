package platform.controllers;

import org.springframework.web.bind.annotation.*;
import platform.domain.CodeSnippet;
import platform.domain.CodeSnippetResponse;
import platform.services.CodeService;

import java.util.List;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {

    CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    public List<CodeSnippet> getApiCodeSnippets() {
        return codeService.getCodeSnippets();
    }

    @GetMapping("/{id}")
    public CodeSnippet getApiCode(@PathVariable int id) {
        return codeService.getCode(id);
    }

    @PostMapping("/new")
    public CodeSnippetResponse setApiCode(@RequestBody CodeSnippet code) {

        CodeSnippetResponse codeSnippetResponse = codeService.addCode(code);

        return codeSnippetResponse;
    }

    @GetMapping("/latest")
    public List<CodeSnippet> getApiLatestCodeSnippets() {

        return codeService.getLatestCodeSnippets();
    }
}
