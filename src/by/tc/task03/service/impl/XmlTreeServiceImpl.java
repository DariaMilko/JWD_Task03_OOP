package by.tc.task03.service.impl;

import by.tc.task03.dao.XmlDAOFactory;
import by.tc.task03.dao.XmlTreeDAO;
import by.tc.task03.entity.XmlTreeParams;
import by.tc.task03.service.XmlTreeService;

public class XmlTreeServiceImpl implements XmlTreeService{
    public XmlTreeParams parseXmlFile(){
        XmlDAOFactory xmlDAOFactory = XmlDAOFactory.getInstance();
        XmlTreeDAO xmlTreeDAO = xmlDAOFactory.getApplianceDAO();
        XmlTreeParams xmlTree = xmlTreeDAO.parseXmlFile();
        return xmlTree;
    }
}

