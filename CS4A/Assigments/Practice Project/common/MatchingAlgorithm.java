package common;

import java.util.ArrayList;

public interface MatchingAlgorithm {
   ArrayList<FeatureSet> findMatches(ArrayList<Feature> featuresToMatch);
}