package com.cordeiro.springProject.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cordeiro.springProject.domain.ItemPedido;
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer> {

}
