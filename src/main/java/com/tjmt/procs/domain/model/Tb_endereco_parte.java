package com.tjmt.procs.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Digits;

import com.sun.istack.NotNull;

import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Tb_endereco_parte {

	@ApiModelProperty(value = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Bairro")
	@Verify(ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
	private String bairro;
	
	@ApiModelProperty(value = "Cidade")
	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String cidade;
	
	@ApiModelProperty(value = "Estado")
	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String estado;
	
	@ApiModelProperty(value = "CEP")
	@Verify(ParametroTipo.CEP)
	private String cep;
	
	@ApiModelProperty(value = "Logradouro / Rua")
	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String logradouro;
	
	@ApiModelProperty(value = "Numero")
	@Digits(integer=7 , fraction=0)
	private int numero;
	
	@NotNull
	@Valid
	@OneToOne
    @JoinColumn(name = "id_parte")
	private Tb_parte tb_parte;
	

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tb_endereco_parte other = (Tb_endereco_parte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
