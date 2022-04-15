package platform.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "snippets")
public class CodeSnippet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String code;
    private LocalDateTime date;
    private Long time = 0L;
    private Long views = 0L;
    private Boolean timeRestricted = false;
    private Boolean viewRestricted = false;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Boolean getTimeRestricted() {
        return timeRestricted;
    }

    public void setTimeRestricted(Boolean timeRestricted) {
        this.timeRestricted = timeRestricted;
    }

    public Boolean getViewRestricted() {
        return viewRestricted;
    }

    public void setViewRestricted(Boolean viewRestricted) {
        this.viewRestricted = viewRestricted;
    }

    public LocalDateTime getFullDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CodeSnippet{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", views=" + views +
                ", timeRestricted=" + timeRestricted +
                ", viewRestricted=" + viewRestricted +
                '}';
    }
}
