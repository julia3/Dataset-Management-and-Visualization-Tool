package datavisualization.model;

import java.util.*;
import dataset.*;

public class DataSet implements IDataSet{
	
    ArrayList<Value> datasets;
    private static int max= 2048;

    public DataSet(){
    	 datasets = new ArrayList<Value>();
    }
	
    public int max(){
    	return max;
    }
	public int addData(Value s) {
		int idx = datasets.size();
		
		if(idx>=max){ return -1;}
		datasets.add(s);
		return idx;
	} 
	
	public boolean removeNthData(int idx) {
		if(idx<0||idx>datasets.size())
			return false;
		datasets.remove(idx);
		return true;
	}
	public void removeAll(){
		datasets.clear();
	}
	public int indexOf(Value s){
		
		int idx=-1;
		for(int i=0;i<datasets.size();i++){
			if(s.toString().equals(datasets.get(i).toString())){
				idx=i;
			}
		}			
		return idx;
	}
	public Iterator<Value> iterator() { 
		return datasets.iterator();
	}

	public Value getNth(int i) {
		if(i<0||i>datasets.size())
			return null;
		return datasets.get(i);
	}
	
	public Boolean setNth(int i, Value s){
		if(i<0||i>datasets.size())
			return false;
		datasets.set(i,s);
		return true;		
	}
	
	@Override
	public int size() {
		return datasets.size(); 
		}

	@Override
	public double getMinX() {
		// TODO Auto-generated method stub
		double minX=datasets.get(0).getX();
		for (Iterator<Value> it = datasets.iterator(); it.hasNext(); ) {
			Value data = it.next();		
			double currentX = (double)data.getX();
			if (minX > currentX)
				minX = currentX;
		}
		return minX;
	}

	@Override
	public double getMaxX() {
		// TODO Auto-generated method stub
		double maxX=datasets.get(0).getX();
		for (Iterator<Value> it = datasets.iterator(); it.hasNext(); ) {
			Value data = it.next();		
			double currentX = (double)data.getX();
			if (maxX < currentX)
				maxX = currentX;
		}
		return maxX;
	}

	@Override
	public double getMinY() {
		// TODO Auto-generated method stub
		double minY=datasets.get(0).getY();
		for (Iterator<Value> it = datasets.iterator(); it.hasNext(); ) {
			Value data = it.next();		
			double currentY = (double)data.getY();
			if (minY > currentY)
				minY = currentY;
		}
		return minY;
	}

	@Override
	public double getMaxY() {
		// TODO Auto-generated method stub
		double maxY=datasets.get(0).getY();
		for (Iterator<Value> it = datasets.iterator(); it.hasNext(); ) {
			Value data = it.next();		
			double currentY = (double)data.getY();
			if (maxY < currentY)
				maxY = currentY;
		}
		return maxY;
	}

	@Override
	public double getCoordinate(int index, int dimension){
		// TODO Auto-generated method stub
        try {
		    if(index<0||index>datasets.size())
				throw new ArrayIndexOutOfBoundsException();
			if(dimension!=0&&dimension!=1)
				   throw new IllegalArgumentException();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double coordinate=0;
		if (dimension==0)
	        coordinate=(double)datasets.get(index).getX();
		else if(dimension==1)
			coordinate=(double)datasets.get(index).getY();
        return coordinate;
	}
}
