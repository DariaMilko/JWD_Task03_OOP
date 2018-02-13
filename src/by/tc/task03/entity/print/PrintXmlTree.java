package by.tc.task03.entity.print;

import by.tc.task03.entity.XmlTreeParams;

public class PrintXmlTree {
    public static void print(XmlTreeParams xmlTree)
    {
        if (xmlTree!=null) {
            System.out.println(xmlTree);
        }
        else
        {
            System.out.println("XML tree is empty!");
        }
    }
}
