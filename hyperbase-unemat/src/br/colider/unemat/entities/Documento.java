package br.colider.unemat.entities;

import java.util.Date;




public abstract class Documento {
	private int id;
	private String titulo;
	private int numpage;
	private Date data;
	private String caminhoArquivo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumpage() {
		return numpage;
	}

	public void setNumpage(int numpage) {
		this.numpage = numpage;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLink() {
		return caminhoArquivo;
	}

	public void setLink(String link) {
		this.caminhoArquivo = link;
	}

}
