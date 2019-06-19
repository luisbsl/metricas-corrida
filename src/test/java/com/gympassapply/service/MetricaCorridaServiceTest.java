package com.gympassapply.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gympassapply.model.Corrida;
import com.gympassapply.model.MetricaCorrida;

public class MetricaCorridaServiceTest {
	private String nomeArquivo;
	
	@Before
	public void setUp() {
		nomeArquivo =  "corridas.log";
	}
	
	@Test
	public void construirMetricaDaCorrida_deveRetornarSeisMetricas() {
		MetricaCorridaService metricaCorridaService = new MetricaCorridaService();
		ImportadorCorridaServiceTXT importador = new ImportadorCorridaServiceTXT(nomeArquivo);
		Corrida corrida = importador.importar();
		List<MetricaCorrida> metricasDaCorrida = metricaCorridaService.construirMetricasDaCorrida(corrida);
		assertEquals(6, metricasDaCorrida.size());
	}
	
	@Test
	public void apresentarMetricaDaCorridaNoConsole() {
		MetricaCorridaService metricaCorridaService = new MetricaCorridaService();
		ImportadorCorridaServiceTXT importador = new ImportadorCorridaServiceTXT(nomeArquivo);
		Corrida corrida = importador.importar();
		metricaCorridaService.apresentarMetricaDaCorridaNoConsole(corrida);
	}

}
