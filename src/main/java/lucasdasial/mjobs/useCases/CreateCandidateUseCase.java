package lucasdasial.mjobs.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasdasial.mjobs.entity.Candidate;
import lucasdasial.mjobs.execptions.UserAlreadyExistExecption;
import lucasdasial.mjobs.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository repository;

    public Candidate execute(Candidate entity) {
        this.repository.findByEmail(entity.getEmail()).ifPresent(user -> {
            throw new UserAlreadyExistExecption();
        });

        return repository.save(entity);
    }
}
