import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToolBar extends JToolBar
{
	public ArrayList<ToolButton> buttonArrayList=new ArrayList<>();
	public MenuBar menuBar;
	public Canvas canvas;
	
	// constructor
	public ToolBar()
	{
		canvas=Canvas.getInstance(); // get canvas object
		menuBar=MenuBar.getMenuBar(); // get menu bar object
		setLayout(new GridLayout(6, 1)); // create a grid layout with the specified number of rows and columns
		
		// select button
		ImageIcon select=new ImageIcon("icon/select.jpg");
		ToolButton selectButton=new ToolButton(select, new SelectMode());
		buttonArrayList.add(selectButton);
		add(selectButton);
		
		// association line button
		ImageIcon association=new ImageIcon("icon/association_line.jpg");
		ToolButton associationButton=new ToolButton(association, new AssociationLineMode());
		buttonArrayList.add(associationButton);
		add(associationButton);
		
		// generalization line button
		ImageIcon generalization=new ImageIcon("icon/generalization_line.jpg");
		ToolButton generalizationButton=new ToolButton(generalization, new GeneralizationLineMode());
		buttonArrayList.add(generalizationButton);
		add(generalizationButton);
		
		// composition line button
		ImageIcon composition=new ImageIcon("icon/composition_line.jpg");
		ToolButton compositionButton=new ToolButton(composition, new CompositionLineMode());
		buttonArrayList.add(compositionButton);
		add(compositionButton);
		
		// class button
		ImageIcon classImg=new ImageIcon("icon/class.jpg");
		ToolButton classButton=new ToolButton(classImg, new ClassMode());
		buttonArrayList.add(classButton);
		add(classButton);
		 
		// use case button
		ImageIcon usecase=new ImageIcon("icon/use_case.jpg");
		ToolButton usecaseButton=new ToolButton(usecase, new UseCaseMode());
		buttonArrayList.add(usecaseButton);
		add(usecaseButton);
	}
	
	// Reference: https://stackoverflow.com/questions/2536873/how-can-i-set-size-of-a-button
	public class ToolButton extends JButton
	{
		BaseObjectMode mode;
		
		// constructor
		public ToolButton(ImageIcon imageIcon, BaseObjectMode toolMode)
		{
			this.mode=toolMode;
			this.setIcon(imageIcon);
			this.setPreferredSize(new Dimension(100, 40));
			this.setOpaque(false);
			this.setBorderPainted(true);
			this.addActionListener(new ToolButtonListener());
		}
		
		public class ToolButtonListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
                resetColor();
                System.out.println(mode);
                ((JButton) actionEvent.getSource()).setOpaque(true);
                ((JButton) actionEvent.getSource()).setBackground(Color.LIGHT_GRAY);
                Canvas.getInstance().setCurrentMode(mode);
                setMenuUnable();
            }
			
			void setMenuUnable()
			{
				menuBar.setGroup(false);
				menuBar.setUngroup(false);
				menuBar.setObjectName(false);
			}
			
			void resetColor()
	 		{
				for (ToolButton button: buttonArrayList)
				{
					button.setBackground(new Color(0, 0, 0));
					button.setOpaque(false);
				}
			}

		}
	}
}
