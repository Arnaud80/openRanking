package biz.duhamel.openranking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ControlerExceptionNotFound extends RuntimeException {
    public ControlerExceptionNotFound(String message) {
        System.err.println(message);
    }
}
