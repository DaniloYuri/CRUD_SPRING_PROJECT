package com.cordeiro.springProject.dto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.cordeiro.springProject.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres" )
	private String name ;
	private List<Categoria> listDto ;
	
	public CategoriaDTO() {
		
	}
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		name = obj.getName();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Categoria> getListDto() {
		return listDto;
	}
	public void setListDto(List<Categoria> listDto) {
		this.listDto = listDto;
	}
	
	
}
