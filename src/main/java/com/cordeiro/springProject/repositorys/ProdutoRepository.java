package com.cordeiro.springProject.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cordeiro.springProject.domain.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

}
