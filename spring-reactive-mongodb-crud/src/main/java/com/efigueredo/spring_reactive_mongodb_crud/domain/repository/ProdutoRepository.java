package com.efigueredo.spring_reactive_mongodb_crud.domain.repository;

import com.efigueredo.spring_reactive_mongodb_crud.domain.entidades.Produto;
import com.efigueredo.spring_reactive_mongodb_crud.service.dto.ProdutoDto;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProdutoRepository extends ReactiveMongoRepository<Produto, String> {

    Flux<ProdutoDto> findByPrecoBetween(Range<Double> priceRange);

}
