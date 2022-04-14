package platform.controllers;

import org.springframework.web.bind.annotation.*;
import platform.models.CodeSnippet;
import platform.models.CodeIdResponse;
import platform.models.SnippetResponse;
import platform.services.CodeService;

import java.util.List;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {

    private final CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public SnippetResponse getApiCode(@PathVariable Long id) {
        return codeService.getCode(id);
    }

    @PostMapping("/new")
    public CodeIdResponse setApiCode(@RequestBody CodeSnippet code) {

        CodeIdResponse codeIdResponse = codeService.addCode(code);

        return codeIdResponse;
    }

    @GetMapping("/latest")
    public List<SnippetResponse> getApiLatestCodeSnippets() {

        return codeService.getLatestCodeSnippets();
    }
}
