package com.tjmt.procs.domain.dto;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.tjmt.procs.domain.model.Tb_juiz;
import com.tjmt.procs.domain.model.Tb_processo;

public class Tb_juizDTO {

	private Long id;

	private String nome;
	private String cpf;
	private LocalDate datanascimento;
	private List<Tb_processo> processos;

	public static Tb_juizDTO create(Tb_juiz j) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(j, Tb_juizDTO.class);
	}

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
		Tb_juizDTO other = (Tb_juizDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tb_juizDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", datanascimento=" + datanascimento
				+ ", processos=" + processos + "]";
	}
	
}
