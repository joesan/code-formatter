/**
 * 
 */
package org.q31.util;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

/**
 * @author jothi
 *
 */
public class CodeFormatter extends BaseFormatter {

    private String sourceCode;

    public CodeFormatter(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getFormattedSourceCode() {
        return printMap(getIndentMap(getLinesOfCodeArray(sourceCode)));
    }

	private final String printMap(SortedMap < Long, TreeMap < String, String > > map) {
		String output = null;
        for (Map.Entry < Long, TreeMap < String, String > > entry : map.entrySet()) {
			TreeMap < String, String > val = entry.getValue();
			String tab = null;
			String text = null;
			for (Map.Entry < String, String > entr : val.entrySet()) {
				tab = entr.getKey();
				text = entr.getValue();
			}

            output = getOutputTextWithTabSpace(Long.valueOf(StringUtils.substring(tab, tab.length() - 1)), text);

			System.out.println(output);
		}
        return output;
	}	
	
	private String getOutputTextWithTabSpace(final long tab, final String text) {
		StringBuffer sb = new StringBuffer();
		
		for (long i=0; i<=tab; i++ ) {
			sb.append(TAB_SPACE);
		}
		if (StringUtils.endsWith(text, SPECIAL_CONTOL_CHAR)) {
			// If special characters are there at the end, remove them
			sb.append(text.substring(0, text.length() - 1));
		}
		else {
			sb.append(text);
		}
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//printMap(getIndentMap(getLinesOfCodeArray(sourceCode)));
	}
}