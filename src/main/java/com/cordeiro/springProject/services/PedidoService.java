package com.cordeiro.springProject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.domain.Pedido;
import com.cordeiro.springProject.repositorys.PedidoRepository;
import com.cordeiro.springProject.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()

				
				));
		
	}
	

}
