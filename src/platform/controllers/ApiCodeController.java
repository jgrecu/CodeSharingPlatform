package platform.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.models.CodeSnippet;
import platform.models.CodeIdResponse;
import platform.models.SnippetResponse;
import platform.services.CodeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {

    private final CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public SnippetResponse getApiCode(@PathVariable UUID id) {
        Optional<SnippetResponse> optionalSnippetResponse = codeService.getCode(id);
        return optionalSnippetResponse.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/new")
    public CodeIdResponse setApiCode(@RequestBody CodeSnippet code) {

        return codeService.addCode(code);
    }

    @GetMapping("/latest")
    public List<SnippetResponse> getApiLatestCodeSnippets() {

        return codeService.getLatestCodeSnippets();
    }
}
