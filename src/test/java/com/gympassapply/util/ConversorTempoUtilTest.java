package com.gympassapply.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gympassapply.exception.StringDeTempoInvalidaException;

public class ConversorTempoUtilTest {
	
	@Test
	public void converterTempoStringEmMilesegundos() {
		ConversorTempoUtil conversorTempoUtil = new ConversorTempoUtil();
		String tempoString = "1:02.769";		
		long tempoDaVoltaEmMilisegundosLong = conversorTempoUtil.converterTempoStringEmMilesegundos(tempoString);
		assertEquals(62769l, tempoDaVoltaEmMilisegundosLong);
	}
	
	@Test(expected=StringDeTempoInvalidaException.class)
	public void converterTempoStringEmMilesegundos_deveRetornarExcecaoNumberFormatExcepetion() {
		ConversorTempoUtil conversorTempoUtil = new ConversorTempoUtil();
		String tempoString = "1:02.AS";		
		long tempoDaVoltaEmMilisegundosLong = conversorTempoUtil.converterTempoStringEmMilesegundos(tempoString);
		assertEquals(62769l, tempoDaVoltaEmMilisegundosLong);
	}
	
	@Test
	public void converterTempoLongEmStringFormatada() {
		ConversorTempoUtil conversorTempoUtil = new ConversorTempoUtil();
		long tempoMilis = 62769l;
		String tempo = new String("01:02.769");
		String tempoDaVoltaEmStringFormatada = conversorTempoUtil.converterTempoLongEmStringFormatada(tempoMilis);
		assertEquals(tempo, tempoDaVoltaEmStringFormatada);
	}

}

