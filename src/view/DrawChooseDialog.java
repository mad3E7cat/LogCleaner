// package view;
// import model.ChooseDialog;
// import javax.swing.JPanel;
// import javax.swing.JButton;
// import javax.swing.JLabel;
// import javax.swing.JCheckBox;
// import javax.swing.JDialog;
// import javax.swing.JFrame;
// import java.awt.event.ActionListener;
// import java.awt.event.ItemListener;
// import java.awt.event.ActionEvent;
// import java.awt.BorderLayout;
// import java.awt.GridLayout;
// import java.awt.event.ItemEvent;
// import java.awt.event.KeyEvent;

// public class DrawChooseDialog{
// 	public DrawChooseDialog(ChooseDialog chooseDlg){
// 		chooseDlg = new ChooseDialog(chooseDlg);
// 		chooseDlg.setSystems("");
// 		//hooseDlg.writeSystem(2);
// 		JCheckBox debChck = new JCheckBox("Debian");
// 		JCheckBox winChck = new JCheckBox("Windows");
// 		JPanel checkPanel = new JPanel(new GridLayout(2,5));
// 		checkPanel.add(chooseDlg.getDebianCheckbox());
// 		checkPanel.add(chooseDlg.getWindowsCheckbox());
// 		chooseDlg.add(new JLabel("Choose operating system(only one):"), BorderLayout.NORTH);
// 		// ! try to make new object, set listener for it and then set the choose dialog's one with it
// 		debChck.addItemListener(new ItemListener(){ // handle action, when"debian" checkbox is chosen
// 			public void itemStateChanged(ItemEvent e){
// 				Object source = e.getItemSelectable();
// 				if((source == chooseDlg.getDebianCheckbox()) && (e.getStateChange() == 1)){
// 					chooseDlg.setSystems("Debian");
// 					//chooseDlg.setOwnerDebian(true);
// 					//chooseDlg.setOwnerWindows(false);
// 				}
// 			}	
// 		});
// 		chooseDlg.setDebianCheckbox(debChck);
// 		winChck.addItemListener(new ItemListener(){
// 			public void itemStateChanged(ItemEvent e){
// 				Object source = e.getItemSelectable();
// 				if((source == chooseDlg.getWindowsCheckbox()) && (e.getStateChange() == 1)){
// 					chooseDlg.setSystems("Windows XP");
// 					//chooseDlg.setOwnerWindows(true);
// 					//chooseDlg.setOwnerDebian(false);
// 				}
// 			}
// 		});
// 		chooseDlg.setWindowsCheckbox(winChck);
// 		JButton okButton = new JButton("OK");
// 		okButton.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent e){
// 				chooseDlg.setSelectedDebianCheckbox(false);
// 				chooseDlg.setSelectedWindowsCheckbox(false);
// 				chooseDlg.setVisible(false);
// 				chooseDlg.setSystems("");
// 				//chooseDlg.writeSystem(2);
// 			}
// 		});
// 		JButton cancelButton = new JButton("CANCEL");
// 		cancelButton.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent e){
// 				chooseDlg.setVisible(false);
// 			}
// 		});
// 		JPanel buttonContainer = new JPanel(); // create a container for ok and cancel buttons
// 		buttonContainer.add(okButton, BorderLayout.EAST);
// 		buttonContainer.add(cancelButton, BorderLayout.WEST);
// 		chooseDlg.add(checkPanel, BorderLayout.WEST);
// 		chooseDlg.add(buttonContainer, BorderLayout.SOUTH);
// 		chooseDlg.setVisible(true);
// 		chooseDlg.setSize(400, 400);
// 	}
// }