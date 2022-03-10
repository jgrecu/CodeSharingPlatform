package platform;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CodeService {

    private CodeSnippet code;

    public CodeService() {
        this.code = new CodeSnippet();
    }

    public CodeSnippet getCode() {
        return code;
    }

    public void setCode(CodeSnippet code) {
        this.code.setCode(code.getCode());
        this.code.setDate(LocalDateTime.now());
    }
}
