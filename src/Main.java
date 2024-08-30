import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame
{
	public MenuBar menuBar;
	public ToolBar toolBar;
	public Canvas canvas;
	
	// constructor
	public Main()
	{
		menuBar=MenuBar.getMenuBar();
		toolBar=new ToolBar();
		canvas=Canvas.getInstance();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(menuBar, BorderLayout.NORTH);
		getContentPane().add(toolBar, BorderLayout.WEST);
		getContentPane().add(canvas, BorderLayout.CENTER);
	}
	
	public static void main(String[] args)
	{
		Main main=new Main();
		
		main.setTitle("UML Editor");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application using the System exit method. Use this only in applications.
		main.setSize(1280, 720);
		//main.setSize(640, 480);
		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}
}
