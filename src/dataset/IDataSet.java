package dataset;

import java.util.Iterator;

import datavisualization.model.Value;

public interface IDataSet {
    int size();
    double getMinX();
    double getMaxX();
    double getMinY();
    double getMaxY();
    
    double getCoordinate(int index, int dimension);
}
