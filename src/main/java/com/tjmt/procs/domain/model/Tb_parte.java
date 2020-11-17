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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Tb_parte {

	@ApiModelProperty(value = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Nome da parte")
	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String nome;

	@ApiModelProperty(value = "Data nascimento da parte")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_nascimento")
	private LocalDate datanascimento;

	@ApiModelProperty(value = "CPF da parte")
	@Size(min = 11, max = 11, message = "CPF deve ter no minimo e no máximo {max} caracteres.")
	@Verify(ParametroTipo.CPF)
	private String cpf;

	@ApiModelProperty(value = "Tipo da parte")
	@Column(name = "tipo_parte")
	private String tipoparte;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tb_processo_partes",
	             joinColumns={@JoinColumn(name="parte_id")},
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

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimeto) {
		this.datanascimento = datanascimeto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoparte() {
		return tipoparte;
	}

	public void setTipoparte(String tipoparte) {
		this.tipoparte = tipoparte;
	}

	public List<Tb_processo> getProcessoParte() {
		return processos;
	}

	public void Tb_processo_parte(List<Tb_processo> processoParte) {
		this.processos = processoParte;
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
		Tb_parte other = (Tb_parte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tb_parte [id=" + id + ", nome=" + nome + ", datanascimento=" + datanascimento + ", cpf=" + cpf
				+ ", tipoparte=" + tipoparte + "]";
	}

}
