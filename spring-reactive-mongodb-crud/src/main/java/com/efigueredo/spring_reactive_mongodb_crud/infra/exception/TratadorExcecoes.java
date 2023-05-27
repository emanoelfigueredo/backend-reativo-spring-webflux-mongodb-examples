package com.efigueredo.spring_reactive_mongodb_crud.infra.exception;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class TratadorExcecoes {

    @Autowired
    private ModelMapper modelMapper;

    @ExceptionHandler(CrudReactiveException.class)
    public Mono<RespostaErro> tratarCrudReactiveException(CrudReactiveException ex) {
        return Mono.just(this.modelMapper.map(ex, RespostaErro.class));
    }

}
