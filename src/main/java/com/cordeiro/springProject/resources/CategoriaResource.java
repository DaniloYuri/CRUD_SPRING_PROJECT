package com.cordeiro.springProject.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.dto.CategoriaDTO;
import com.cordeiro.springProject.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	
	@Autowired
	private CategoriaService service;
	
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id){
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto){
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> update (@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id ){
		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	

	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());		
		return ResponseEntity.ok().body(listDto);
		
	}
	/*
	 @GetMapping("/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
		@RequestParam(value="page",defaultValue="0")Integer page,
		@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage,
		@RequestParam(value="OrderBy", defaultValue="nome")String orderBy,
		@RequestParam(value="direction", defaultValue="ASC")String direction) {
		Page<Categoria>list =service.findPage(page, linesPerPage, orderBy, direction);
		Page<Categoria> listDTO = listDto = list.mar(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	
	}
		
	}
	*/
}
