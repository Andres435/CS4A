package matching;

import java.util.ArrayList;
import common.*;

public class PrioritizedMatchingAlgo implements MatchingAlgorithm {

  public PrioritizedMatchingAlgo(ArrayList<Feature> featuresToFind) {
	}


/** 
 * @param featuresToMatch
 * @param allItems
 * @return ArrayList<FeatureSet>
 */
public ArrayList<FeatureSet> findMatches(ArrayList<Feature> featuresToMatch, ArrayList<FeatureSet> allItems) {
    int[] featureScores = new int[allItems.size()];

    for (int i = 0; i < featureScores.length; i++) {
      FeatureSet fs = allItems.get(i);

      // find out number of feature matches.
      for (Feature f : featuresToMatch) {
        if (fs.containsFeature(f.id()))
          featureScores[i]++;
      }
    }

    return returnValues;
  }

  
  /** 
   * @param featuresToMatch
   * @param allItems
   * @return ArrayList<FeatureSet>
   */
  @Override
  public ArrayList<FeatureSet> findMatches(ArrayList<Feature> featuresToMatch, ArrayList<FeatureSet> allItems) {
    // TODO Auto-generated method stub
    return null;
  }

  
  /** 
   * @param featuresToMatch
   * @return ArrayList<FeatureSet>
   */
  @Override
  public ArrayList<FeatureSet> findMatches(ArrayList<Feature> featuresToMatch) {
    // TODO Auto-generated method stub
    return null;
  }
}