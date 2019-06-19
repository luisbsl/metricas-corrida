package com.gympassapply.model.builder;

import com.gympassapply.model.MetricaCorrida;
import com.gympassapply.model.Piloto;
import com.gympassapply.model.Volta;

public class MetricaCorridaBuilder {
	
	private MetricaCorrida metricaCorrida;
	
	public MetricaCorridaBuilder() {
		metricaCorrida = new MetricaCorrida();
	}
	
	public MetricaCorridaBuilder comPiloto(Piloto piloto) {
		metricaCorrida.setPiloto(piloto);
		return this;
	}
	
	public MetricaCorridaBuilder comQuantidadeDeVoltasCompletadas(Integer quantidadeVoltasCompletadas) {
		metricaCorrida.setQuantidadeVoltasCompletadas(quantidadeVoltasCompletadas);
		return this;
	}
	
	public MetricaCorridaBuilder comTempoTotalDaProvaEmMilisegundos(long tempoTotalDaProva) {
		metricaCorrida.setTempoTotalDaProvaEmMilisegundos(tempoTotalDaProva);
		return this;
	}
	
	public MetricaCorridaBuilder comTempoTotalDaProvaFormatada(String tempoTotalDaProva) {
		metricaCorrida.setTempoTotalDaProvaFormatada(tempoTotalDaProva);
		return this;
	}
	
	public MetricaCorridaBuilder comVelocidadeMediaDuranteTodaCorrida(Double velocidadeMediaDuranteTodaCorrida) {
		metricaCorrida.setVelocidadeMediaDuranteTodaCorrida(velocidadeMediaDuranteTodaCorrida);
		return this;
	}
	
	public MetricaCorridaBuilder comMelhorVolta(Volta melhorVolta) {
		metricaCorrida.setMelhorVolta(melhorVolta);
		return this;
	}
	
	public MetricaCorrida build() {
		return metricaCorrida;
	}

}
