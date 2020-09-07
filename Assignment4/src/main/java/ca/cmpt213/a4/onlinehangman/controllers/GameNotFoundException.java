package ca.cmpt213.a4.onlinehangman.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
public class GameNotFoundException extends RuntimeException {
public GameNotFoundException(String message){
    super(message);
}

}
