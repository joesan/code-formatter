/**
 * 
 */
package org.q31.util;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

/**
 * @author jothi
 *
 */
public class BaseFormatter {
	
	static SortedMap < Long, TreeMap < String, String > > locMap = new TreeMap < Long, TreeMap < String, String > > ();
	
	public static final String FILE_EXTENSION_JSP = "jsp";
	public static final String FILE_EXTENSION_JAVA = "java";
	public static final String FILE_EXTENSION_XML = "xml";
	
	public static final String TAB_SPACE = "   ";
	public static final String NEW_LINE = "\n";
	public static final char CURLY_BRACES_OPENING_CHAR = '{';
	public static final char CURLY_BRACES_CLOSING_CHAR = '}';
	public static final char SEMICOLON_CHAR = ';';
	public static final char EMPTY_CHAR = ' ';
	
	public static final String CURLY_BRACES_OPENING = "{";
	public static final String CURLY_BRACES_CLOSING = "}";
	public static final String BRACES_OPENING = "(";
	public static final String BRACES_CLOSING = ")";
	public static final String SEMICOLON = ";";
	public static final String EMPTY_STRING = "";
	
	public static final String SPECIAL_CONTOL_CHAR = "@";
	
	public static final String MAP_KEY_STR = "XXXX";
	
	protected static String whichStringIsNext(String next) {
		String nextStr = EMPTY_STRING;
		
		for (int i = 0; i < next.length(); i++) {
			if (next.charAt(i) == CURLY_BRACES_OPENING_CHAR) {
				nextStr = CURLY_BRACES_OPENING;
				break;
			}
			else if (next.charAt(i) == CURLY_BRACES_CLOSING_CHAR) {
				nextStr = CURLY_BRACES_CLOSING;
				break;
			}
			else if (next.charAt(i) == SEMICOLON_CHAR) {
				nextStr = SEMICOLON;
				break;
			}
		}		
		return nextStr;
	}
	
	protected static String getNextControlString(String val) {
		String nextStr = EMPTY_STRING;
		
		if (StringUtils.endsWith(val, SPECIAL_CONTOL_CHAR)) {
			nextStr = SPECIAL_CONTOL_CHAR;
		}
		else if (StringUtils.endsWith(val, CURLY_BRACES_CLOSING)) {
			nextStr = CURLY_BRACES_CLOSING;
		}
		else if (StringUtils.endsWith(val, CURLY_BRACES_OPENING)) {
			nextStr = CURLY_BRACES_OPENING;
		}
		else if (StringUtils.endsWith(val, SEMICOLON)) {
			nextStr = SEMICOLON;
		}
		
		return nextStr;
	}
	
	protected static List < String > getLinesOfCodeArray(final String text) {
		StringBuffer original = new StringBuffer(text);
		List < String > locList = new ArrayList < String > ();
		
		String firstStr = EMPTY_STRING;
		while(original.length() != 0) {
			firstStr = whichStringIsNext(original.toString());
			
			if (firstStr.equals(CURLY_BRACES_OPENING)) {
				String toBeAppended = original.substring(0, original.indexOf(CURLY_BRACES_OPENING) + 1).replaceAll("^\\s+", "");
				locList.add(toBeAppended);
				
				// Remove the appended String from the sb
				original.delete(0, (original.indexOf(CURLY_BRACES_OPENING, original.length() - original.length())) + 1);
			}
			else if (firstStr.equals(CURLY_BRACES_CLOSING)) {
				locList.add((original.substring(0, original.indexOf(CURLY_BRACES_CLOSING) + 1)).replaceAll("^\\s+", ""));
				
				// Remove the appended String from the sb
				original.delete(0, original.indexOf(CURLY_BRACES_CLOSING, original.length() - original.length()) + 1);
			}
			else {
				String toBeAppended = original.substring(0, original.indexOf(SEMICOLON) + 1).replaceAll("^\\s+", "");
				if (StringUtils.startsWith(toBeAppended, "for")) {
					toBeAppended = original.substring(0, original.indexOf(CURLY_BRACES_OPENING) + 1).replaceAll("^\\s+", "");
					locList.add(toBeAppended + SPECIAL_CONTOL_CHAR);
					
					// Remove the appended String from the sb			
					original.delete(0, original.indexOf(CURLY_BRACES_OPENING, original.length() - original.length()) + 1);
				}
				else {
					locList.add(toBeAppended);
					
					// Remove the appended String from the sb
					original.delete(0, original.indexOf(SEMICOLON, original.length() - original.length()) + 1);
				}
			}			
		}
		return locList;
	}

	protected static final SortedMap < Long, TreeMap < String, String > > getIndentMap(List < String > list) {
		// contains the lines of code
		List < String > locArr = list;
		Long incrementIndent = 0L;
		Long counter = 0L;
		String ctrlStr = EMPTY_STRING;
		for (String str : locArr) {
			TreeMap < String, String > mp = new TreeMap < String, String > ();
			if (incrementIndent == 0) {
				mp.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
				locMap.put(counter, mp);
				//linesOfCodeIndentMap.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
				incrementIndent++;
			}
			else {
				// Check which is next? { or } or ;
				ctrlStr = getNextControlString(str);
				
				if (ctrlStr.equals(CURLY_BRACES_OPENING)) {
					mp.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
					locMap.put(counter, mp);
					
					//linesOfCodeIndentMap.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
					incrementIndent++;
				}
				if (ctrlStr.equals(SPECIAL_CONTOL_CHAR)) { // will be set only in for loops
					mp.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
					locMap.put(counter, mp);
					
					//linesOfCodeIndentMap.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
					incrementIndent++;
				}
				else if (ctrlStr.equals(CURLY_BRACES_CLOSING)) {
					mp.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + (--incrementIndent), str);
					locMap.put(counter, mp);
					
					//linesOfCodeIndentMap.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + (--incrementIndent), str);
				}
				else if (ctrlStr.equals(SEMICOLON)) {
					mp.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
					locMap.put(counter, mp);
					
					//linesOfCodeIndentMap.put(counter + MAP_KEY_STR + SPECIAL_CONTOL_CHAR + incrementIndent, str);
				}				
			}
			counter++;
		}
		
		return locMap;
	}
}