package org.sdargol.utils.exceptions;

public class NotSupportFieldByMappingException extends Exception{
    private final String className;
    private final String fieldName;

    public NotSupportFieldByMappingException(String message, String className, String fieldName) {
        super(message);
        this.className = className;
        this.fieldName = fieldName;
    }

    public String getClassName() {
        return className;
    }

    public String getFieldName() {
        return fieldName;
    }
}
