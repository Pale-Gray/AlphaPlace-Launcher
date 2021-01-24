package initializer;

import javax.swing.*;

public class ErrorMessageInitializer {

	JFrame jf = new JFrame();
	JButton ok = new JButton("Ok");
	JLabel err = new JLabel("The username you provided is invalid");
	
	
	
	public void initializeError(){
		
		jf.setSize(200,100);
		jf.setVisible(true);
		jf.add(ok);
		jf.add(err);

		//status.setBounds(WIDTH/2 - 55, 35, 200, 20);
		// jb.setBounds(WIDTH/2 - 50, 100, 100, 20);
		// jl.setBounds(WIDTH/2 - 55, 20, 200, 20);
		// credit.setBounds(WIDTH/2 - 80, 5, 200, 20);
		// jta.setBounds(WIDTH/2 - 75, 100, 150, 20);
		// user.setBounds(WIDTH/2 - 135, 80, 150, 20);
		// jta.setBounds(WIDTH/2 - 75, 80, 150, 20);
		// password.setBounds(WIDTH/2 - 75, 100, 150, 20);
		// pass.setBounds(WIDTH/2 - 135, 100, 150, 20);
	}
}
