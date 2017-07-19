import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import view.ExitDialog;
import view.AboutDialog;
/*
Menu-frame with items "Scan", "About", "Exit".
*/
class DialogFrame extends JFrame{
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
		setSize(600, 400);
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
				aboutDialog = null;
				if(aboutDialog == null) aboutDialog = new AboutDialog(); // first time called
			}
		});
		// when "exit" is chosen, programm is closed
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				exitDialog = null;
				if(exitDialog == null) exitDialog = new ExitDialog();
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
}
