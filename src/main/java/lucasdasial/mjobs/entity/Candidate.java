package lucasdasial.mjobs.entity;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class Candidate {

    private UUID id;

    private String name;

    @Email(message = "O campo (email) deve conter um e-mail válido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;

    private String description;

}
