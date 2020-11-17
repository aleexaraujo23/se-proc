package com.tjmt.procs.api.model;

public class Classe_csv {

private Long id;
	
	private String id_cnj;
	private String ds_classe;
	private String sigla;
	private String tipo;

	public Classe_csv(Long id, String id_cnj, String ds_classe, String sigla, String tipo) {
		this.id = id;
        this.id_cnj = id_cnj;
        this.ds_classe = ds_classe;
        this.sigla = sigla;
        this.tipo = tipo;
        
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_cnj() {
		return id_cnj;
	}

	public void setId_cnj(String id_cnj) {
		this.id_cnj = id_cnj;
	}

	public String getDs_classe() {
		return ds_classe;
	}

	public void setDs_classe(String ds_classe) {
		this.ds_classe = ds_classe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
}
