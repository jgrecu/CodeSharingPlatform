package platform.services;

import org.springframework.stereotype.Service;
import platform.models.CodeSnippet;
import platform.models.CodeIdResponse;
import platform.models.SnippetResponse;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public List<CodeSnippet> getCodeSnippets() {
        return codeRepository.findAll();
    }

    public SnippetResponse getCode(Long id) {
        Optional<CodeSnippet> optionalCodeSnippet = codeRepository.findById(id);
        return optionalCodeSnippet.map(SnippetResponse::new).orElseThrow(() -> new IllegalStateException("No code with id: " + id));
    }

    public CodeIdResponse addCode(CodeSnippet code) {
        code.setDate(LocalDateTime.now());
        codeRepository.saveAndFlush(code);

        return new CodeIdResponse(code.getId().toString());
    }

    public List<SnippetResponse> getLatestCodeSnippets() {
        List<CodeSnippet> codeSnippets = codeRepository.findAll();
        return codeSnippets.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;}
                ))
                .stream()
                .limit(10)
                .map(SnippetResponse::new)
                .collect(Collectors.toList());
    }
}
