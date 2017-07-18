import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
//
/*
 Modal dialog window
*/
class AboutDialog extends JDialog{
	public AboutDialog(JFrame owner){
		super(owner, "About Log Cleaner 0.1", true); // true for modal - makes user to finish using it, makes all dialogs unaccessible until the work with ot is finished
		add(new JLabel("Log Cleaner 0.1 by mad3e7cat"), BorderLayout.CENTER);
 
		// if OK pressed, window is closed
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		// put "OK" button to the bottom
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.EAST);
		setSize(300, 160);
	}
}