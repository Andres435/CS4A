package impl;

import java.util.ArrayList;

import common.Feature;
import common.FeatureSet;
import common.MatchingAlgorithm;

public class SimpleMatchingAlgo implements MatchingAlgorithm {

    private ArrayList<FeatureSet> allItems;

    public SimpleMatchingAlgo(ArrayList<FeatureSet> items) {
        allItems = items;
    }

    
    /** 
     * @param featuresToMatch
     * @return ArrayList<FeatureSet>
     */
    @Override
    public ArrayList<FeatureSet> findMatches(ArrayList<Feature> featuresToMatch) {
        ArrayList<FeatureSet> returnValues = new ArrayList<>();
  
        for (FeatureSet fs : allItems) {
          for (Feature featureToMatch : featuresToMatch) {
            if (fs.containsFeature(featureToMatch.id()))
              returnValues.add(fs);
          }
        }
    
        return returnValues;
    }
  }