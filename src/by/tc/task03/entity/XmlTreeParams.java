package by.tc.task03.entity;

import by.tc.task03.entity.print.XmlPrintUtil;

public class XmlTreeParams{// сколько раз мы повторяли, что классы не стоит называть множественным числом

    private XmlNodeParams rootNode;
    public void setRoot(XmlNodeParams rootNode) {
        this.rootNode = rootNode;
    }
    public XmlNodeParams getRootNode() {
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        getNodeList(this.rootNode, stringBuilder);
        return stringBuilder.toString();
    }

    private void getNodeList(final XmlNodeParams xmlNode, final StringBuilder stringBuilder) {
        final String xmlNodePadding = XmlPrintUtil.writeInXmlNode(xmlNode.getXmlNodeLevel());
        stringBuilder.append(xmlNodePadding).append(xmlNode).append("\n");
        for (final XmlNodeParams currentNode : xmlNode.getNodes()) {
            getNodeList(currentNode, stringBuilder);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlTreeParams xmlTree = (XmlTreeParams) o;
        return rootNode != null ? rootNode.equals(xmlTree.rootNode) : xmlTree.rootNode == null;
    }

    @Override
    public int hashCode() {
        return rootNode != null ? rootNode.hashCode() : 0;
    }
}
