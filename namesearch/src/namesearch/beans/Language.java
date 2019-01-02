/*
 * Created on Jun 24, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package namesearch.beans;

import java.util.*;

/**
 * @author DSHRESTHA
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Language {
	public static List langList = new ArrayList();

	public static List getLangList() {
		if (langList.size() == 0) {
			langList.add("A");
			langList.add("ARABIC");
			langList.add("C");
			langList.add("CHINESE");
			langList.add("D");
			langList.add("DANISH");
			langList.add("1");
			langList.add("DUTCH");
			langList.add("F");
			langList.add("FRENCH");
			langList.add("G");
			langList.add("GERMAN");
			langList.add("Q");
			langList.add("GREEK");
			langList.add("B");
			langList.add("HEBREW");
			langList.add("4");
			langList.add("HINDI");
			langList.add("H");
			langList.add("HUNGARIAN");
			langList.add("N");
			langList.add("INDIAN");
			langList.add("8");
			langList.add("IRANIAN");
			langList.add("I");
			langList.add("ITALIAN");
			langList.add("J");
			langList.add("JAPANESE");
			langList.add("K");
			langList.add("KOREAN");
			langList.add("M");
			langList.add("MANDARIN");
			langList.add("3");
			langList.add("PAKISTANI");
			langList.add("2");
			langList.add("PERSIAN");
			langList.add("O");
			langList.add("PHILIPINA");
			langList.add("L");
			langList.add("POLISH");
			langList.add("P");
			langList.add("PORTUGUESE");
			langList.add("6");
			langList.add("ROMANIAN");
			langList.add("R");
			langList.add("RUSSIAN");
			langList.add("S");
			langList.add("SPANISH");
			langList.add("W");
			langList.add("SWEDISH");
			langList.add("7");
			langList.add("TAGALOG");
			langList.add("X");
			langList.add("THAI");
			langList.add("T");
			langList.add("TURKISH");
			langList.add("U");
			langList.add("UKRANIAN");
			langList.add("5");
			langList.add("URDU");
			langList.add("V");
			langList.add("VIETNAMESE");
			langList.add("Y");
			langList.add("YUGOSLAVIAN");
			langList.add("Z");
			langList.add("OTHER");
		}
		return langList;
	}
}
