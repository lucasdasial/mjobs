package lucasdasial.mjobs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lucasdasial.mjobs.entity.Job;
import lucasdasial.mjobs.useCases.CreateJobUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public Job create(@Valid @RequestBody Job jobEntity) {
        return createJobUseCase.execute(jobEntity);
    }

}
