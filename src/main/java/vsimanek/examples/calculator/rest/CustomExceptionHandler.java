package vsimanek.examples.calculator.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ErrorMessages constraintViolation(ConstraintViolationException exception) {
        ErrorMessages errorMessages = new ErrorMessages();
        errorMessages.setMessages(exception.getConstraintViolations().stream().map(Object::toString).collect(Collectors.toList()));
        return errorMessages;
    }

    private class ErrorMessages {
        private List<String> messages;

        private void setMessages(List<String> messages) {
            this.messages = messages;
        }

        public List<String> getMessages() {
            return messages;
        }
    }

}
