package platform.models;

public class SnippetResponse {
    private final String code;
    private final String date;

    public SnippetResponse(CodeSnippet codeSnippet) {
        this.code = codeSnippet.getCode();
        this.date = codeSnippet.getDate();
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }
}
