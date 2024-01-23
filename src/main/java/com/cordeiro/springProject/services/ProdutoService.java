package com.cordeiro.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.domain.Produto;
import com.cordeiro.springProject.repositorys.CategoriaRepository;
import com.cordeiro.springProject.repositorys.ProdutoRepository;
import com.cordeiro.springProject.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()

				
				));
		
	}
 
	public Page<Produto> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		 PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction));
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.search(name, categorias, pageRequest);
		
	}

}
