package moviematching;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import common.Feature;
import common.FeatureSet;
import impl.UniqueFeatureList;

public class Actor implements Comparable<Actor>, Serializable, Cloneable, FeatureSet {
    private String name;
    private ArrayList<Movie> starredIn;
    private ArrayList<Character> charactersPlayed;
    private FeatureSet features;

    public Actor(String name) {
        this.name = name;
        this.starredIn = new ArrayList<>();
        this.charactersPlayed = new ArrayList<>();
        this.features = new UniqueFeatureList();
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return ArrayList<Movie>
     */
    public ArrayList<Movie> getStarredIn() {
        return this.starredIn;
    }

    
    /** 
     * @param f
     */
    public void addFeature(Feature f) {

    }
    
    /** 
     * @param m
     */
    public void addMovie(Movie m) {
        this.starredIn.add(m);
    }

    
    /** 
     * @return ArrayList<Character>
     */
    public ArrayList<Character> getCharactersPlayed() {
        return this.charactersPlayed;
    }

    
    /** 
     * @param c
     */
    public void addCharacter(Character c) {
        charactersPlayed.add(c);
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Actor)) {
            return false;
        }
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name);
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", starredIn='" + getStarredIn() + "'" +
            ", charactersPlayed='" + getCharactersPlayed() + "'" +
            "}";
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Actor o) {
        return name.compareTo(o.name);
    }

    
    /** 
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    
    /** 
     * @return ArrayList<Feature>
     */
    @Override
    public ArrayList<Feature> allFeatures() {
        return features.allFeatures();
    }

    
    /** 
     * @param id
     */
    @Override
    public void removeFeature(String id) {
       features.removeFeature(id);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean containsFeature(String id) {
        return features.containsFeature(id);
    }

}
