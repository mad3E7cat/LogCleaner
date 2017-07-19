import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
/*
 Modal dialog window
*/
class ChooseDialog extends JDialog{
	private JCheckBox debianBox;
	private JCheckBox windowsBox;
	private String systems;
	private JLabel serverInfoLabel;
	public ChooseDialog(DialogFrame owner){ // JFrame
		super(owner, "Scan for OS's", true);
		systems = "";
		//init checkboxes
		debianBox = new JCheckBox("Debian");
		debianBox.setMnemonic(KeyEvent.VK_N);
		windowsBox = new JCheckBox("Windows XP");
		debianBox.setMnemonic(KeyEvent.VK_A);
		//add panel and add checkboxes to this panel
		JPanel checkPanel = new JPanel(new GridLayout(2,1));
		checkPanel.add(debianBox);
		checkPanel.add(windowsBox);
		// add panel to Dialog
		add(checkPanel, BorderLayout.CENTER);
		serverInfoLabel = new JLabel(""); 
		add(new JLabel("Choose operating system(only one):"), BorderLayout.NORTH); // add text
		debianBox.addItemListener(new ItemListener(){ // handle action, when "debian" checkbox is chosen
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == debianBox) && (e.getStateChange() == 1)){
					systems = "\nDebian\n";
					owner.setDebian(true);
					owner.setWindows(false);
				}
			}	
		});
		windowsBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == windowsBox) && (e.getStateChange() == 1)){
					systems = "\nWindows XP\n";
					owner.setWindows(true);
					owner.setDebian(false);
				}
			}
		});
		//add button OK to checkPanel
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				owner.remove(serverInfoLabel);
				debianBox.setSelected(false);
				windowsBox.setSelected(false);
				setVisible(false);
				serverInfoLabel = new JLabel("Systems chosen: " + systems + " isDebian(): " + owner.isDebian() + " isWindows(): " + owner.isWindows());
				owner.add(serverInfoLabel, BorderLayout.NORTH);
				owner.setVisible(true);
				systems = "";
			}
		});
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		JPanel buttonContainer = new JPanel(); // create a container for ok and cancel buttons
		buttonContainer.add(okButton, BorderLayout.EAST);
		buttonContainer.add(cancelButton, BorderLayout.WEST);
		add(buttonContainer, BorderLayout.SOUTH);
		setSize(400, 400);
	}
}