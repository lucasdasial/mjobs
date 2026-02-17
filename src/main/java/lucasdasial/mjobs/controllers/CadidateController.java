package lucasdasial.mjobs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lucasdasial.mjobs.entity.Candidate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/candidate")
public class CadidateController {

    @PostMapping("")
    public ResponseEntity<Candidate> create(@Valid @RequestBody Candidate entity) {

        return ResponseEntity.ok(entity);
    }

    @GetMapping("")
    public String getMethodName() {
        return new String("Lucas teste");
    }

}
