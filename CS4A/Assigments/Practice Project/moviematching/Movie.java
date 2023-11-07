package moviematching;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Movie implements Comparable<Movie>, Serializable, Cloneable {
    private String name;
    private Date premierDate;
    private ArrayList<Actor> actors;
    private ArrayList<Character> characters;


    public Movie(String name, Date premierDate) {
        this.name = name;
        this.premierDate = premierDate;
        this.actors = new ArrayList<>();
        this.characters = new ArrayList<>();
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
     * @return Date
     */
    public Date getPremierDate() {
        return this.premierDate;
    }

    
    /** 
     * @param premierDate
     */
    public void setPremierDate(Date premierDate) {
        this.premierDate = premierDate;
    }

    
    /** 
     * @return ArrayList<Actor>
     */
    public ArrayList<Actor> getActors() {
        return this.actors;
    }

    
    /** 
     * @param actor
     */
    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    
    /** 
     * @return ArrayList<Character>
     */
    public ArrayList<Character> getCharacters() {
        return this.characters;
    }

    
    /** 
     * @param character
     */
    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    
    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return name.equals(movie.getName());
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", premierDate='" + getPremierDate() + "'" +
            ", actors='" + getActors() + "'" +
            ", characters='" + getCharacters() + "'" +
            "}";
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Movie o) {
        return name.compareTo(o.name);
    }

    
    /** 
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Movie copy = (Movie) super.clone();
        copy.premierDate = (Date) premierDate.clone();
        return copy;
    }

}
