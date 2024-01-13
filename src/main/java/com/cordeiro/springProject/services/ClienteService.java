package com.cordeiro.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.domain.Cliente;
import com.cordeiro.springProject.domain.Endereco;
import com.cordeiro.springProject.domain.enums.TipoCliente;
import com.cordeiro.springProject.dto.ClienteDTO;
import com.cordeiro.springProject.dto.ClienteNewDTO;
import com.cordeiro.springProject.repositorys.ClienteRepository;
import com.cordeiro.springProject.repositorys.EnderecoRepository;
import com.cordeiro.springProject.services.exceptions.DataIntegrityException;
import com.cordeiro.springProject.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()

		));

	}
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Cliente update( Cliente obj) {
		
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas ");
		}

	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getName(),objDto.getEmail(), null, null);
	}
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getName(),objDto.getEmail(),objDto.getCpfOuCnpj(),TipoCliente.toEnum(objDto.getTipo()));
		Endereco end = new Endereco(null, objDto.getLogradouro(),objDto.getNumero(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),cli,null);
		
		
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTel1());
		if(objDto.getTel2()!=null) {
			cli.getTelefones().add(objDto.getTel2()); 
 
		}
		if(objDto.getTel3()!=null) {
			cli.getTelefones().add(objDto.getTel3());
		}	
		
		return cli;
		
	}
		
	
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
