package com.efigueredo.spring_reactive_mongodb_crud.infra.controller;

import com.efigueredo.spring_reactive_mongodb_crud.service.dto.ProdutoDto;
import com.efigueredo.spring_reactive_mongodb_crud.service.produto.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutosService produtosService;


    @GetMapping
    public Flux<ProdutoDto> getProdutos() {
        return this.produtosService.getProdutos();
    }

    @GetMapping("{id}")
    public Mono<ProdutoDto> getProduto(@PathVariable String id) {
        return this.produtosService.getProduto(id);
    }

    @GetMapping("produto-range")
    public Flux<ProdutoDto> getProdutoBetweenRange(@RequestParam("min") double min,
                                                   @RequestParam("max") double max) {
        return this.produtosService.getProdutoNoRange(min, max);
    }

    @PostMapping
    public Mono<ProdutoDto> saveProduto(@RequestBody Mono<ProdutoDto> produtoDtoMono) {
        return this.produtosService.salvarProduto(produtoDtoMono);
    }

    @PutMapping("update/{id}")
    public Mono<ProdutoDto> saveProduto(@RequestBody Mono<ProdutoDto> produtoDtoMono,
                                        @PathVariable String id) {
        return this.produtosService.updateProduto(produtoDtoMono, id);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteProduto(@PathVariable String id) {
        return this.produtosService.deleteProduto(id);
    }

}
