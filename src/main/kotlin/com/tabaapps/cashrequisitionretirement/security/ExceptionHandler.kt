package com.tabaapps.cashrequisitionretirement.security

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler : Exception() {

    @ExceptionHandler(ResponseException::class)
    fun handleResponseException(exception: ResponseException): ResponseEntity<*> {
        return ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResponseException::class)
    fun handleBaseException(exception: java.lang.Exception): ResponseEntity<*> {
        return ResponseEntity(exception.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}