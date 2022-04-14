package platform.models;

import java.util.Objects;

public class CodeIdResponse {
    private String id;

    public CodeIdResponse(String id) {
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
        if (!(o instanceof CodeIdResponse)) return false;
        CodeIdResponse that = (CodeIdResponse) o;
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
