package lucasdasial.mjobs.execptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExecptionHandler {

    private MessageSource messageSource;

    GlobalExecptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<ErrorValidationDto>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {

        var errorResponse = new ErrorResponse<ErrorValidationDto>(ex.getStatusCode().value(), "Error de validação");

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(err -> {

                    var message = messageSource.getMessage(err, LocaleContextHolder.getLocale());

                    var error = new ErrorValidationDto(err.getField(), message);
                    errorResponse.addError(error);
                });

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
