package com.cordeiro.springProject.dto;

import java.io.Serial;
import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.cordeiro.springProject.services.validation.ClienteInsert;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@ClienteInsert
public class ClienteNewDTO implements Serializable {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String name;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	@Email(message="Email Invalido")
	private String email;
	
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	private String cpfOuCnpj;
	
	private Integer tipo;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	private String numero;
	
	private String complemento;

	@NotEmpty(message="Preenchimento Obrigatorio ")
	private String bairro;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	private String cep;
	
	@NotEmpty(message="Preenchimento Obrigatorio ")
	private String tel1;
	
	private String tel2;
	private String tel3;
	
	private Integer cidadeId;
	
	public ClienteNewDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
}
