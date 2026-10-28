package com.universidad.tests.exception;

import com.universidad.tests.domain.exception.DomainRuleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    public record ApiError(String code, String message) { }

    @ExceptionHandler(DomainRuleException.class)
    public ResponseEntity<ApiError> onDomainRule(DomainRuleException error) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ApiError("DOMAIN_RULE_VIOLATION", error.getMessage()));
    }
}
