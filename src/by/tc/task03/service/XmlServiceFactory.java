package by.tc.task03.service;

import by.tc.task03.service.impl.XmlTreeServiceImpl;

public class XmlServiceFactory {
    private static final XmlServiceFactory instance = new XmlServiceFactory();
    private final XmlTreeService xmlTreeService = new XmlTreeServiceImpl();
    private XmlServiceFactory() {
    }

    public XmlTreeService getApplianceService() {
        return xmlTreeService;
    }

    public static XmlServiceFactory getInstance() {
        return instance;
    }

}
