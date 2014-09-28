package datavisualization.controller;

import javax.swing.JFileChooser;

import java.util.*;
import java.io.*;

import datavisualization.view.*;
import datavisualization.model.*;

public class SaveDataController {
	DataSet dataset;
	
	public SaveDataController(DataSet dataset){
		this.dataset=dataset;
	}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		JFileChooser save = new JFileChooser();
		if (save.showSaveDialog(dataOperationGUI) != JFileChooser.APPROVE_OPTION) {
			return false;
		}

		return saveToFile(save.getSelectedFile());
	}

	boolean saveToFile(File output) {
		try {
			PrintStream ps = new PrintStream(output);
			for (Iterator<Value> it = dataset.iterator(); it.hasNext(); ) {
				Value dataset = it.next();
				ps.println(dataset);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
