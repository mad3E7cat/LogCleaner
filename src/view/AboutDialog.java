package view;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/*
 Modal dialog window
*/
public class AboutDialog extends JDialog{
	public AboutDialog(){
		JOptionPane.showMessageDialog(this, "LogCleaner by mad3e7cat");
	}
}