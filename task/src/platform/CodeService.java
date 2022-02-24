package platform;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CodeService {

    private Code code;

    public CodeService() {
        this.code = new Code();
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code.setCode(code.getCode());
        this.code.setDate(LocalDateTime.now());
    }
}
