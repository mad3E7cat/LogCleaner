package model;
//import view.DrawChooseDialog;
import model.DialogFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;
import java.io.FileNotFoundException;

/*
 Modal dialog window
*/
public class ChooseDialog extends JDialog{
	private JCheckBox debianBox;
	private JCheckBox windowsBox;
	private boolean isDebian;
	private boolean isWindows;
	private String systems;
	public ChooseDialog(DialogFrame owner){ // JFrame
		super(owner, "Scan for OS's", true);
		//DrawChooseDialog draw = new DrawChooseDialog(this);
		systems = "";
		//init checkboxes
		debianBox = new JCheckBox("Debian");
		debianBox.setMnemonic(KeyEvent.VK_N);
		windowsBox = new JCheckBox("Windows XP");
		debianBox.setMnemonic(KeyEvent.VK_A);
		//add panel and add checkboxes to this panel
		JPanel checkPanel = new JPanel(new GridLayout(2,5));
		checkPanel.add(debianBox);
		checkPanel.add(windowsBox);
		// 
		add(new JLabel("Choose operating system(only one):"), BorderLayout.NORTH); // add text
		debianBox.addItemListener(new ItemListener(){ // handle action, when"debian" checkbox is chosen
			public void itemStateChanged(ItemEvent e){
				Object source = e.getItemSelectable();
				if((source == debianBox) && (e.getStateChange() == 1)){
					systems = "\nDebian\n";
					owner.setDebian(true);
					owner.setWindows(false);
				}
			}	
		});
		//////////////////////////////////////////////////////////////////////////////////////////
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
				debianBox.setSelected(false);
				windowsBox.setSelected(false);
				setVisible(false);
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
		add(checkPanel, BorderLayout.WEST);
		add(buttonContainer, BorderLayout.SOUTH);
		setSize(400, 400);
	}
	public JCheckBox getWindowsCheckbox(){
		return windowsBox;
	}
	public void setWindowsCheckbox(JCheckBox chBox){
		windowsBox = chBox;
	}
	public JCheckBox getDebianCheckbox(){
		return debianBox;
	}
	public void setDebianCheckbox(JCheckBox chBox){
		windowsBox = chBox;
	}
	public ChooseDialog getChooseDialog(){
		return this;
	}
	public void setSystems(String sys){
		systems = sys;
	}
	//
	public boolean isWindows(){
		return isWindows;
	}
	public boolean isDebian(){
		return isDebian;
	}
	//
	public void setSelectedDebianCheckbox(boolean flag){
		debianBox.setSelected(flag);
	}
	public void setSelectedWindowsCheckbox(boolean flag){
		windowsBox.setSelected(flag);
	}

}
