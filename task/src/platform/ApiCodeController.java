package platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {

    @JsonSerialize
    public class EmptyJsonResponse { }

    CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    public ResponseEntity<CodeSnippet> getApiCode() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok().
                headers(responseHeaders)
                .body(codeService.getCode());
    }

    @PostMapping("/new")
    public ResponseEntity<EmptyJsonResponse> setApiCode(@RequestBody CodeSnippet code) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");

        codeService.setCode(code);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(new EmptyJsonResponse());
    }
}
