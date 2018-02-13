package by.tc.task03.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task03.dao.TagType;
import by.tc.task03.dao.XmlTreeDAO;
import by.tc.task03.entity.XmlAttributeParams;
import by.tc.task03.entity.XmlNodeParams;
import by.tc.task03.entity.XmlTreeParams;

public final class XmlTreeDAOImpl implements XmlTreeDAO {

	public final String FILE_NAME = "task03.xml";
	
    private List<XmlAttributeParams> getAttributes(String tag) {
        Pattern pattern = Pattern.compile("\\s(\\w+)=\"(\\w+)\"");
        Matcher matcher = pattern.matcher(tag);
        
        List<XmlAttributeParams> attributes = new ArrayList<>();
        while (matcher.find()) {
            attributes.add(new XmlAttributeParams(matcher.group(1), matcher.group(2)));
        }
        return attributes;
    }

    private String getNodeNameByTag(String tag) {
        String nodeNameByTag = "";
        Pattern patternTagName = Pattern.compile("\\w+");
        Matcher matcher = patternTagName.matcher(tag);
        if (matcher.find()) {
            nodeNameByTag = matcher.group();
        }
        return nodeNameByTag;
    }

    private String openXmlToReadStrings() {
        try {
            String readingLineFromXmlFile;
            final ClassLoader classLoader = XmlTreeDAOImpl.class.getClassLoader();
            File file = new File(classLoader.getResource(FILE_NAME).getFile());
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while ((readingLineFromXmlFile = reader.readLine()) != null) {
                    stringBuilder.append(readingLineFromXmlFile.trim());
                }
                reader.close();
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return null;
        }
    }

    public XmlTreeParams parseXmlFile() {
        XmlTreeParams xmlTree = new XmlTreeParams();
        String xmlFileToReadStrings = openXmlToReadStrings();
        Map<String, Integer> mapOfTagsWithLevels = new HashMap<>();
        Stack<XmlNodeParams> xmlNodeStack = new Stack<>();
        int nodeLevelInXmlFile = 0;
        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(xmlFileToReadStrings);
        List<XmlAttributeParams> xmlAttributes = new ArrayList<>();
        TagType previousTag = TagType.CLOSE;
        int previousEndIndex = 0;
        while (matcher.find()) {
            String tag = matcher.group();
            if (TagType.getTagType(tag) == TagType.OPEN) {
                mapOfTagsWithLevels.put(tag, nodeLevelInXmlFile);
                nodeLevelInXmlFile++;
            }
            if (TagType.getTagType(tag) == TagType.CLOSE) {
                for (String key : mapOfTagsWithLevels.keySet()) {
                    if (getNodeNameByTag(key).equals(getNodeNameByTag(tag))) {
                        xmlAttributes = getAttributes(key);
                        mapOfTagsWithLevels.remove(key);
                        break;
                    }
                }
                XmlNodeParams xmlNode = new XmlNodeParams(getNodeNameByTag(tag), xmlAttributes);
                xmlNode.setXmlNodeLevel(nodeLevelInXmlFile);
                if (previousTag == TagType.OPEN) {
                    xmlNode.setXmlNodeValue(xmlFileToReadStrings.substring(previousEndIndex, matcher.start()));
                }
                while (!xmlNodeStack.isEmpty() && xmlNodeStack.peek().getXmlNodeLevel() > xmlNode.getXmlNodeLevel()) {
                    xmlNode.addChildNode(xmlNodeStack.pop());
                }
                xmlNodeStack.push(xmlNode);
                nodeLevelInXmlFile--;
            }
            previousTag = TagType.getTagType(tag);
            previousEndIndex = matcher.end();
        }
        xmlTree.setRoot(xmlNodeStack.pop());
        return xmlTree;
    }
}
