package platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.models.CodeSnippet;

public interface CodeRepository extends JpaRepository<CodeSnippet, Long> {
}
