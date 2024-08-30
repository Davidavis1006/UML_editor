import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class groupListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		Canvas.getInstance().groupObj();
	}
}
