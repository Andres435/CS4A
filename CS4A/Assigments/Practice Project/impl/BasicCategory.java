package impl;

import java.io.Serializable;

import common.Category;
import utilities.DataValidation;
import java.util.Objects;

public class BasicCategory implements Category, Comparable<BasicCategory>, Cloneable, Serializable {

    private static final String Objects = null;
    private String id;
    private String description;
    private Category parent;

    public BasicCategory(String id, String description, Category parent) throws Exception {
        this.id = id;
        setDescription(description);
        setParent(parent);
    }


    
    /** 
     * @param description
     * @throws Exception
     */
    public void setDescription(String description) throws Exception {
        DataValidation.ensureNonEmptyString("BasicCategory.Description", description);
        this.description = description;
    }

    
    /** 
     * @param parent
     * @throws Exception
     */
    public void setParent(Category parent) throws Exception {
        DataValidation.ensureObjectNotNull("BasicCategory.Parent", parent);
        this.parent = parent;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BasicCategory)) {
            return false;
        }
        BasicCategory basicCategory = (BasicCategory) o;
        return id.equals(basicCategory.id());
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("[Category: Id = %s, Desc = %s, Parent: %s]", id, description, parent != null ? parent.description() : "<None>");
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(BasicCategory o) {
        return id.compareTo(o.id);
    }

    
    /** 
     * @return String
     */
    @Override
    public String id() {
      return id;
    }

    
    /** 
     * @return String
     */
    @Override
    public String description() {
        return description;
    }

    
    /** 
     * @return Category
     */
    @Override
    public Category parent() {
        return parent;
    }
    
    
    /** 
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
