package lucasdasial.mjobs.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lucasdasial.mjobs.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    Optional<Candidate> findByEmail(String email);
}
