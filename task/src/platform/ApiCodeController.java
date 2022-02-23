package platform;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {

    CodeService codeService = new CodeService();

    @GetMapping
    public ResponseEntity<Code> getApiCode() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok().
                headers(responseHeaders)
                .body(codeService.getCode());
    }
}
