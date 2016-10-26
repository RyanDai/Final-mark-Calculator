package calculator;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class CalView extends JFrame {

	private CalModel model;
	private JButton get;
	//private JTextField mark;
	//private JTextField weight;
	private JTextField header;
	private JLabel[] marks;
	private JLabel[] weights;
	private JTextField[] left;
	private JTextField[] right;
	private Font font = new Font("SanSerif", Font.BOLD, 28);

	public CalView(CalModel model) {
		this.model = model;
		setTitle("Final Mark Calculator");
		setBounds(100, 100, 970, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		addHeaders(c);
		addButtonBox(c);
		addLeftContent(c);
		addRightContent(c);
	}

	public void addHeaders(Container c) {
		JPanel headerBox = new JPanel();
		headerBox.setLayout(new GridLayout(1, 2));
		headerBox.setSize(400, 50);
		addHeaderMarks(headerBox);
		addHeaderWeights(headerBox);
		c.add(headerBox, "North");

	}

	private void addHeaderMarks(JPanel headerBox) {
		header = new JTextField("Marks");
		header.setFont(font);
		header.setEditable(false);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBackground(Color.LIGHT_GRAY);
		headerBox.add(header);
	}

	private void addHeaderWeights(JPanel headerBox) {
		header = new JTextField("Weights");
		header.setFont(font);
		header.setEditable(false);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBackground(Color.LIGHT_GRAY);
		headerBox.add(header);
	}

	private void addButtonBox(Container c) {
		JPanel buttonBox = new JPanel();
		buttonBox.setPreferredSize(new Dimension(150, 80));
		addButton(buttonBox);
		c.add(buttonBox, "South");
	}

	private void addButton(JPanel buttonBox) {
		get = new JButton("Get");
		get.setFont(font);
		get.setBackground(Color.WHITE);
		get.setForeground(Color.RED);
		buttonBox.add(get, "South");
	}

	private void addLeftContent(Container c) {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(8,2));
		addLabelText(p);
		c.add(p,"West");
	}

	private void addLabelText(JPanel p) {
		marks = new JLabel[8];
		marks[0] = new JLabel("The first assignment mark(out of 100):");
		marks[1] = new JLabel("The second assignment mark(out of 100):");
		marks[2] = new JLabel("The third assignment mark(out of 100):");
		marks[3] = new JLabel("The fourth assignment mark(out of 100):");
		marks[4] = new JLabel("The fifth assignment mark(out of 100):");
		marks[5] = new JLabel("The sixth assignment mark(out of 100):");
		marks[6] = new JLabel("The seventh assignment mark(out of 100):");
		marks[7] = new JLabel("The eighth assignment mark(out of 100):");
		
		left = new JTextField[8];
		for(int i = 0 ; i < 8 ; i ++){
			left[i] = new JTextField("",2);
			left[i].setEditable(true);
		}
			
		for(int j = 0 ; j < 8 ; j ++){
			p.add(marks[j]);
			p.add(left[j]);
		}	
	}

	
	private void addRightContent(Container c) {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(8, 2));
		addLabelTextr(p);
		c.add(p,"East");
	}

	private void addLabelTextr(JPanel p) {
		weights = new JLabel[8];
		weights[0] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[1] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[2] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[3] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[4] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[5] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[6] = new JLabel("Weights (e.g.input 30% as 30): ");
		weights[7] = new JLabel("Weights (e.g.input 30% as 30): ");
		
		right = new JTextField[8];
		for(int i = 0 ; i <8 ; i ++){
			right[i] = new JTextField("",2);
			right[i].setEditable(true);
		}
		
		for(int j = 0 ; j < 8 ; j ++){
			p.add(weights[j]);
			p.add(right[j]);
		}	
	}
	
	
	
	
	public ArrayList<Integer> getMark() throws InvalidInputException {
		ArrayList<Integer> markList = new ArrayList<Integer>();
		String markString = "";
		for(int i = 0; i < left.length; i++){
			/*if(Integer.parseInt(left[i].getText()) < 0 || Integer.parseInt(left[i].getText()) >100){
				throw new InvalidInputException("Score must between 0 and 100");
			}*/
			markString += left[i].getText();
			markString += " ";
		}
		//System.out.println(markString + "  This is markString");
		Scanner scanner = new Scanner(markString);
		while(scanner.hasNextInt()){
			markList.add(scanner.nextInt());
		}
		scanner.close();
		return markList;
	}
	
	
	public ArrayList<Integer> getWeight() throws InvalidInputException {
		ArrayList<Integer> weightList = new ArrayList<Integer>();
		String weightString = "";
		for(int i = 0; i < right.length; i++){
			/*if(Integer.parseInt(left[i].getText()) < 0 || Integer.parseInt(left[i].getText()) >100){
				throw new InvalidInputException("Score must between 0");
			}*/
			weightString += right[i].getText();
			weightString += " ";
		}
		//System.out.println(weightString + "  This is weightString");
		Scanner scanner = new Scanner(weightString);
		while(scanner.hasNextInt()){
			weightList.add(scanner.nextInt());
		}
		scanner.close();
		return weightList;
	}
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	public void addGetListener(ActionListener al){
		get.addActionListener(al);
	}

	

	
}
