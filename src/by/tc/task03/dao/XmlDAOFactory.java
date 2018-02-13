package by.tc.task03.dao;

import by.tc.task03.dao.impl.XmlTreeDAOImpl;

public final class XmlDAOFactory {
        private static final XmlDAOFactory instance = new XmlDAOFactory();
        private final XmlTreeDAO xmlTreeDAO = new XmlTreeDAOImpl();
        public XmlTreeDAO getApplianceDAO() {
            return xmlTreeDAO;
        }
        public static XmlDAOFactory getInstance() {
            return instance;
    }
}
