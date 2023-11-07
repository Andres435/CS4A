package moviematching;
 
import java.io.Serializable;
import java.util.Objects;

public class Character implements Comparable<Character>, Serializable, Cloneable {
    private String name;
    private Movie movie;

    public Character(String name, Movie movie) {
        this.name = name;
        this.movie = movie;
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
     * @return Movie
     */
    public Movie getMovie() {
        return this.movie;
    }

    
    /** 
     * @param movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Character)) {
            return false;
        }
        Character character = (Character) o;
        return Objects.equals(name, character.name) && Objects.equals(movie, character.movie);
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, movie);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", movie='" + getMovie() + "'" +
            "}";
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Character o) {
        String combined = name + ", " + movie.getName();
        String otherCombined = o.name + ", " + o.movie.getName();
        return combined.compareTo(otherCombined);
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

}
