package se.cygni.web.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class WebUtil {

    private static Map<String, String> publisherMap = new HashMap<String, String>() {{
        put("Å&Å/Bonn", "aa");
        put("", "aafr");
        put("Bonn", "bonn");
        put("Bonn J", "bonnj");
        put("Bonn Ö N F", "bonnonf");
        put("Bonn Rr", "bonrr");
        put("BW Lejon", "bwlejon");
        put("BW pock", "bwpock");
        put("BW pop", "bwpop");
        put("BW ub", "bwub");
        put("", "bwuf");
        put("Disney", "disney");
        put("Gidlunds", "gidlunds");
        put("Iris", "iris");
        put("", "pilot");
        put("Schildts", "schildts");
        put("SEMIC", "semic");
        put("Sv Bokf", "svbok");
        put("Wahlströms", "wahlstroms");
    }};

    public static String getCoverImageUrl(String publisher, String title, String edition) {

        return "resources/images/covers/" +
                publisherMap.get(publisher) + "/" +
                normalizeTitleAndEdition(title, edition);

    }

    private static String normalizeTitleAndEdition(String title, String edition) {

        // Replace spaces with underscore
        String nTitle = StringUtils.replaceChars(title, ' ', '_');

        // To lower case
        nTitle = StringUtils.lowerCase(nTitle);

        // change åäö
        nTitle = StringUtils.replaceChars(nTitle, 'å', 'a');
        nTitle = StringUtils.replaceChars(nTitle, 'ä', 'a');
        nTitle = StringUtils.replaceChars(nTitle, 'ö', 'o');

        // Remove special chars
        nTitle = StringUtils.remove(nTitle, '\'');
        nTitle = StringUtils.remove(nTitle, ',');

        String editionOnly = StringUtils.split(edition, ',')[0];
        if (StringUtils.isNotEmpty(editionOnly) && !StringUtils.equals(editionOnly, "1")) {
            nTitle += "_" + editionOnly;
        }

        return nTitle + ".jpg";
    }
}
