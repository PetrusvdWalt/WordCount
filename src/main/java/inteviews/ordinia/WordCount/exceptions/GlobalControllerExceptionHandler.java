package inteviews.ordinia.WordCount.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = {InvalidInputException.class})
    protected ResponseEntity<String> handleConflict(InvalidInputException ex) {
        return ResponseEntity.internalServerError()
                .body(ex.getMessage());
    }
}
