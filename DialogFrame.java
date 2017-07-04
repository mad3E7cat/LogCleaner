import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//
/*
Menu-frame with items "Scan", "About", "Exit".
*/
class DialogFrame extends JFrame{
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 400;
	private AboutDialog aboutDialog;
	private ScanDialog scanDialog;
	private ExitDialog exitDialog;
	//
	public DialogFrame()
	{
		setTitle("Log Cleaner 0.1");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
 		boolean actionFinished = false;
		// Создание меню
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenuItem scanItem = new JMenuItem("Scan");
		menuBar.add(scanItem);
		JMenuItem aboutItem = new JMenuItem("About");
		menuBar.add(aboutItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		menuBar.add(exitItem);
		//item Scan is called, the core part	
		scanItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(scanDialog == null) scanDialog = new ScanDialog(DialogFrame.this); // first time called
				scanDialog.setVisible(true); // make dialog visible
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
				//System.exit(0);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				if(exitDialog == null) exitDialog = new ExitDialog(DialogFrame.this);
				exitDialog.setVisible(true);
			}
		});
	}
	// public String showServers(){
	// 	return scanDialog.returnServers();
	// }
}
//
