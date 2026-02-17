package lucasdasial.mjobs.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lucasdasial.mjobs.entity.Candidate;
import lucasdasial.mjobs.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Candidate> findByEmail(String email);

}
