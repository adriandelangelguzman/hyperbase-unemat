package br.colider.unemat.entities;


public class Monografia extends Documento {
	private String resumo;
	private String abstract_;
	private String keywords;

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getAbstract_() {
		return abstract_;
	}

	public void setAbstract_(String abstract1) {
		abstract_ = abstract1;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
