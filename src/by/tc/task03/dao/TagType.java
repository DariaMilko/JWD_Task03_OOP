package by.tc.task03.dao;

public enum TagType {
    CLOSE, OPEN, META, ERROR_TYPE;

    public static TagType getTagType(final String tag) {
        if (tag.startsWith("<?")) {
            return META;
        }
        if (tag.startsWith("<")) {
            return OPEN;
        }
        if (tag.startsWith("</")) {
            return CLOSE;
        }
        return ERROR_TYPE;
    }
}