package com.gympassapply.enums;

public enum ExtratorStringPadraoEnum {

	NOME_PILOTO("[A-Z]\\.[A-Z]+"),
	CODIGO_PILOTO("\\s0\\d{2}"),
	NUMERO_DA_VOLTA("\\s\\d{1}\\s"),
	TEMPO_DA_VOLTA("\\s\\d{1}:\\d{2}.\\d{3}"),
	VELOCIDADE_MEDIA_DA_VOLTA("\\d{2},\\d{2,3}"),
	HORA("\\d{2}:\\d{2}:\\d{2}.\\d{3}");
	
	public String padrao;
	
	ExtratorStringPadraoEnum(String padrao) {
		this.padrao = padrao;
	}
	
}
