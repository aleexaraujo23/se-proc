package com.tjmt.procs.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Tb_juiz {

	@ApiModelProperty(value = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Nome Juiz")
	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String nome;

	@ApiModelProperty(value = "CPF Juiz")
	@Size(min = 11, max = 11, message = "CPF deve ter no minimo e no máximo {max} caracteres.")
	@Verify(ParametroTipo.CPF)
	private String cpf;

	@ApiModelProperty(value = "Data Nascimento Juiz")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_nascimento")
	private LocalDate datanascimento;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tb_processo_juiz",
	             joinColumns={@JoinColumn(name="juiz_id")},
	             inverseJoinColumns={@JoinColumn(name="processo_id")})
	private List<Tb_processo> processos = new ArrayList<Tb_processo>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}
	
	

	public List<Tb_processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Tb_processo> processos) {
		this.processos = processos;
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
		Tb_juiz other = (Tb_juiz) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Tb_juiz [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", datanascimento=" + datanascimento
//				+ ", processos=" + processos + "]";
//	}

}
