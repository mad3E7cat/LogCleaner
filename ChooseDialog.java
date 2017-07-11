import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
//
/*
 Modal dialog window
*/
class ChooseDialog extends JDialog{
	private JCheckBox debianBox;
	private JCheckBox windowsBox;
	private boolean debianChosen;
	private boolean windowsChosen;
	private String systems;
	private JLabel serverInfoLabel;
	public ChooseDialog(JFrame owner){
		super(owner, "Scan for OS's", true);
		systems = "";
		//init checkboxes
		debianBox = new JCheckBox("Debian");
		debianBox.setMnemonic(KeyEvent.VK_N);
		debianBox.setSelected(false);
		windowsBox = new JCheckBox("Windows XP");
		debianBox.setMnemonic(KeyEvent.VK_A);
		windowsBox.setSelected(false);
		//
		//add panel and add checkboxes to it
		JPanel checkPanel = new JPanel(new GridLayout(0,1));
		checkPanel.add(debianBox);
		checkPanel.add(windowsBox);
		// add panel to Dialog
		add(checkPanel, BorderLayout.LINE_START);
		serverInfoLabel = new JLabel(""); 
		checkPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); // 20, 20, 20, 20
		add(new JLabel("Choose operating system:"), BorderLayout.NORTH); // add text
		debianBox.addItemListener(new ItemListener(){ // handle action, when "debian" checkbox is chosen
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == debianBox) && (e.getStateChange() == 1)){
					systems += "\nDebian\n";
					debianChosen = true;
				}
			}	
		});
		windowsBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == windowsBox) && (e.getStateChange() == 1)){
					systems += "\nWindows XP\n";
					windowsChosen = true;
				}
			}
		});
		//add button OK to checkPanel
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				serverInfoLabel = new JLabel("");
				serverInfoLabel = new JLabel("Systems chosen: " + systemsOutput());
				owner.add(serverInfoLabel, BorderLayout.NORTH);
				owner.setVisible(true);
			}
		});
		//maybe there's no need in "cancel" button
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		JPanel buttonContainer = new JPanel(); // create a container for ok and cancel buttons
		buttonContainer.add(okButton, BorderLayout.EAST);
		buttonContainer.add(cancelButton, BorderLayout.WEST);
		checkPanel.add(buttonContainer);
		setSize(600, 400);
	}
	public String systemsOutput(){
		String result = "";
		if(systems.contains("Debian")) result += "\nDebian\n";
		if(systems.contains("Windows XP")) result += "\nWindows XP\n";
		return result;
	}
}