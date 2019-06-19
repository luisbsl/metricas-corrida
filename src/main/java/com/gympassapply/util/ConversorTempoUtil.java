package com.gympassapply.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.gympassapply.exception.StringDeTempoInvalidaException;

public final class ConversorTempoUtil {

	public static long converterTempoStringEmMilesegundos(String tempoString) {
		long minutosEmMilisegundos;
		long segundosEmMilisegundos;
		long milisegundos;
		
		try {
			String[] tempoArray = tempoString.split(":");
			minutosEmMilisegundos = TimeUnit.MINUTES.toMillis(Integer.valueOf(tempoArray[0]));
			segundosEmMilisegundos = TimeUnit.SECONDS.toMillis(Integer.valueOf(tempoArray[1].substring(0, 2)));
			milisegundos = Long.parseLong(tempoString.split("\\.")[1]);
		} catch (Exception e) {
			throw new StringDeTempoInvalidaException();
		}
		
		
		return minutosEmMilisegundos + segundosEmMilisegundos + milisegundos;
	}

	public static String converterTempoLongEmStringFormatada(long tempoMilis) {
        DateFormat simple = new SimpleDateFormat("mm:ss.SSS");
        Date result = new Date(tempoMilis);
        
        return simple.format(result);
	}

}
