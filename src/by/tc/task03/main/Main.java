package by.tc.task03.main;

import by.tc.task03.entity.XmlTreeParams;
import by.tc.task03.entity.print.PrintXmlTree;
import by.tc.task03.service.XmlServiceFactory;
import by.tc.task03.service.XmlTreeService;

public class Main {
    public static void main(String... args) {    	
        XmlServiceFactory xmlServiceFactory = XmlServiceFactory.getInstance();
        XmlTreeService xmlService  = xmlServiceFactory.getApplianceService();
        XmlTreeParams xmlTree = xmlService.parseXmlFile();
        PrintXmlTree.print(xmlTree);
    }
}
