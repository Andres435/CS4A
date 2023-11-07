package moviematching;

import java.io.Serializable;
import java.util.ArrayList;

import common.Feature;
import common.FeatureSet;
import impl.SimpleMatchingAlgo;

public class MovieDatabase implements IMovieMatcher, Serializable {
    private ArrayList<Movie> movies;
    private ArrayList<Actor> actors;
    private ArrayList<Character> characters;

    public MovieDatabase() {
        movies = new ArrayList<>();
        actors = new ArrayList<>();
        characters = new ArrayList<>();
    }

    
    /** 
     * @param m
     * @param a
     * @param characterName
     */
    @Override
    public void addCharacterToMovie(Movie m, Actor a, String characterName) {
        Character ch = new Character(characterName, m);
        characters.add(ch);
        m.addActor(a);
        a.addMovie(m);
        a.addCharacter(ch);

        if (!movies.contains(m))
            movies.add(m);

        if (!actors.contains(a))
            actors.add(a);

        if (!characters.contains(ch))
            characters.add(ch);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MOVIE DB\n\n");
        sb.append("MOVIES\n");
        sb.append(movies);
        sb.append("\n\n");
        sb.append("CHARACTERS\n");
        sb.append(characters);
        sb.append("\n\n");
        sb.append("ACTORS\n");
        sb.append(actors);

        return sb.toString();
    }

    
    /** 
     * @param actorFeatures
     * @return ArrayList<Movie>
     */
    @Override
    public ArrayList<Movie> findActorFeatureMatches(ArrayList<Feature> actorFeatures) {
        ArrayList<FeatureSet> actorsAsFeatureSets = new ArrayList<>();
        for (FeatureSet fs : actors)
            actorsAsFeatureSets.add(fs);

        SimpleMatchingAlgo algo = new SimpleMatchingAlgo(actorsAsFeatureSets);
        ArrayList<FeatureSet> actorsThatHaveFeature = algo.findMatches(actorFeatures);

        ArrayList<Movie> moviesThatMatch = new ArrayList<>();
        for (FeatureSet fs : actorsThatHaveFeature) {
            ArrayList<Movie> actorMovies = ((Actor)fs).getStarredIn();
            for (Movie m : actorMovies)
                if (!moviesThatMatch.contains(m))
                    moviesThatMatch.add(m);

        }

        return moviesThatMatch;
    }
    
}
