package com.gympassapply.model.builder;

import com.gympassapply.model.Volta;

public class VoltaBuilder {
	
	private Volta volta;
	
	public VoltaBuilder() {
		volta = new Volta();
	}
	
	public VoltaBuilder comNumero(Integer numero) {
		volta.setNumero(numero);
		return this;
	}
	
	public VoltaBuilder comTempoDaVolta(String tempoDaVolta) {
		volta.setTempoVolta(tempoDaVolta);
		return this;
	}
	
	public VoltaBuilder comVelocidadeMedia(String velocidadeMedia) {
		volta.setVelocidadeMedia(Float.valueOf(velocidadeMedia.replace(",", ".")));
		return this;
	}
	
	public VoltaBuilder comHora(String hora) {
		volta.setHora(hora);
		return this;
	}
	
	public Volta build() {
		return volta;
	}

}
