package datavisualization.controller;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import java.io.*;

import datavisualization.view.*;
import datavisualization.model.*;

public class LoadDataController {
	
	DataSet dataset;
	
	public LoadDataController(DataSet dataset){
		this.dataset=dataset;
	}
	
	public boolean act(DataOperationGUI dataOperationGUI){
		
		JFileChooser load= new JFileChooser();
		
		if (load.showOpenDialog(dataOperationGUI)!= JFileChooser.APPROVE_OPTION){
		    return false;
	    }
	
	    return loadFromFile(dataOperationGUI, load.getSelectedFile());
    }

    public boolean loadFromFile(DataOperationGUI dataOperationGUI, File input){
	
	    DefaultListModel<Value> list = (DefaultListModel) dataOperationGUI.getDataList().getModel();
	    list.removeAllElements();
	    dataset.removeAll();
	
	    BufferedReader reader=null;
	    try{
		    reader= new BufferedReader( new FileReader(input));
		    String line=null;
		
		    while ((line=reader.readLine())!=null){
			    Value data= Value.fromString(line);
			    if(data==null){
				    reader.close();
				    return false;
			    }
			    if (dataset.addData(data)==-1){
				    reader.close();
				    break;
			    }
		    }
	    } catch (IOException e){
		    e.printStackTrace();
		    return false;
	    }
	    for (int i=0; i< dataset.size(); i++){
		list.add(i,dataset.getNth(i));
	    }
	
	    dataOperationGUI.getGraphPanel().repaint();
	    
	    return true;
    }
}
