package com.gympassapply.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ExtratorStringUtil {
	
	public static String extrairStringPeloPadrao(final String padraoString, final String string) {
		Pattern pattern = Pattern.compile(padraoString);
		Matcher matcher = pattern.matcher(string);
		return matcher.find() ? matcher.group().trim() : null;
	}

}
