package com.tjmt.procs.domain.dto;

import org.modelmapper.ModelMapper;

import com.tjmt.procs.domain.model.Tb_endereco_parte;
import com.tjmt.procs.domain.model.Tb_parte;

public class Tb_endereco_parteDTO {

	private Long id;

	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String logradouro;
	private int numero;

	private Tb_parte tb_parte;

	public static Tb_endereco_parteDTO create(Tb_endereco_parte j) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(j, Tb_endereco_parteDTO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Tb_parte getTb_parte() {
		return tb_parte;
	}

	public void setTb_parte(Tb_parte tb_parte) {
		this.tb_parte = tb_parte;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tb_endereco_parteDTO other = (Tb_endereco_parteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
