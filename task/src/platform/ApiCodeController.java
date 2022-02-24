package platform;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {

    CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    public ResponseEntity<Code> getApiCode() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok().
                headers(responseHeaders)
                .body(codeService.getCode());
    }

    @PostMapping("/new")
    public String setApiCode(@RequestBody Code code) {
        codeService.setCode(code);
        return "{}";
    }
}
