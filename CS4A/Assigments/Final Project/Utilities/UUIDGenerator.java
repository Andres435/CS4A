/**
 * Class that Implements Unique ID's for an inidviduo
 */
package Utilities;
import java.util.UUID;

public class UUIDGenerator implements IdGenerator {    
    /** 
     * generateId-- Implements unique Id
     * @return String
     */
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
