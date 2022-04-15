package platform.services;

import org.springframework.stereotype.Service;
import platform.models.CodeIdResponse;
import platform.models.CodeSnippet;
import platform.models.SnippetResponse;
import platform.repository.CodeRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    public Optional<SnippetResponse> getCode(UUID id) {
        Optional<CodeSnippet> optionalCodeSnippet = codeRepository.findById(id);
        return optionalCodeSnippet.map(o -> {
            Long views = o.getViews();
            Long time = o.getTime();

            if (!o.getTimeRestricted() && !o.getViewRestricted()) {
                return o;
            }

            long seconds = Duration.between(LocalDateTime.now(), o.getFullDate().plusSeconds(time)).toSeconds();
            if (seconds > 0 | views >= 1) {
                if (views != 0) {
                    o.setViews(views - 1);
                    codeRepository.saveAndFlush(o);
                }
                o.setTime(seconds <= 0 ? 0 : seconds);
                return o;
            } else {
                codeRepository.delete(o);
                return null;
            }
        }).map(SnippetResponse::new);
    }

    public CodeIdResponse addCode(CodeSnippet code) {
        code.setDate(LocalDateTime.now());
        Long time = code.getTime();
        Long views = code.getViews();
        if (time > 0) {
            code.setTimeRestricted(true);
        }
        if (views > 0) {
            code.setViewRestricted(true);
        }
        codeRepository.saveAndFlush(code);

        return new CodeIdResponse(code.getId().toString());
    }

    public List<SnippetResponse> getLatestCodeSnippets() {
        List<CodeSnippet> codeSnippets = codeRepository.findAll();
        return codeSnippets.stream()
                .filter(codeSnippet -> codeSnippet.getTime() == 0 && codeSnippet.getViews() == 0)
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                            Collections.reverse(l);
                            return l;
                        }
                ))
                .stream()
                .limit(10)
                .map(SnippetResponse::new)
                .collect(Collectors.toList());
    }
}
