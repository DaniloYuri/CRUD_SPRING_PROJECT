package com.cordeiro.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.domain.Cliente;
import com.cordeiro.springProject.repositorys.ClienteRepository;
import com.cordeiro.springProject.services.exceptions.DataIntegrityException;
import com.cordeiro.springProject.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()

		));

	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Cliente update( Cliente obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");

		}

	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}
}
