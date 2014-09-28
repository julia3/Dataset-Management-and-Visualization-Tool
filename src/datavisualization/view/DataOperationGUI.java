package datavisualization.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

import properties.ApplicationProperties;
import properties.GraphProperties;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;

import datavisualization.controller.*;
import datavisualization.model.*;
import dataset.*;

public class DataOperationGUI extends JFrame {

	
	//Declare variables
	JTextField textInputField;
	JList dataList;
	GraphPanel graphPanel;
	JButton showCartesianButton;
	JButton showColumnButton;
	JButton showHorizontalbargraph;
	JButton showMultipleLines;
	JButton addButton;
	JButton saveButton;
	JButton loadButton;
	JButton deleteButton;
	JButton editButton;
	JRadioButton showEquationButton;
	JRadioButton hideEquationButton;
	JRadioButton showTrendLineButton;
	JRadioButton hideTrendLineButton;
	JRadioButton showHorizontalLinesButton;
	JRadioButton hideHorizontalLinesButton;
	JRadioButton showXAxisLabelsButton;
	JRadioButton hideXAxisLabelsButton;
	JRadioButton showYAxisLabelsButton;
	JRadioButton hideYAxisLabelsButton;
	
    DataSet dataset= new DataSet();
    
    //Get method
	public JTextField getDataField() { return textInputField; }
	public JList getDataList()	{ return dataList; }
	public GraphPanel getGraphPanel(){return graphPanel;}
	public JRadioButton getShowTrendLineButton() { return showTrendLineButton; }
	public JRadioButton getHideTrendLineButton() { return hideTrendLineButton; }
	public JRadioButton getShowXAxisButton() { return showXAxisLabelsButton; }
	public JRadioButton getHideXAxisButton() { return hideXAxisLabelsButton; }
	public JRadioButton getShowYAxisButton() { return showYAxisLabelsButton; }
	public JRadioButton getHideYAxisButton() { return hideYAxisLabelsButton; }
	public JRadioButton getShowHorizontalLinesButton() { return showHorizontalLinesButton; }
	public JRadioButton getHideHorizontalLinesButton() { return hideHorizontalLinesButton; }
	public JRadioButton getShowEquationButton() { return showEquationButton; }
	public JRadioButton getHideEquationButton() { return hideEquationButton; }
	public IDataSet getDataSet(){ return dataset;}

	//Build frame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataOperationGUI frame = new DataOperationGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DataOperationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 712);

		JScrollPane scrollPane = new JScrollPane();

		textInputField = new JTextField();
		textInputField.setColumns(10);
		
