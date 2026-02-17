package lucasdasial.mjobs.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import lucasdasial.mjobs.entity.Job;

public interface JobRepository extends JpaRepository<Job, UUID> {

}
