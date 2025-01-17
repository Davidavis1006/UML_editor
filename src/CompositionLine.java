import java.awt.*;

public class CompositionLine extends Line
{
	// constructor
	public CompositionLine(Port startPort, Port endPort)
	{
		super(startPort, endPort);
		this.width=14;
		this.height=14;
	}
	
	@Override
	public void draw(Graphics2D graphics2D)
	{
		super.draw(graphics2D);
		
		// adjust the endPoint because it is shorter than Association Line
		endPoint=new Point(((x3+x4)/2), (y3+y4)/2);
		graphics2D.drawLine(endPoint.x, endPoint.y-height/2, endPoint.x-width/2, endPoint.y);
		graphics2D.drawLine(endPoint.x, endPoint.y-height/2, endPoint.x+width/2, endPoint.y);
		graphics2D.drawLine(endPoint.x-width/2, endPoint.y, endPoint.x, endPoint.y+height/2);
		graphics2D.drawLine(endPoint.x+width/2, endPoint.y, endPoint.x, endPoint.y+height/2);
	}
}