		graphPanel = new GraphPanel(dataset);
		dataList = new JList();
		dataList.setModel(new DefaultListModel<Value>());
		scrollPane.setViewportView(dataList);
		//load button
		loadButton = new JButton("Load");
		
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoadDataController(DataOperationGUI.this.dataset).act(DataOperationGUI.this);				
			}
			
		});
		//draw cartesian botton
		showCartesianButton = new JButton("CartesianPlot");
		
		showCartesianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ShowGraphController().act(DataOperationGUI.this,GraphEnum.CartesianGraph);				
			}
			
		});
		//draw column button
		showColumnButton = new JButton("ColumnGraph");
		
		showColumnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    new ShowGraphController().act(DataOperationGUI.this,GraphEnum.ColumnGraph);				
			}
			
		});
		//save button
		saveButton = new JButton("Save");
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SaveDataController(DataOperationGUI.this.dataset).act(DataOperationGUI.this);				
			}
			
		});
		
		//edit button
		editButton = new JButton("Edit");
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditDataController(DataOperationGUI.this.dataset).act(DataOperationGUI.this);				
			}
			
		});
		
		//add button
		addButton = new JButton("Add");
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddNewDataController(DataOperationGUI.this.dataset).act(DataOperationGUI.this);				
			}
			
		});
		
		
		//delete button
		deleteButton = new JButton("Delete");
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeleteDataController(DataOperationGUI.this.dataset).act(DataOperationGUI.this);				
			}
			
		});
		
		//show trend line button
		showTrendLineButton = new JRadioButton("ShowTrendLine");
		
		showTrendLineButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new ShowTrendLineController().act(DataOperationGUI.this);				
			}
			
		});
		
		//hide trend line button
		hideTrendLineButton = new JRadioButton("HideTrendLine");
		
		hideTrendLineButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new HideTrendLineController().act(DataOperationGUI.this);				
			}
			
		});
		
		ButtonGroup trendButton=new ButtonGroup();
		trendButton.add(showTrendLineButton);
		trendButton.add(hideTrendLineButton);
		
		//show equation button
		showEquationButton = new JRadioButton("ShowEquation");
		
		showEquationButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			    new ShowEquationController().act(DataOperationGUI.this);				
			}
			
		});
		
		
		//hide equation button
		hideEquationButton = new JRadioButton("HideEquation");
		
		hideEquationButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new HideEquationController().act(DataOperationGUI.this);				
			}
			
		});
		
		ButtonGroup equationButton=new ButtonGroup();
		equationButton.add(showEquationButton);
		equationButton.add(hideEquationButton);
		
		//show horizontal lines button
		showHorizontalLinesButton = new JRadioButton("ShowHorizontalLines");
		
		showHorizontalLinesButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new ShowHorizontalLinesController().act(DataOperationGUI.this);				
			}
			
		});
		
		
		
		//hide horizontal lines button
		hideHorizontalLinesButton = new JRadioButton("HideHorizontalLines");
		
		hideHorizontalLinesButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new HideHorizontalLinesController().act(DataOperationGUI.this);				
			}
			
		});
		
		ButtonGroup horizontalLinesButton=new ButtonGroup();
		horizontalLinesButton.add(showHorizontalLinesButton);
		horizontalLinesButton.add(hideHorizontalLinesButton);
		
		
		//show Xaxis button
		showXAxisLabelsButton = new JRadioButton("ShowXAxisLabels");
		
		showXAxisLabelsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new ShowXAxisLabelsController().act(DataOperationGUI.this);				
			}
			
		});
		
		//hide Xaxis button
		hideXAxisLabelsButton = new JRadioButton("HideXAxisLabels");
		
		hideXAxisLabelsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new HideXAxisLabelsController().act(DataOperationGUI.this);				
			}
			
		});
		
		ButtonGroup xAxisButton=new ButtonGroup();
		xAxisButton.add(showXAxisLabelsButton);
		xAxisButton.add(hideXAxisLabelsButton);
		
		//show Yaxes button
		showYAxisLabelsButton = new JRadioButton("ShowYAxisLabels");
		
		showYAxisLabelsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new ShowYAxisLabelsController().act(DataOperationGUI.this);				
			}
			
		});
		
		//hide axes button
		hideYAxisLabelsButton = new JRadioButton("HideYAxisLabels");
		
		hideYAxisLabelsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new HideYAxisLabelsController().act(DataOperationGUI.this);				
			}
			
		});
		
		ButtonGroup yAxisButton=new ButtonGroup();
		yAxisButton.add(showYAxisLabelsButton);
		yAxisButton.add(hideYAxisLabelsButton);
		
	//new	
		showMultipleLines = new JButton("MultipleLines");
		showMultipleLines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ShowGraphController().act(DataOperationGUI.this,GraphEnum.MultipleLinesGraph);
			}
		});

		showHorizontalbargraph = new JButton("HorizontalBarGraph");
		showHorizontalbargraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ShowGraphController().act(DataOperationGUI.this,GraphEnum.HorizontalBarGraph);
			}
		});
		
		//just load application properties
		ApplicationProperties.getApplicationProperties();
		//just load graph properties
		GraphProperties.getGraphProperties();
		
		
		//Set layout
		GroupLayout gl_contentPane = new GroupLayout(getContentPane());
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(loadButton)
							.addGap(18)
							.addComponent(saveButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(addButton)
								.addComponent(textInputField, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(editButton)
							.addGap(18)
							.addComponent(deleteButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(showYAxisLabelsButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
									.addGap(80))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(showTrendLineButton)
										.addComponent(showEquationButton)
										.addComponent(showHorizontalLinesButton)
										.addComponent(showXAxisLabelsButton)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(showColumnButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(showCartesianButton)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(80)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(hideTrendLineButton)
												.addComponent(hideEquationButton)
												.addComponent(hideHorizontalLinesButton)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(hideYAxisLabelsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(hideXAxisLabelsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(showMultipleLines)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(showHorizontalbargraph, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
									.addGap(10)))
							.addGap(10))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(loadButton)
								.addComponent(saveButton))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(editButton)
								.addComponent(deleteButton))
							.addGap(37)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(199)
							.addComponent(addButton)
							.addGap(27)
							.addComponent(textInputField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(showMultipleLines, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
									.addComponent(showHorizontalbargraph, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
								.addComponent(showCartesianButton, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
								.addComponent(showColumnButton, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(showTrendLineButton)
								.addComponent(hideTrendLineButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(showEquationButton)
								.addComponent(hideEquationButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(showHorizontalLinesButton)
								.addComponent(hideHorizontalLinesButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(showXAxisLabelsButton)
								.addComponent(hideXAxisLabelsButton))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(showYAxisLabelsButton)
						.addComponent(hideYAxisLabelsButton))
					.addGap(81))
		);
		
		getContentPane().setLayout(gl_contentPane);
	}
}
