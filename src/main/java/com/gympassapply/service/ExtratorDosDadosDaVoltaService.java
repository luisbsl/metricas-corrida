package com.gympassapply.service;

import com.gympassapply.enums.ExtratorStringPadraoEnum;
import com.gympassapply.exception.PadraoStringNaoEncontradoException;
import com.gympassapply.model.Piloto;
import com.gympassapply.model.Volta;
import com.gympassapply.model.builder.VoltaBuilder;
import com.gympassapply.util.ExtratorStringUtil;

public class ExtratorDosDadosDaVoltaService {
	private String linhaDoArquivo;
	
	public Volta extrairVoltaDoPiloto(final String linhaDoArquivo) {
		this.linhaDoArquivo = linhaDoArquivo;
		Volta volta = 
				new VoltaBuilder()
						.comNumero(getNumeroDaVolta())
						.comHora(getHoraDaVolta())
						.comTempoDaVolta(getTempoDaVolta())
						.comVelocidadeMedia(getVelocidadeMediaDaVolta())
						.build();
		return volta;
	}
	
	public Piloto extrairPiloto(final String linhaDoArquivo) {
		this.linhaDoArquivo = linhaDoArquivo;
		Piloto piloto = new Piloto(getCodigoPiloto(), getNomePiloto());
		return piloto;
	}
	
	private Integer getNumeroDaVolta() {
		final String numeroDaVolta = extrairDadosDaLinhaDoArquivoPeloPadrao(ExtratorStringPadraoEnum.NUMERO_DA_VOLTA.padrao, linhaDoArquivo);
		if(numeroDaVolta==null) throw new PadraoStringNaoEncontradoException();
		return Integer.valueOf(numeroDaVolta);
	}
	
	private String getCodigoPiloto() {
		final String codigoPiloto = extrairDadosDaLinhaDoArquivoPeloPadrao(ExtratorStringPadraoEnum.CODIGO_PILOTO.padrao, linhaDoArquivo); 
		if(codigoPiloto==null) throw new PadraoStringNaoEncontradoException();
		return codigoPiloto;
	}
	
	private String getNomePiloto() {
		final String nomePiloto = extrairDadosDaLinhaDoArquivoPeloPadrao(ExtratorStringPadraoEnum.NOME_PILOTO.padrao, linhaDoArquivo);
		if(nomePiloto==null) throw new PadraoStringNaoEncontradoException();
		return nomePiloto;
	}
	
	private String getTempoDaVolta() {
		final String tempoDaVolta = extrairDadosDaLinhaDoArquivoPeloPadrao(ExtratorStringPadraoEnum.TEMPO_DA_VOLTA.padrao, linhaDoArquivo);
		if(tempoDaVolta==null) throw new PadraoStringNaoEncontradoException();
		return tempoDaVolta;
	}
	
	private String getVelocidadeMediaDaVolta() {
		final String velocidadeMedia = extrairDadosDaLinhaDoArquivoPeloPadrao(ExtratorStringPadraoEnum.VELOCIDADE_MEDIA_DA_VOLTA.padrao, linhaDoArquivo);
		if(velocidadeMedia==null) throw new PadraoStringNaoEncontradoException();
		return velocidadeMedia;
	}
	
	private String getHoraDaVolta() {
		final String horaDaVolta= extrairDadosDaLinhaDoArquivoPeloPadrao(ExtratorStringPadraoEnum.HORA.padrao, linhaDoArquivo);
		if(horaDaVolta==null) throw new PadraoStringNaoEncontradoException();
		return horaDaVolta;
	}
	
	private String extrairDadosDaLinhaDoArquivoPeloPadrao(final String padrao, final String linhaDoArquivo) {
		return ExtratorStringUtil.extrairStringPeloPadrao(padrao, linhaDoArquivo);
	}

}
