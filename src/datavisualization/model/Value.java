package datavisualization.model;

public class Value {
	
	float x,y;
	
	public Value(float x, float y){
	    this.x=x;
	    this.y=y;
	
	}
    
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public String toString(){
		return x+","+y;
	}
	
	public static Value fromString(String dataset){
		if(dataset==null)
		return null;
		
		String datasets[] = dataset.split(",");
		float x,y;
		try{
			x=Float.parseFloat(datasets[0]);
			y=Float.parseFloat(datasets[1]);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
			return null;
		}
		return new Value(x,y);
	}
	
}
