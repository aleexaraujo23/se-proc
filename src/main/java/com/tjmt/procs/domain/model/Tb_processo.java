package com.tjmt.procs.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

import com.tjmt.procs.api.model.Tb_classe;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Tb_processo {

	@ApiModelProperty(value = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Numero processo")
	@Column(name = "nr_processo")
	private String nrprocesso;

	@ApiModelProperty(value = "Data criacao do processo")
	@Column(name = "data_criacao")
	private OffsetDateTime datacriacao;

	@ApiModelProperty(value = "Data da distribuicao do processo")
	@Column(name = "data_distribuicao")
	private OffsetDateTime datadistribuicao;

	@NotNull
	@Valid
	@OneToOne
	@JoinColumn(name = "id_classe")
	private Tb_classe tb_classe;

	//@NotNull
	@Valid
	@ManyToMany(mappedBy = "processos", cascade = CascadeType.DETACH)
	private List<Tb_parte> partes;
	
	@OneToMany(mappedBy = "processos")
	private List<Tb_juiz> juiz;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrprocesso() {
		return nrprocesso;
	}

	public void setNrprocesso(String nrprocesso) {
		this.nrprocesso = nrprocesso;
	}

	public OffsetDateTime getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(OffsetDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}

	public OffsetDateTime getDatadistribuicao() {
		return datadistribuicao;
	}

	public void setDatadistribuicao(OffsetDateTime datadistribuicao) {
		this.datadistribuicao = datadistribuicao;
	}

	public Tb_classe getTb_classe() {
		return tb_classe;
	}

	public void setTb_classe(Tb_classe tb_classe) {
		this.tb_classe = tb_classe;
	}

	public List<Tb_juiz> getJuiz() {
		return juiz;
	}

	public void setJuiz(List<Tb_juiz> juiz) {
		this.juiz = juiz;
	}

	public List<Tb_parte> getListaProcessoParte() {
		return partes;
	}

	public void setListaProcessoParte(List<Tb_parte> lista) {
		this.partes = lista;
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
		Tb_processo other = (Tb_processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tb_processo [id=" + id + ", nrprocesso=" + nrprocesso + ", datacriacao=" + datacriacao
				+ ", datadistribuicao=" + datadistribuicao + ", tb_classe=" + tb_classe.getId() + ", partes=" + partes
				+ "]";
	}

}
