package com.tjmt.procs.domain.dto;

import java.time.OffsetDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.tjmt.procs.api.model.Tb_classe;
import com.tjmt.procs.domain.model.Tb_juiz;
import com.tjmt.procs.domain.model.Tb_parte;
import com.tjmt.procs.domain.model.Tb_processo;

public class Tb_processoDTO {

	private Long id;

	private String nrprocesso;
	private OffsetDateTime datacriacao;
	private OffsetDateTime datadistribuicao;
	
	private Tb_classe tb_classe;
	
	private List<Tb_parte> partes;
	
	private Tb_juiz juiz;

	public static Tb_processoDTO create(Tb_processo j) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(j, Tb_processoDTO.class);
	}

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
	
		
	public List<Tb_parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Tb_parte> partes) {
		this.partes = partes;
	}
	
	

	public Tb_juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Tb_juiz juiz) {
		this.juiz = juiz;
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
		Tb_processoDTO other = (Tb_processoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tb_processoDTO [id=" + id + ", nrprocesso=" + nrprocesso + ", datacriacao=" + datacriacao
				+ ", datadistribuicao=" + datadistribuicao + ", tb_classe=" + tb_classe + ", partes=" + partes
				+ ", juiz=" + juiz + "]";
	}


	


}
