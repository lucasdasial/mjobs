package lucasdasial.mjobs.execptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ErrorResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<T> errors;

    ErrorResponse(int status, String error) {
        timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;

        errors = new ArrayList<T>();
    }

    public void addError(T e) {
        this.errors.add(e);
    }
}
