package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global controller advice to handle exceptions.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

  /**
   * Handle invalid coordinate exceptions.
   *
   * @param exception the exception to be handled.
   * @return the response entity with the exception message.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinate(InvalidCoordinateException exception) {
    return ResponseEntity
        .badRequest()
        .body(exception.getMessage());
  }

  /**
   * Handle museum not found exceptions.
   *
   * @param exception the exception to be handled.
   * @return the response entity with the exception message.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFound(MuseumNotFoundException exception) {
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(exception.getMessage());
    }

  /**
   * Handle generic exceptions.
   *
   * @param exception the exception to be handled.
   * @return the response entity with the exception message.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .internalServerError()
        .body("Erro interno!");
  }
}
