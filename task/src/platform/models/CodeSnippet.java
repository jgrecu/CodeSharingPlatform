package platform.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "snippets")
public class CodeSnippet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private LocalDateTime date;

    public CodeSnippet() {
    }

    public CodeSnippet(String code) {
        this.code = code;
        this.date = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return formatDateTime(date);
    }

    public void setDate(LocalDateTime dateTime) {
        this.date = dateTime;
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CodeSnippet{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                '}';
    }
}
