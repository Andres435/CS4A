package utilities;

import java.util.UUID;

public class UUIDGenerator implements IdGenerator {

    
    /** 
     * @return String
     */
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
    
}
