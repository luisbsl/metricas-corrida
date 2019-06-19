package com.gympassapply.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gympassapply.exception.PadraoStringNaoEncontradoException;
import com.gympassapply.model.Piloto;
import com.gympassapply.model.Volta;

public class ExtratorDosDadosDaVoltaServiceTest {
	
	private String linhaDoArquivo;
	
	@Before
	public void setUp() {
		linhaDoArquivo = "23:49:12.667      023 – M.WEBBER                          1		1:04.414                        43,202";
	}
	
	@Test
	public void extrairPiloto() {
		ExtratorDosDadosDaVoltaService extratorDosDadosDaVoltaService = new ExtratorDosDadosDaVoltaService();
		Piloto piloto = extratorDosDadosDaVoltaService.extrairPiloto(linhaDoArquivo);
		assertEquals("M.WEBBER", piloto.getNome());
	}
	
	@Test(expected=PadraoStringNaoEncontradoException.class)
	public void extrairPiloto_deveRetornarExcecaoPadraNaoEncontrado() {
		final String linhaDoArquivo = "23:49:12.667      AA – M.WEBBER                          1		1:04.414                        43,202";
		ExtratorDosDadosDaVoltaService extratorDosDadosDaVoltaService = new ExtratorDosDadosDaVoltaService();
		Piloto piloto = extratorDosDadosDaVoltaService.extrairPiloto(linhaDoArquivo);
		assertEquals("M.WEBBER", piloto.getNome());
	}
	
	@Test
	public void extrairVoltaDoPiloto() {
		ExtratorDosDadosDaVoltaService extratorDosDadosDaVoltaService = new ExtratorDosDadosDaVoltaService();
		Volta Volta = extratorDosDadosDaVoltaService.extrairVoltaDoPiloto(linhaDoArquivo);
		assertEquals("23:49:12.667", Volta.getHora());
	}

}
