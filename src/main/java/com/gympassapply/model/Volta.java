package com.gympassapply.model;

import com.gympassapply.util.ConversorTempoUtil;

public class Volta {

	private Integer numero;
	private String hora;
	private String tempoVolta;
	private Float velocidadeMedia;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTempoVolta() {
		return tempoVolta;
	}
	
	public Long getTempoVoltaEmMilisegundos() {
		return ConversorTempoUtil.converterTempoStringEmMilesegundos(tempoVolta);
	}

	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public Float getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Volta other = (Volta) obj;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Volta [numero=" + numero + ", hora=" + hora + ", tempoVolta=" + tempoVolta + ", velocidadeMedia="
				+ velocidadeMedia + "]";
	}
	
	
}
