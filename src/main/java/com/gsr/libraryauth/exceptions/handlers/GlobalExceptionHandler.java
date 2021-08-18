package com.gsr.libraryauth.exceptions.handlers;

import com.gsr.libraryauth.exceptions.exceptiontemplates.APIExceptionTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /***
     * Conform server thrown exceptions also to APIExceptionTemplate defined.
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String servletPath = ((ServletWebRequest) request).getRequest().getRequestURI();
        APIExceptionTemplate exceptionDetailsToExpose = new APIExceptionTemplate("Something went wrong", status.getReasonPhrase(), servletPath,
                status.value(), new Date());
        return new ResponseEntity<>(exceptionDetailsToExpose, status);
    }

}
