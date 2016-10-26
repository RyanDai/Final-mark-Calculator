package calculator;

import java.util.*;

public class CalModel {
	
	private ArrayList<Integer> marks;
	private ArrayList<Integer> weights;
	
	
	public CalModel(){
		marks = new ArrayList<Integer>();
		weights = new ArrayList<Integer>();
	}
	
	public void addMark(ArrayList<Integer> markList){
		for(int i = 0; i < markList.size(); i++){
			marks.add(markList.get(i));
		}
	}
	
	public void addWeight(ArrayList<Integer> weightList){
		for(int i = 0; i < weightList.size(); i++){
			weights.add(weightList.get(i));
		}
	}
	
	public int getFinalWeight(){
		int finalWeight2 = 100;
		for(int i = 0; i < weights.size(); i++){
			finalWeight2 -= weights.get(i);
		}
		return finalWeight2;
	}
	
	
	
	public int getResult(ArrayList<Integer> markList, ArrayList<Integer> weightList){
		int result  = -1;
		int current = 0;
		int finalWeight = getFinalWeight();
		for(int i = 0; i < markList.size(); i++){
			current += (markList.get(i) * weightList.get(i) / 100);
		}
		if(current >= 50){
			marks.clear();
			weights.clear();
			return 0;
		} else {
			result = 100 * (50 - current) / finalWeight;
			marks.clear();
			weights.clear();
			return result;
		}
		
	}

	

}
