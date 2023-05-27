package com.efigueredo.spring_reactive_mongodb_crud.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespostaErro {

    private String title;
    private String details;
    private String type;
    private int status;

}
