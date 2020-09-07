package ca.cmpt213.a3.onlinesuperherotracker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
Extends RuntimeException Class and called when no superHero is found with given id.
 */

public class SuperheroNotFoundException extends RuntimeException {


}
