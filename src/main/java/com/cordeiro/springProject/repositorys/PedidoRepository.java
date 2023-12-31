package com.cordeiro.springProject.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cordeiro.springProject.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer> {

}
