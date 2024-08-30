import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectMode extends BaseObjectMode
{
	public int hasShape;
	private MenuBar menuBar;
	
	// constructor
	public SelectMode()
	{
		this.menuBar=MenuBar.getMenuBar();
	}
	
	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{
		startPoint=mouseEvent.getPoint();
		hasShape=checkInShape(startPoint);
		removeOldPort();
	}
	
	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{
		setMenuBar();
		endPoint=mouseEvent.getPoint();
		
		// drag the area
		if (!endPoint.equals(startPoint)) // drag to different spot
		{
			int offsetX=endPoint.x-startPoint.x;
			int offsetY=endPoint.y-startPoint.y;
			
			if (hasShape!=-1)
			{
				Shape shape=canvas.getShapeList().get(hasShape);
				shape.adjust(offsetX, offsetY);
				System.out.println(mouseEvent.getPoint());
				shape.setDepth(99);
				shape.checkOverlap();
			}
			else if (hasShape==-1)
			{
				selectShape(offsetX, offsetY);
				
				for (Shape shape: canvas.getShapeSelected())
				{
					shape.setSelected(true);
				}
			}
			
			// select more than 1 shape
			if (canvas.getShapeSelected().size()>=2)
			{
				menuBar.setGroup(true);
			}
		}
		else // drag to same spot
		{
			if (hasShape!=-1)
			{
				Shape shape=canvas.getShapeList().get(hasShape);
				shape.setSelected(true);
				canvas.getShapeSelected().add(shape);
				shape.checkOverlap();
			}
		}
		
		// unGroup
		if (canvas.getShapeSelected().size()!=0 && canvas.getShapeSelected().get(0).getShapeList()!=null) // if the top one is a group object
		{
			menuBar.setUngroup(true);
		}
		
		// edit the object name
		if (canvas.getShapeSelected().size()==1)
		{
			menuBar.setObjectName(true);
		}
	}
	
	public void setMenuBar()
	{
		menuBar.setGroup(false);
		menuBar.setUngroup(false);
		menuBar.setObjectName(false);
	}
	
	// select Shapes that are in dragged area
	public void selectShape(int offsetX, int offsetY)
	{
		Rectangle bound; // bound of the dragged area
		
		if (offsetX<0)
		{
			if (offsetY<0) // right bottom -> left top
				bound=new Rectangle(endPoint.x, endPoint.y, -offsetX, -offsetY);
			else // right top -> left bottom
				bound=new Rectangle(endPoint.x, startPoint.y, -offsetX, offsetY);
		}
		else
		{
			if (offsetY<0) // left bottom -> right top
				bound=new Rectangle(startPoint.x, endPoint.y, offsetX, -offsetY);
			else // left top -> right bottom
				bound=new Rectangle(startPoint.x, startPoint.y, offsetX, offsetY);
		}
		
		for (Shape shape: canvas.getShapeList())
		{
			if (shape.isInRectangle(bound))
			{
				canvas.getShapeSelected().add(shape);
			}
		}
	}
}
