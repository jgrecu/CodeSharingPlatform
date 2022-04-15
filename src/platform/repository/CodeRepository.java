package platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.models.CodeSnippet;

import java.util.Optional;
import java.util.UUID;

public interface CodeRepository extends JpaRepository<CodeSnippet, Long> {
    Optional<CodeSnippet> findById(UUID id);
}
