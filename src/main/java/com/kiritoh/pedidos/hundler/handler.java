package com.kiritoh.pedidos.hundler;

import com.kiritoh.pedidos.exceptions.ObjetoNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@ControllerAdvice
public class handler {

    @ExceptionHandler(ObjetoNoEncontrado.class)
    public ResponseEntity<standardError> ObjetoNoEncontrado(ObjetoNoEncontrado e, HttpServletRequest request){
        standardError error=new standardError(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
