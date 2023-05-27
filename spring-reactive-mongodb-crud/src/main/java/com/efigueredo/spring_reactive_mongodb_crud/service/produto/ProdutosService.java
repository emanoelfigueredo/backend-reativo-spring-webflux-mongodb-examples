package com.efigueredo.spring_reactive_mongodb_crud.service.produto;

import com.efigueredo.spring_reactive_mongodb_crud.domain.entidades.Produto;
import com.efigueredo.spring_reactive_mongodb_crud.domain.repository.ProdutoRepository;
import com.efigueredo.spring_reactive_mongodb_crud.infra.exception.CrudReactiveException;
import com.efigueredo.spring_reactive_mongodb_crud.service.dto.ProdutoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutosService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public Flux<ProdutoDto> getProdutos() {
        return this.repository.findAll().map(produto ->
                this.modelMapper.map(produto, ProdutoDto.class));
    }

    public Mono<ProdutoDto> getProduto(String id) {
        return this.repository.findById(id).map(produto ->
                this.modelMapper.map(produto, ProdutoDto.class));
    }

    public Flux<ProdutoDto> getProdutoNoRange(double min, double max) {
        return repository.findByPrecoBetween(Range.closed(min, max));
    }

    public Mono<ProdutoDto> salvarProduto(Mono<ProdutoDto> produtoDtoMono) throws Exception {
        return produtoDtoMono.map(produtoDto -> this.modelMapper.map(produtoDto, Produto.class))
                .flatMap(this.repository::insert)
                .map(produto -> {
                    if(1 == 1) {
                        try {
                            throw new CrudReactiveException("teste", "teste", "", 400);
                        } catch (Exception e) {
                            throw new CrudReactiveException("teste", "teste", "", 400);
                        }
                    }
                    return this.modelMapper.map(produto, ProdutoDto.class);
                });

    }

    public Mono<ProdutoDto> updateProduto(Mono<ProdutoDto> produtoDtoMono, String id) {
        return this.repository.findById(id)
                .flatMap(p -> produtoDtoMono
                        .map(dto -> this.modelMapper.map(dto, Produto.class))
                        .doOnNext(e -> e.setId(id))
                )
                .flatMap(this.repository::save)
                .map(prod -> this.modelMapper .map(prod, ProdutoDto.class));
    }

    public Mono<Void> deleteProduto(String id) {
        return this.repository.deleteById(id);
    }

}
