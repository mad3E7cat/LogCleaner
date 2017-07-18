import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
//
/*
 Modal dialog window
*/
class ExitDialog extends JDialog{
	ExitDialog(JFrame owner){
		super(owner, "Exit", true);
		add(new JLabel("Are you sure?"));
		JPanel buttons = new JPanel();
		JButton ok = new JButton("YES");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		JButton cancel = new JButton("NO");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		buttons.add(ok, BorderLayout.EAST);
		buttons.add(cancel, BorderLayout.WEST);
		add(buttons, BorderLayout.SOUTH);
		setSize(300, 160);
	}
}