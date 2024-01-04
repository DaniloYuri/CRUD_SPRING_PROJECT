package com.cordeiro.springProject.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.domain.Cliente;
import com.cordeiro.springProject.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	
	@Autowired 
	private ClienteService service;
	@GetMapping("{id}")
	public ResponseEntity<?> find (@PathVariable Integer id){
		Cliente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}

	
}
