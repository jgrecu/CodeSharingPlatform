package platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SnippetResponse {
    private final String code;
    private final String date;
    private final Long time;
    private final Long views;
    @JsonIgnore
    private final Boolean timeRestricted;
    @JsonIgnore
    private final Boolean viewRestricted;

    public SnippetResponse(CodeSnippet codeSnippet) {
        this.code = codeSnippet.getCode();
        this.date = codeSnippet.getDate();
        this.time = codeSnippet.getTime();
        this.views = codeSnippet.getViews();
        this.timeRestricted = codeSnippet.getTimeRestricted();
        this.viewRestricted = codeSnippet.getViewRestricted();
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public Long getTime() {
        return time;
    }

    public Long getViews() {
        return views;
    }

    public Boolean getTimeRestricted() {
        return timeRestricted;
    }

    public Boolean getViewRestricted() {
        return viewRestricted;
    }
}
