package com.efigueredo.spring_reactive_mongodb_crud.domain.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produtos")
public class Produto {

    @Id
    private String id;
    private String nome;
    private int quantidade;
    private double preco;

}
