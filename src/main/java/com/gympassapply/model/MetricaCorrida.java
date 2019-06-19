package com.gympassapply.model;

public class MetricaCorrida {

	private Piloto piloto;
	private Integer quantidadeVoltasCompletadas;
	private long tempoTotalDaProvaEmMilisegundos;
	private String tempoTotalDaProvaFormatada;
	private Double velocidadeMediaDuranteTodaCorrida;
	private Volta melhorVolta;

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Integer getQuantidadeVoltasCompletadas() {
		return quantidadeVoltasCompletadas;
	}

	public void setQuantidadeVoltasCompletadas(Integer quantidadeVoltasCompletadas) {
		this.quantidadeVoltasCompletadas = quantidadeVoltasCompletadas;
	}

	public long getTempoTotalDaProvaEmMilisegundos() {
		return tempoTotalDaProvaEmMilisegundos;
	}

	public void setTempoTotalDaProvaEmMilisegundos(long tempoTotalDaProvaEmMilisegundos) {
		this.tempoTotalDaProvaEmMilisegundos = tempoTotalDaProvaEmMilisegundos;
	}

	public String getTempoTotalDaProvaFormatada() {
		return tempoTotalDaProvaFormatada;
	}

	public void setTempoTotalDaProvaFormatada(String tempoTotalDaProvaFormatada) {
		this.tempoTotalDaProvaFormatada = tempoTotalDaProvaFormatada;
	}

	public Double getVelocidadeMediaDuranteTodaCorrida() {
		return velocidadeMediaDuranteTodaCorrida;
	}
	
	public String getVelocidadeMediaDuranteTodaCorridaFormatada() {
		return velocidadeMediaDuranteTodaCorrida.toString().replace(".", ",");
	}

	public void setVelocidadeMediaDuranteTodaCorrida(Double velocidadeMediaDuranteTodaCorrida) {
		this.velocidadeMediaDuranteTodaCorrida = velocidadeMediaDuranteTodaCorrida;
	}

	public Volta getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(Volta melhorVolta) {
		this.melhorVolta = melhorVolta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((piloto == null) ? 0 : piloto.hashCode());
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
		MetricaCorrida other = (MetricaCorrida) obj;
		if (piloto == null) {
			if (other.piloto != null)
				return false;
		} else if (!piloto.equals(other.piloto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Código Piloto: " +piloto.getCodigo()+ "\n" 
					+ "Nome Piloto: " +piloto.getNome()+ "\n"
					+ "Qtde Voltas Completadas: " +quantidadeVoltasCompletadas+ "\n"
					+ "Tempo Total de Prova: " +tempoTotalDaProvaFormatada+ "\n"
				+ "   Bônus" + "\n"
					+ "	 Melhor Volta: (N: " +getMelhorVolta().getNumero()+ " - Tempo: " +getMelhorVolta().getTempoVolta()+ ")\n"
					+ "	 Velocidade Média Durante Toda Corrida: " +getVelocidadeMediaDuranteTodaCorridaFormatada()+ "\n\n";
	}
}
