package utilities;

public class IntegerIdGenerator implements IdGenerator{

    private int currentNumber;
    
    public IntegerIdGenerator(int startNumber) {
        currentNumber = startNumber;
    }

    public IntegerIdGenerator() {
        this(1);
    }

    
    /** 
     * @return String
     */
    @Override
    public String generateId() {
        String id = "" + currentNumber;
        currentNumber++;
        return id;
    }
    
}
