package com.gympassapply.main;

import com.gympassapply.model.Corrida;
import com.gympassapply.service.ImportadorCorridaService;
import com.gympassapply.service.ImportadorCorridaServiceTXT;
import com.gympassapply.service.MetricaCorridaService;

public class Principal {
	
	public static void main(String[] args) {
		
		MetricaCorridaService metricaCorridaService = new MetricaCorridaService();
		ImportadorCorridaService importador = new ImportadorCorridaServiceTXT("corridas.log");
		Corrida corrida = importador.importar();
		metricaCorridaService.apresentarMetricaDaCorridaNoConsole(corrida);
	}

}
