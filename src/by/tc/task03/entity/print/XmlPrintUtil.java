package by.tc.task03.entity.print;

import java.util.Collections;

public class XmlPrintUtil {
    public static final String writeInXmlNode(final int xmlNodeLevel) {
        if (xmlNodeLevel < 0)
            return "";
        return String.join("", Collections.nCopies(xmlNodeLevel, "  "));
    }
}
