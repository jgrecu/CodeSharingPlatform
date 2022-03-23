package platform.domain;

import java.util.Objects;

public class CodeSnippetResponse {
    private int id;

    public CodeSnippetResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
