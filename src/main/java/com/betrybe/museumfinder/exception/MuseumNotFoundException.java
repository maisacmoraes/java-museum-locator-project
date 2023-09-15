package com.betrybe.museumfinder.exception;

/**
 * Exception thrown when a museum is not found.
 */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }

}
