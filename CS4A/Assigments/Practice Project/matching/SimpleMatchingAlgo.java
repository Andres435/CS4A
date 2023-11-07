package matching;

import java.util.ArrayList;
import common.*;

public class SimpleMatchingAlgo implements MatchingAlgorithm {

  
  /** 
   * @param featuresToMatch
   * @param allItems
   * @return ArrayList<FeatureSet>
   */
  public ArrayList<FeatureSet> findMatches(ArrayList<Feature> featuresToMatch, ArrayList<FeatureSet> allItems) {
    ArrayList<FeatureSet> returnValues = new ArrayList<>();

    for (FeatureSet fs : allItems) {
      for (Feature featureToMatch : featuresToMatch) {
        if (fs.containsFeature(featureToMatch.id()))
          returnValues.add(fs);
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