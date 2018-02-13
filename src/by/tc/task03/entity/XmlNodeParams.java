package by.tc.task03.entity;

import java.util.ArrayList;
import java.util.List;

public class XmlNodeParams{

    public XmlNodeParams(String xmlNodeName, List<XmlAttributeParams> xmlNodeAttributes) {
        this.xmlNodeName = xmlNodeName;
        this.xmlNodeAttributes = xmlNodeAttributes;
    }

    private String xmlNodeName;
    public void setXmlNodeName(String xmlNodeName) {
        this.xmlNodeName = xmlNodeName;
    }
    public String getXmlNodeName() {
        return xmlNodeName;
    }

    private List<XmlAttributeParams> xmlNodeAttributes = new ArrayList<>();
    public void setXmlNodeAttributes(List<XmlAttributeParams> xmlNodeAttributes) {
        this.xmlNodeAttributes = xmlNodeAttributes;
    }
    public List<XmlAttributeParams> getAttributes() {
        return xmlNodeAttributes;
    }

    private String xmlNodeValue;
    public void setXmlNodeValue(String xmlNodeValue) {
        this.xmlNodeValue = xmlNodeValue;
    }
    public String getXmlNodeValue() {
        return xmlNodeValue;
    }

    private int xmlNodeLevel;
    public void setXmlNodeLevel(int xmlNodeLevel) {
        this.xmlNodeLevel = xmlNodeLevel;
    }
    public int getXmlNodeLevel() {
        return xmlNodeLevel;
    }

    private List<XmlNodeParams> xmlNodes = new ArrayList<>();
    public List<XmlNodeParams> getNodes() {
        return xmlNodes;
    }
    public void setXmlNodes(List<XmlNodeParams> xmlNodes) {
        this.xmlNodes = xmlNodes;
    }
    public void addChildNode(XmlNodeParams xmlNode) {
        xmlNodes.add(xmlNode);
    }
    
    @Override
    public String toString() {
        final StringBuilder info = new StringBuilder(this.xmlNodeName).append(" ");
        this.xmlNodeAttributes.forEach(nodeAttribute -> info.append(nodeAttribute.toString()));
        if (this.xmlNodeValue != null) {
            info.append(" - ").append(this.xmlNodeValue);
        }
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlNodeParams xmlNode = (XmlNodeParams) o;
        if (xmlNodeLevel != xmlNode.xmlNodeLevel) return false;
        if (xmlNodeName != null ? !xmlNodeName.equals(xmlNode.xmlNodeName) :
        	xmlNode.xmlNodeName != null) return false;
        if (xmlNodeAttributes != null ? !xmlNodeAttributes.equals(xmlNode.xmlNodeAttributes) :
        	xmlNode.xmlNodeAttributes != null) return false;
        if (xmlNodeValue != null ? !xmlNodeValue.equals(xmlNode.xmlNodeValue) : xmlNode.xmlNodeValue != null) return false;
        return xmlNodes != null ? xmlNodes.equals(xmlNode.xmlNodes) : xmlNode.xmlNodes == null;
    }

    @Override
    public int hashCode() {
        int result = xmlNodeName != null ? xmlNodeName.hashCode() : 0;
        result = 17 * result + (xmlNodeAttributes != null ? xmlNodeAttributes.hashCode() : 0);
        result = 17 * result + (xmlNodeValue != null ? xmlNodeValue.hashCode() : 0);
        result = 17 * result + xmlNodeLevel;
        result = 17 * result + (xmlNodes != null ? xmlNodes.hashCode() : 0);
        return result;
    }
}
