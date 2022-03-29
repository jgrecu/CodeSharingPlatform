package platform.services;

import org.springframework.stereotype.Service;
import platform.models.CodeSnippet;
import platform.models.CodeSnippetResponse;
import platform.utils.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private List<CodeSnippet> codeSnippets;

    public CodeService() {
        this.codeSnippets = new ArrayList<>();
        /*codeSnippets.add(new CodeSnippet("public static void main(String[] args) " +
                "{\n\tSpringApplication.run(CodeSharingPlatform.class, args);\n}"));*/
    }

    public List<CodeSnippet> getCodeSnippets() {
        return codeSnippets;
    }

    public CodeSnippet getCode(int id) {
        return codeSnippets.stream()
                .filter(codeSnippet -> codeSnippet.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No code with id: " + id));
    }

    public CodeSnippetResponse addCode(CodeSnippet code) {
        code.setDate(LocalDateTime.now());
        code.setId(Id.getNextId());
        codeSnippets.add(code);

        return new CodeSnippetResponse(code.getId().toString());
    }

    public List<CodeSnippet> getLatestCodeSnippets() {
        return codeSnippets.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;}
                ))
                .stream()
                .limit(10)
                .collect(Collectors.toList());
        /*return codeSnippets.stream()
                .sorted(Comparator.comparing(CodeSnippet::getDate).reversed())
                .limit(10)
                .collect(Collectors.toList());*/
    }
}
