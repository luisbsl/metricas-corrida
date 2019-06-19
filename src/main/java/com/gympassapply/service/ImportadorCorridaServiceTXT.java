package com.gympassapply.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.gympassapply.exception.ArquivoNaoEncontradoException;
import com.gympassapply.model.Corrida;
import com.gympassapply.model.Piloto;

public final class ImportadorCorridaServiceTXT implements ImportadorCorridaService {
	private String nomeArquivo;
	private ExtratorDosDadosDaVoltaService extratorDosDadosDaVoltaService;
	private Map<String, Piloto> pilotos = new HashMap<>();
	
	public ImportadorCorridaServiceTXT(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
		this.extratorDosDadosDaVoltaService= new ExtratorDosDadosDaVoltaService();
	}

	public Corrida importar() {		
		Corrida corrida = new Corrida();
		Piloto piloto = null;
		
		try (Scanner scanner = new Scanner(getArquivoDaPastaResources())) {
			while (scanner.hasNext()) {
				String linhaAtualDoArquivo = scanner.nextLine(); 
				if(!linhaAtualDoArquivo.toLowerCase().contains("hora")) {
					piloto = extratorDosDadosDaVoltaService.extrairPiloto(linhaAtualDoArquivo);
					
					if(!pilotos.containsValue(piloto)) {
						pilotos.put(piloto.getCodigo(), piloto);
					}else {
						piloto = pilotos.get(piloto.getCodigo());
					}
					
					if(piloto.getVoltas()==null) {
						piloto.setVoltas(new ArrayList<>());
					}
					
					piloto.getVoltas().add(extratorDosDadosDaVoltaService.extrairVoltaDoPiloto(linhaAtualDoArquivo));
				}
			}
		} catch (FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException();
		}
		
		corrida.setPilotos(new ArrayList<Piloto>(pilotos.values()));
		return corrida;
	}
	
	private File getArquivoDaPastaResources() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		if(classLoader.getResource(nomeArquivo) == null) throw new ArquivoNaoEncontradoException();
		File arquivoParaInportacao = new File(classLoader.getResource(nomeArquivo).getFile());
		return arquivoParaInportacao;
	}
}
