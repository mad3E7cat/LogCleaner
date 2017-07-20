package view;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
/*
 Modal dialog window
*/
public class ExitDialog extends JDialog{
	public ExitDialog(){
		int result = JOptionPane.showConfirmDialog(this,
        "Are you sure?",
        "Exit", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) System.exit(0);
	}
}