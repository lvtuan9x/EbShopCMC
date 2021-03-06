package com.cmc.ebshop.common.exception;

import com.cmc.ebshop.dto.ResponseBodyDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody
    ResponseEntity<ResponseBodyDto> handleNotFoundError(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseBodyDto dtoResult = new ResponseBodyDto();
        dtoResult.setCode(HttpStatus.NOT_FOUND.value());
        dtoResult.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(dtoResult);
    }

    @ExceptionHandler(CannotDeleteException.class)
    public @ResponseBody
    ResponseEntity<ResponseBodyDto> handleCanNotDeleteException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseBodyDto dtoResult = new ResponseBodyDto();
        dtoResult.setCode(HttpStatus.BAD_REQUEST.value());
        dtoResult.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(dtoResult);
    }
  
//    @ExceptionHandler(Exception.class)
//    public @ResponseBody
//    ResponseEntity<ResponseBodyDto> handleError(Exception ex, WebRequest request) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        ResponseBodyDto dtoResult = new ResponseBodyDto();
//        dtoResult.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        dtoResult.setMessage("Error");
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(dtoResult);
//    }
}
