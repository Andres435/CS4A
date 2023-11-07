package moviematching;

import java.util.ArrayList;

import common.Feature;
import common.MatchingAlgorithm;

public interface IMovieMatcher {
    void addCharacterToMovie(Movie m, Actor a, String characterName);
    ArrayList<Movie> findActorFeatureMatches(ArrayList<Feature> actorFeatures);
}
