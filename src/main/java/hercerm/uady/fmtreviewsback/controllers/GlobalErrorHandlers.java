package hercerm.uady.fmtreviewsback.controllers;

import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.errors.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, FileNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage _404NotFound(Exception e, WebRequest request) {
        logger.warn(e.getMessage());
        return new ErrorMessage(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage _500InternalServerError(Exception e, WebRequest request) {
        logger.error(e.getMessage());
        return new ErrorMessage("Unexpected internal error");
    }
}
