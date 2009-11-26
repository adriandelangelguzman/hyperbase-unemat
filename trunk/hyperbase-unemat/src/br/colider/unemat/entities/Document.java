package br.colider.unemat.entities;

import java.util.Date;

public abstract class Document {
	private int id;
	private String titulo;
	private int numpage;
	private String data;
	private String link;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
