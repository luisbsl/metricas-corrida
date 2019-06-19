package com.gympassapply.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gympassapply.enums.ExtratorStringPadraoEnum;

public class ExtratorStringUtilTest {
	
	@Test
	public void extrairStringPeloPadrao() {
		String linhaDoArquivo = "23:49:08.277      038 – F.MASSA                           1		1:02.852                        44,275";
		
		String retorno = ExtratorStringUtil.extrairStringPeloPadrao(ExtratorStringPadraoEnum.HORA.padrao, linhaDoArquivo);
		assertEquals("23:49:08.277", retorno);
	}

}
