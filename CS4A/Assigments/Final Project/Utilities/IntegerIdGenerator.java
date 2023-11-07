/**
 * Class that Implements ID's for an Sessions
 */
package Utilities;

public class IntegerIdGenerator implements IdGenerator {
    private static int currentNumber;

    public IntegerIdGenerator(int startNumber) {
        currentNumber = startNumber;
    }

    public IntegerIdGenerator() {
        this(1);
    }

    
    /** 
     * generateId-- Implements not unique Id
     * @return String
     */
    @Override
    public String generateId() {
        String id = "" + currentNumber;
        currentNumber++;
        return id;
    }
}