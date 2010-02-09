package br.colider.unemat.entities;

public class Projeto extends Documento{
	private String local;
	private String publicoAlvo;
	private Integer ano;
	private Integer semestre;
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getPublicoAlvo() {
		return publicoAlvo;
	}
	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
}
