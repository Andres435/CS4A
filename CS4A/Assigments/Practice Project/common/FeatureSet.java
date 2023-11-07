package common;

import java.util.ArrayList;

public interface FeatureSet {
  ArrayList<Feature> allFeatures();
  void addFeature(Feature feature);
  void removeFeature(String id);
  boolean containsFeature(String id);
}