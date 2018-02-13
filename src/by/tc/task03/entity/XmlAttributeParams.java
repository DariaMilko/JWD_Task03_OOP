package by.tc.task03.entity;

public class XmlAttributeParams {
    public XmlAttributeParams(String xmlAttributeName, String xmlAttributeValue) {
        this.xmlAttributeName = xmlAttributeName;
        this.xmlAttributeValue = xmlAttributeValue;
    }
    private String xmlAttributeName, xmlAttributeValue;
    
    public String getXmlAttributeName() {
        return xmlAttributeName;
    }

    public String getXmlAttributeValue() {
        return xmlAttributeValue;
    }

    @Override
    public String toString() {
        return String.format("%s = %s", this.xmlAttributeName, this.xmlAttributeValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlAttributeParams xmlAttribute = (XmlAttributeParams) o;
        if (xmlAttributeName != null ? !xmlAttributeName.equals(xmlAttribute.xmlAttributeName)
        		: xmlAttribute.xmlAttributeName != null) return false;
        return xmlAttributeValue != null ? xmlAttributeValue.equals(xmlAttribute.xmlAttributeValue)
        		: xmlAttribute.xmlAttributeValue == null;
    }

    @Override
    public int hashCode() {
        int result = xmlAttributeName != null ? xmlAttributeName.hashCode() : 0;
        result = 17 * result + (xmlAttributeValue != null ? xmlAttributeValue.hashCode() : 0);
        return result;
    }
}
