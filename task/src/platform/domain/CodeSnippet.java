package platform.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import platform.util.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeSnippet {
    @JsonIgnore
    private Integer id;
    private String code;
    private String date;

    public CodeSnippet(String code) {
        this.id = Id.getNextId();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                '}';
    }
}
