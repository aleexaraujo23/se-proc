package com.tjmt.procs.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_processo_juiz")
public class Tb_ProcessoJuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "processo_id")
	@JoinColumn(name = "processo_id", insertable = false, updatable = false)
	private Long processoid;
 
	@Column(name = "juiz_id")
	@JoinColumn(name = "juiz_id", insertable = false, updatable = false)
	private Long juizid;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Long getProcesso() {
		return processoid;
	}

	public void setProcesso(Long long1) {
		this.processoid = long1;
	}

	public long getJuiz() {
		return juizid;
	}

	public void setJuiz(Long long1) {
		this.juizid = long1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Tb_ProcessoJuiz other = (Tb_ProcessoJuiz) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tb_ProcessoJuiz [id=" + id + ", processo=" + processoid + ", convenio=" + juizid + "]";
	}
	
	
	

}
