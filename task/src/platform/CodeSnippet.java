package platform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeSnippet {
    private String code;
    private String date;

    public CodeSnippet(String code) {
        this.code = code;
        date = formatDateTime(LocalDateTime.now());
    }

    public CodeSnippet() {
        code = "public static void main(String[] args) {\n\tSpringApplication.run(CodeSharingPlatform.class, args);\n}";
        date = formatDateTime(LocalDateTime.now());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDateTime dateTime) {
        this.date = formatDateTime(dateTime);
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                '}';
    }
}
