package com.gympassapply.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.gympassapply.model.Corrida;
import com.gympassapply.model.MetricaCorrida;
import com.gympassapply.model.Volta;
import com.gympassapply.model.builder.MetricaCorridaBuilder;
import com.gympassapply.util.ConversorTempoUtil;

public class MetricaCorridaService {	
	private Integer contador = 0;

	public List<MetricaCorrida> construirMetricasDaCorrida(Corrida corrida) {
		List<MetricaCorrida> metricasDaCorrida = new ArrayList<>();
		corrida
			.getPilotos()
			.forEach(piloto -> {
			
			long tempoTotalDasVoltas = getTempoTotalDasVoltasDoPiloto(piloto.getVoltas());
			double velocidadeMediaDuranteTodaCorrida = getVelocidadeMediaDuranteTodaCorridaDoPiloto(piloto.getVoltas());
			
			MetricaCorrida metricaCorrida = 
					new MetricaCorridaBuilder()
							.comPiloto(piloto)
							.comQuantidadeDeVoltasCompletadas(piloto.getVoltas().size())
							.comTempoTotalDaProvaEmMilisegundos(tempoTotalDasVoltas)
							.comTempoTotalDaProvaFormatada(ConversorTempoUtil.converterTempoLongEmStringFormatada(tempoTotalDasVoltas))
							.comVelocidadeMediaDuranteTodaCorrida(velocidadeMediaDuranteTodaCorrida)
							.comMelhorVolta(getMelhorVoltaDoPiloto(piloto.getVoltas()))
							.build();
			metricasDaCorrida.add(metricaCorrida);
		});
		metricasDaCorrida.sort(Comparator.comparing(metrica -> metrica.getTempoTotalDaProvaEmMilisegundos()));
		return metricasDaCorrida;
	}

	public void apresentarMetricaDaCorridaNoConsole(Corrida corrida) {
		System.out.println("Resultado da Corrida\n");
		List<MetricaCorrida> metricasDaCorrida = construirMetricasDaCorrida(corrida);
		metricasDaCorrida.forEach(metrica -> {
			int posicaoChegada = getContador();
			System.out.println("Posicção Chegada: "+posicaoChegada);
			System.out.println(metrica);
			posicaoChegada++;
		});
		
		System.out.println("\nMétricas Gerais");
		MetricaCorrida melhorVoltaDaCorrida = getMelhorVoltaDeTodaCorrida(metricasDaCorrida);
		System.out.println("Melhor Volta da Corrida: (Piloto: "+ melhorVoltaDaCorrida.getPiloto().getNome() +" - N: "+melhorVoltaDaCorrida.getMelhorVolta().getNumero()+" - Tempo: "+melhorVoltaDaCorrida.getMelhorVolta().getTempoVolta()+")\n");
		
		
		getDiferencaDoTempoDeCadaPilotoAposOVencedor(metricasDaCorrida);
	}
	
	private Integer getContador() {
		return ++contador;
	}
	
	private long getTempoTotalDasVoltasDoPiloto(final List<Volta> voltas) {
		return voltas.stream().mapToLong(Volta::getTempoVoltaEmMilisegundos).sum();
	}
	
	private double getVelocidadeMediaDuranteTodaCorridaDoPiloto(final List<Volta> voltas) {
		return voltas.stream().mapToDouble(Volta::getVelocidadeMedia).average().getAsDouble();
	}
	
	private Volta getMelhorVoltaDoPiloto(List<Volta> voltas) {
		return voltas.stream().sorted(Comparator.comparing(Volta::getTempoVolta)).findFirst().get();
	}

	private MetricaCorrida getMelhorVoltaDeTodaCorrida(List<MetricaCorrida> metricasDaCorrida) {
		return metricasDaCorrida.stream().sorted(Comparator.comparing(metrica -> metrica.getMelhorVolta().getTempoVolta())).findFirst().get();
	}
	
	private void getDiferencaDoTempoDeCadaPilotoAposOVencedor(List<MetricaCorrida> metricasDaCorrida) {
		MetricaCorrida metricasDoVencedor = metricasDaCorrida.get(0);
		metricasDaCorrida.remove(getMelhorVoltaDeTodaCorrida(metricasDaCorrida));
		
		System.out.println("Diferença do Tempo de Chegada Depois do Vencedor");
		metricasDaCorrida
			.stream()
			.filter(metrica -> metrica.getPiloto().getVoltas().size() > 3)
			.forEach(metrica -> {
				Volta ultimaVolta = metrica.getPiloto()
											.getVoltas()
											.stream()
											.sorted(Comparator.comparingInt(Volta::getNumero).reversed())
											.findFirst()
											.get();
				
				Volta ultimaVoltaDoVencedor = metricasDoVencedor.getPiloto()
																.getVoltas()
																.stream()
																.sorted(Comparator.comparingInt(Volta::getNumero).reversed())
																.findFirst()
																.get();
				
				long diferencaDoTempoDeChegadaEmRelacaoAoVencedor = ultimaVolta.getTempoVoltaEmMilisegundos() - ultimaVoltaDoVencedor.getTempoVoltaEmMilisegundos();
				System.out.println(metrica.getPiloto().getNome() +" - "+ ConversorTempoUtil.converterTempoLongEmStringFormatada(diferencaDoTempoDeChegadaEmRelacaoAoVencedor));
			});
	}
}
