package utilities;

public final class DataValidation {
    private DataValidation() {}

    
    /** 
     * @param propertyName
     * @param value
     * @throws Exception
     */
    public static void ensureNonEmptyString(String propertyName, String value) throws Exception {
        if (value == null || value.trim().equals(""))
            throw new Exception(String.format("%s cannot be null or empty", propertyName));
    }

    
    /** 
     * @param propertyName
     * @param value
     * @throws Exception
     */
    public static void ensureObjectNotNull(String propertyName, Object value) throws Exception {
        if (value == null)
            throw new Exception(String.format("%s cannot be null", propertyName));
    }

    
}
