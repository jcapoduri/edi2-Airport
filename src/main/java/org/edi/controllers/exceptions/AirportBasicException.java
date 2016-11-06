package org.edi.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) 
public class AirportBasicException extends RuntimeException {
	private static final long serialVersionUID = 1L;

  public AirportBasicException(String msg) {
    super(msg);
  }
  
  public AirportBasicException() {
    super("Error de conexion con la base de datos");
  }

}
