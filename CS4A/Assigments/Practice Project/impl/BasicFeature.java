package impl;

import java.io.Serializable;
import java.util.Objects;

import common.Category;
import common.Feature;
import utilities.DataValidation;

public class BasicFeature implements Feature, Comparable<BasicFeature>, Cloneable, Serializable {

    private String id;
    private String name;
    private Category category;

    public BasicFeature(String id, String name, Category category)
        throws Exception 
    {
        this.id = id;
        setName(name);
        this.category = category;
    }

    
    /** 
     * @return Category
     */
    @Override
    public Category category() {
        return category;
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
    public String name() {
        return name;
    }
    
    
    /** 
     * @param name
     * @throws Exception
     */
    public void setName(String name) throws Exception {
        DataValidation.ensureNonEmptyString("BasicFeature.Name", name);
        this.name = name;
    }

    
    /** 
     * @param category
     * @throws Exception
     */
    public void setCategory(Category category) throws Exception {
        DataValidation.ensureObjectNotNull("BasicFeature.Category", category);
        this.category = category;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BasicFeature)) {
            return false;
        }
        BasicFeature basicFeature = (BasicFeature) o;
        return id.equals(basicFeature.id);
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("[Feature: Id = %s, Name = %s, Category: %s]", id, name, category.description());
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(BasicFeature o) {
        return id.compareTo(o.id);
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
