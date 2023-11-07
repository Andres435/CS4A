package impl;

import java.io.Serializable;
import java.util.ArrayList;

import common.Feature;
import common.FeatureSet;

public class UniqueFeatureList implements FeatureSet, Cloneable, Serializable {

    private ArrayList<Feature> features;

    public UniqueFeatureList() {
        features = new ArrayList<>();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Unique\n");
        
        for (Feature f : features) {
            sb.append("\t");
            sb.append(f);
            sb.append("\n");
        }

        sb.append("}");

        return sb.toString();
    }

    
    /** 
     * @return ArrayList<Feature>
     */
    @Override
    public ArrayList<Feature> allFeatures() {
        return features;
    }

    
    /** 
     * @param feature
     */
    @Override
    public void addFeature(Feature feature) {
        if (!features.contains(feature))
            features.add(feature);
    }

    
    /** 
     * @param id
     */
    @Override
    public void removeFeature(String id) {
        for (int i = 0; i < features.size(); i++) {
            Feature next = features.get(i);

            if (next.id().equals(id)) {
                features.remove(i);
                return;
            }
                
        }
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean containsFeature(String id) {
        for (Feature f : features)
            if (f.id().equals(id))
                return true;

        return false;
    }
    
}
