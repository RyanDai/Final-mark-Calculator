package calculator;


public class Calculator {

	public static void main(String[] args) throws Exception{
		CalModel model = new CalModel();
		CalView view = new CalView(model);
		new CalController(model,view);
		view.setVisible(true);

	}

}
