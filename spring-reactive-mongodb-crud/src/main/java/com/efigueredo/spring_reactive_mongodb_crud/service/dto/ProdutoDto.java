package com.efigueredo.spring_reactive_mongodb_crud.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private String id;
    private String nome;
    private int quantidade;
    private double preco;

}
