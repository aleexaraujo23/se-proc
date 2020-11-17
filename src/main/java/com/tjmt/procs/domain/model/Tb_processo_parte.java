//package com.tjmt.procs.domain.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import io.swagger.annotations.ApiModelProperty;
//
//@Entity
//@Table(name = "tb_processo_parte")
//public class Tb_processo_parte {
//
//
//
//	@JoinColumn(name = "proceso_id")
//	@ManyToOne
//	private Tb_processo processo;
//
//	@JoinColumn(name = "parte_id")
//	@OneToOne
//	private Tb_parte parte;
//
//
//	public Tb_processo getProcesso() {
//		return processo;
//	}
//
//	public void setProcesso(Tb_processo processo) {
//		this.processo = processo;
//	}
//
//	public Tb_parte getParte() {
//		return parte;
//	}
//
//	public void setParte(Tb_parte parte) {
//		this.parte = parte;
//	}
//
//}
