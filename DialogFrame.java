import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
//
/*
Menu-frame with items "Scan", "About", "Exit".
*/
class DialogFrame extends JFrame{
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 400;
	private boolean debianChosen;
	private boolean windowsChosen;
	private String system;
	private AboutDialog aboutDialog;
	private ChooseDialog chooseDialog;
	private ScanCleanDialog scanCleanDialog;
	private ExitDialog exitDialog;
	//
	public DialogFrame()
	{
		setTitle("Log Cleaner 0.1");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
 	// 	debianChosen = false;
		// windowsChosen = false;
		system = "";
		// Create menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu scanMenu = new JMenu("Scan");
		scanMenu.setPreferredSize(new Dimension(200, 25));
		JMenuItem chooseOsItem = new JMenuItem("Choose OS...");
		JMenuItem scanAndCleanItem = new JMenuItem("Scan and Clean...");
		scanMenu.add(chooseOsItem);
		scanMenu.add(scanAndCleanItem);
		menuBar.add(scanMenu);
		JMenuItem aboutItem = new JMenuItem("About");
		menuBar.add(aboutItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		menuBar.add(exitItem);
		//item Scan is called, the core part	
		chooseOsItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//chooseDialog = null;
				if(chooseDialog == null) chooseDialog = new ChooseDialog(DialogFrame.this); // 1st time called
				chooseDialog.setVisible(true);
				
			}
		});	
		scanAndCleanItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				scanCleanDialog = null;
				if(scanCleanDialog == null) scanCleanDialog = new ScanCleanDialog(DialogFrame.this);
				scanCleanDialog.setVisible(true);
			}
		});
		// when "about" is chosen, dialog "about" is called
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(aboutDialog == null) aboutDialog = new AboutDialog(DialogFrame.this); // first time called
				aboutDialog.setVisible(true); // make dialog visible
			}
		});
		// when "exit" is chosen, programm is closed
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(exitDialog == null) exitDialog = new ExitDialog(DialogFrame.this);
				exitDialog.setVisible(true);
			}
		});
	}
	public void setWindows(boolean flag){
		windowsChosen = flag;
	}
	public void setDebian(boolean flag){
		debianChosen = flag;
	}
	public boolean isWindows(){
		return windowsChosen;
	}
	public boolean isDebian(){
		return debianChosen;
	}
	// public void setSystem(String sys){
	// 	system = sys;
	// }
	// public String getSystem(){
	// 	return system; 
	// }
}
//
