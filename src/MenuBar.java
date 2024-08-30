import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar
{
	public static MenuBar menuBar=null; // shared by all objects
	private JMenu file, edit;
	private JMenuItem group, ungroup, changeObjectName;
	
	// can be called directly or via object
	public static MenuBar getMenuBar()
	{
		if (menuBar==null)
			menuBar=new MenuBar();
		
		return menuBar;
	}
	
	// constructor
	public MenuBar()
	{
		// 'File' button
		file=new JMenu("File");
		this.add(file);
		
		// 'Edit' button
		edit=new JMenu("Edit");
		this.add(edit);
		
		// Edit -> Group objects
		group=new JMenuItem("Group objects");
		group.addActionListener(new groupListener());
		group.setEnabled(false);
		edit.add(group);
		
		// Edit -> UnGroup objects
		ungroup=new JMenuItem("UnGroup objects");
		ungroup.addActionListener(new ungroupListener());
		ungroup.setEnabled(false);
		edit.add(ungroup);
		
		// Edit -> Change object name
		changeObjectName=new JMenuItem("Change object name");
		changeObjectName.addActionListener(new changeObjectNameListener());
		changeObjectName.setEnabled(false);
		edit.add(changeObjectName);
	}
	
	public void setGroup(boolean enable)
	{
		group.setEnabled(enable);
	}
	
	public void setUngroup(boolean enable)
	{
		ungroup.setEnabled(enable);
	}
	
	public void setObjectName(boolean enable)
	{
		changeObjectName.setEnabled(enable);
	}
}
