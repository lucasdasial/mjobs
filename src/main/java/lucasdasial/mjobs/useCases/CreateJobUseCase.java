package lucasdasial.mjobs.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasdasial.mjobs.entity.Job;
import lucasdasial.mjobs.execptions.CompanyNotFoundException;
import lucasdasial.mjobs.repositories.CompanyRepository;
import lucasdasial.mjobs.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Job execute(Job jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
