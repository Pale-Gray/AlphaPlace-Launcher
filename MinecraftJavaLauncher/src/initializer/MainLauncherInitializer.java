package initializer;

import java.awt.Color;
import java.awt.Desktop;
// import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
// import java.io.InputStream;
import java.util.Scanner;

// import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainLauncherInitializer extends JPanel implements ActionListener{
	
	public ErrorMessageInitializer err = new ErrorMessageInitializer();
	public String path = "";
	File lwjgl = new File("src/");
	public String stat;
	public String Username;
	int num = 0;
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	public JButton jb = new JButton("Start");
	public JButton help = new JButton("Need Help?");
	JLabel jl = new JLabel("Minecraft Launcher");
	JLabel credit = new JLabel("<html>Programmed by Pale_Gray<html>");
	JLabel user = new JLabel("Username");
	JLabel pass = new JLabel("Password");
    JLabel status = new JLabel();
	JTextField jta = new JTextField("");
	JTextField password = new JTextField("");
	JPanel bgpanel = new JPanel();
	public static int WIDTH = 300;
	public static int HEIGHT = 200;
	String name = System.getProperty("user.name");
	String version = ("lwjgl-2.6");
	JLabel backgroundtest = new JLabel();
	int x;
	
	File dir = new File("C:/Program Files/Java/jre1.8.0_261");
	// String cmd = "java -Xms1024m -Xmx1024m -cp C:/Users/" + name + "/AppData/Roaming/.minecraft/versions/b1.1_02/b1.1_02.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/jar/lwjgl.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/jar/lwjgl_util.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/jar/jinput.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/net/java/jutils/jutils/1.0.0/jutils-1.0.0.jar -Djava.library.path=C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/native/windows net.minecraft.client.Minecraft Pale_Gray 9807";

	public Timer scroll = new Timer(25, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			x++;
			if (x > 300) {
				x = -200;
			}
			credit.setBounds(x, 5, 200, 20);
		}
		
	});
	public Timer t = new Timer(1, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Username = new String(jta.getText());
			int r = (int) (Math.random() * 255);
			int g = (int) (Math.random() * 255);
			int b = (int) (Math.random() * 255);
			Color rgb = new Color(r, g, b);	
			credit.setForeground(rgb);
			credit.repaint();
			if(jta.getText().length() < 3) {
				stat = "Username is less than 3 characters!";
				status.setBounds(WIDTH/2 - 130, 35, 500, 20);
				status.setForeground(Color.RED);
			}
			if(jta.getText().length() > 16) {
				stat = "Username is longer than 16 characters!";
				status.setBounds(WIDTH/2 - 135, 35, 500, 20);
				status.setForeground(Color.RED);
			}
			if(jta.getText().length() == 0) {
				status.setBounds(WIDTH/2 - 95, 35, 500, 20);
				stat = "ERR no username provided";
				status.setForeground(Color.RED);
			}
			if(jta.getText().length() >= 3 && jta.getText().length() <= 16) {
				stat = "Username is qualified";
				status.setBounds(WIDTH/2 - 80, 35, 200, 20);
				status.setForeground(new Color(20,168,0));
			}
			status.setText("Status: "+stat);
			// System.out.println(Username);
		}
	});
	
	//String cmd = "java -Xms1024m -Xmx1024m -cp C:/Users/" + name + "/AppData/Roaming/.minecraft/versions/b1.1_02/b1.1_02.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/jar/lwjgl.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/jar/lwjgl_util.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/jar/jinput.jar;C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/net/java/jutils/jutils/1.0.0/jutils-1.0.0.jar -Djava.library.path=C:/Users/" + name + "/AppData/Roaming/.minecraft/libraries/org/lwjgl/lwjgl/lwjgl/lwjgl-2.6/native/windows net.minecraft.client.Minecraft "+Username.toString();
	String cmd = "javaw -Xms1024m -Xmx1024m -cp C:\\Users\\" + name + "\\AppData\\Roaming\\.minecraft\\versions\\b1.1_02\\b1.1_02.jar;C:\\Users\\" + name + "\\AppData\\Roaming\\.minecraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\lwjgl-2.6\\jar\\lwjgl.jar;C:\\Users\\" + name + "\\AppData\\Roaming\\.minecraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\lwjgl-2.6\\jar\\lwjgl_util.jar;C:\\Users\\" + name + "\\AppData\\Roaming\\.minecraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\lwjgl-2.6\\jar\\jinput.jar;C:\\Users\\" + name + "\\AppData\\Roaming\\.minecraft\\libraries\\net\\java\\jutils\\jutils\\1.0.0\\jutils-1.0.0.jar -Djava.library.path=C:\\Users\\" + name + "\\AppData\\Roaming\\.minecraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\lwjgl-2.6\\native\\windows net.minecraft.client.Minecraft ";
	
	public void initializeJFrame(){
		
		Desktop dsk = Desktop.getDesktop();
		
		
		// ImageIcon bg = new ImageIcon("res/background.png");
		
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jta.getText().length() < 3 || jta.getText().length() > 16) {
					System.exit(-1);
				} else {
					try {
						Runtime.getRuntime().exec(cmd + Username, null, dir);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
			}

		});
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop dsk = Desktop.getDesktop();
				try {
					dsk.browse(new URI("https://jtpxm4bxx2tyzir6e6bctq-on.drv.tw/help/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		jf.setSize(WIDTH,HEIGHT);
		jf.setTitle("Cracked Launcher");
		// jf.getContentPane().setBackground(new Color(0,0,255));
		jf.setLayout(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		t.start();
		scroll.start();
		
			// new InputStream(this.getClass().getClassLoader().getResourceAsStream("src/background.png"));
		
		status.setBounds(WIDTH/2 - 55, 35, 200, 20);
		jb.setBounds(WIDTH/2 - 50, 100, 100, 20);
		help.setBounds(WIDTH/2 - 55, 120, 110, 20);
		jl.setBounds(WIDTH/2 - 55, 20, 200, 20);
		jta.setBounds(WIDTH/2 - 75, 100, 150, 20);
		user.setBounds(WIDTH/2 - 135, 80, 150, 20);
		jta.setBounds(WIDTH/2 - 75, 80, 150, 20);
		password.setBounds(WIDTH/2 - 75, 100, 150, 20);
		pass.setBounds(WIDTH/2 - 135, 100, 150, 20);

		jf.add(jb);
		jf.add(help);
		jf.add(jl);
		jf.add(jta);
		jf.add(user);
		jf.add(status);
		jf.add(credit);
		jf.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
