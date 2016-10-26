package calculator;

import java.awt.event.*;
import java.util.*;

public class CalController {
	
	private CalModel model;
	private CalView view;
	
	

	public CalController(CalModel model, CalView view) {
		this.model = model;
		this.view = view;
		view.addGetListener(new GetActionListener());
	}
	
	
	private class GetActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int result;
			ArrayList<Integer> markList = new ArrayList<Integer>();
			try {
				markList = view.getMark();
			} catch (InvalidInputException e1) {
				
				e1.printStackTrace();
			}
			
			ArrayList<Integer> weightList = new ArrayList<Integer>();
			try {
				weightList = view.getWeight();
			} catch (InvalidInputException e2) {
				
				e2.printStackTrace();
			}
			
			model.addMark(markList);
			model.addWeight(weightList);
			result = model.getResult(markList, weightList);
			
			/*for(int i = 0; i < markList.size(); i++){
				System.out.println(markList.size() + "This is size");
			}
			for(int i = 0; i < weightList.size(); i++){
				System.out.println(weightList.size() + "This is size");
			}*/
			CalView.infoBox("You need to get " + result + " to pass the exam.", "Final Exam Score");
			System.out.println(result + "result");
			
		}
	}

}
