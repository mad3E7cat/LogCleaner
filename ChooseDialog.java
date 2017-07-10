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
	private JCheckBox nginxBox;
	private JCheckBox apacheBox;
	private boolean nginxChosen;
	private boolean apacheChosen;
	private String servers;
	private JLabel serverInfoLabel;
	public ChooseDialog(JFrame owner){
		super(owner, "Scan for logs", true);
		servers = "";
		//init checkboxes
		nginxBox = new JCheckBox("Debian");
		nginxBox.setMnemonic(KeyEvent.VK_N);
		nginxBox.setSelected(false);
		apacheBox = new JCheckBox("Windows XP");
		nginxBox.setMnemonic(KeyEvent.VK_A);
		apacheBox.setSelected(false);
		//
		//add panel and add checkboxes to it
		JPanel checkPanel = new JPanel(new GridLayout(0,1));
		checkPanel.add(nginxBox);
		checkPanel.add(apacheBox);
		// add panel to Dialog
		add(checkPanel, BorderLayout.LINE_START);
		serverInfoLabel = new JLabel(""); 
		checkPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); // 20, 20, 20, 20
		add(new JLabel("Choose operating system:"), BorderLayout.NORTH); // add text
		nginxBox.addItemListener(new ItemListener(){ // handle action, when "nginx" checkbox is chosen
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == nginxBox) && (e.getStateChange() == 1)){
					servers += "n";
					nginxChosen = true;
				}
			}	
		});
		apacheBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == apacheBox) && (e.getStateChange() == 1)){
					servers += "a";
					apacheChosen = true;
				}
			}
		});
		//add button OK to checkPanel
		formServers();
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				serverInfoLabel = new JLabel("");
				serverInfoLabel = new JLabel("Systems chosen: " + serversOutput());
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
		setSize(500, 400);
	}
	public void formServers(){
		if(nginxChosen) servers += "n";
		if(apacheChosen) servers += "a";
	}
	public String serversOutput(){
		String result = "";
		if(servers.indexOf('n') != -1) result += "n";
		if(servers.indexOf('a') != -1) result += "a";
		return result;
	}
}