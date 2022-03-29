package platform.models;

import java.util.Objects;

public class CodeSnippetResponse {
    private String id;

    public CodeSnippetResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeSnippetResponse)) return false;
        CodeSnippetResponse that = (CodeSnippetResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CodeSnippetResponse{" +
                "id=" + id +
                '}';
    }
}
