package lucasdasial.mjobs.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasdasial.mjobs.entity.Company;
import lucasdasial.mjobs.execptions.UserAlreadyExistExecption;

import lucasdasial.mjobs.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository repository;

    public Company execute(Company entity) {
        this.repository.findByEmail(entity.getEmail()).ifPresent(user -> {
            throw new UserAlreadyExistExecption();
        });

        return repository.save(entity);
    }
}
