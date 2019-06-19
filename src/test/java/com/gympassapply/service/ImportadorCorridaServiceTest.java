package com.gympassapply.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gympassapply.exception.ArquivoNaoEncontradoException;
import com.gympassapply.model.Corrida;

public class ImportadorCorridaServiceTest {
	
	@Test
	public void importar_deveRetornarOsCincoPilotosDaCorrida() {
		final String nomeArquivo =  "corridas.log";
		ImportadorCorridaServiceTXT importador = new ImportadorCorridaServiceTXT(nomeArquivo);
		Corrida corrida = importador.importar();
		assertEquals(6, corrida.getPilotos().size());
	}
	
	@Test(expected=ArquivoNaoEncontradoException.class)
	public void importar_deveRetornarExcecaoArquivoNaoEncontrado() {
		ImportadorCorridaServiceTXT importador = new ImportadorCorridaServiceTXT("teste.log");
		importador.importar();
	}
	
}
