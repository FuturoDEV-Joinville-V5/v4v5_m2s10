package br.senai.lab365.produtoapi.exceptions;

import br.senai.lab365.produtoapi.dtos.ErrorDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseEntity<ErrorDTO> trataDuplicateKey(final DuplicateKeyException exception) {
    return new ResponseEntity<>(new ErrorDTO(exception.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDTO> trataArgumentoInvalido(
      final MethodArgumentNotValidException exception) {
    return new ResponseEntity<>(new ErrorDTO(exception.getMessage()), HttpStatus.BAD_REQUEST);
  }
}
