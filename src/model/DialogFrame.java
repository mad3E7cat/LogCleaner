package model;
import javax.swing.JFrame;
import view.ExitDialog;
import view.AboutDialog;
import view.DrawDialogFrame;
/*
Menu-frame with items "Scan", "About", "Exit".
*/
public class DialogFrame extends JFrame{
	private boolean debianChosen;
	private boolean windowsChosen;
	private AboutDialog aboutDialog;
	private ChooseDialog chooseDialog;
	private ScanCleanDialog scanCleanDialog;
	private ExitDialog exitDialog;
	//
	public DialogFrame()
	{
		aboutDialog = null;
		exitDialog = null;
		chooseDialog = null;
		scanCleanDialog = null;
		DrawDialogFrame draw = new DrawDialogFrame(this);
		// setTitle("Log Cleaner 0.1");
		// setSize(600, 400);
		// // Create menu
		// JMenuBar menuBar = new JMenuBar();
		// setJMenuBar(menuBar);
		// JMenu scanMenu = new JMenu("Scan");
		// scanMenu.setPreferredSize(new Dimension(200, 25));
		// JMenuItem chooseOsItem = new JMenuItem("Choose OS...");
		// JMenuItem scanAndCleanItem = new JMenuItem("Scan and Clean...");
		// scanMenu.add(chooseOsItem);
		// scanMenu.add(scanAndCleanItem);
		// menuBar.add(scanMenu);
		// JMenuItem aboutItem = new JMenuItem("About");
		// menuBar.add(aboutItem);
		// JMenuItem exitItem = new JMenuItem("Exit");
		// menuBar.add(exitItem);
		// //item Scan is called, the core part	
		// chooseOsItem.addActionListener(new ActionListener(){
		// 	public void actionPerformed(ActionEvent event){
		// 		if(chooseDialog == null) chooseDialog = new ChooseDialog(DialogFrame.this); // 1st time called
		// 		chooseDialog.setVisible(true);
		// 	}
		// });	
		// scanAndCleanItem.addActionListener(new ActionListener(){
		// 	public void actionPerformed(ActionEvent event){
		// 		scanCleanDialog = null;
		// 		if(scanCleanDialog == null) scanCleanDialog = new ScanCleanDialog(DialogFrame.this);
		// 		scanCleanDialog.setVisible(true);
		// 	}
		// });
		// // when "about" is chosen, dialog "about" is called
		// aboutItem.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		aboutDialog = null;
		// 		if(aboutDialog == null) aboutDialog = new AboutDialog(); // first time called
		// 	}
		// });
		// // when "exit" is chosen, programm is closed
		// exitItem.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		exitDialog = null;
		// 		if(exitDialog == null) exitDialog = new ExitDialog();
		// 	}
		// });
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
	public ChooseDialog getChooseDialog(){
		return chooseDialog;
	}
	public void setChooseDialog(ChooseDialog chsDlg){
		chooseDialog = chsDlg;
	}
	public void setChooseDialogVisible(boolean flag){
		chooseDialog.setVisible(flag);
	}
	public ScanCleanDialog getScanCleanDialog(){
		return scanCleanDialog;
	}
	public void setScanCleanDialog(ScanCleanDialog value){
		scanCleanDialog = value;
	}
	public void setScanCleanDialogVisible(boolean flag){
		scanCleanDialog.setVisible(flag);
	}
	public AboutDialog getAboutDialog(){
		return aboutDialog;
	}
	public void setAboutDialog(AboutDialog value){
		aboutDialog = value;
	}
	public ExitDialog getExitDialog(){
		return exitDialog;
	}
	public void setExitDialog(ExitDialog value){
		exitDialog = value;
	}
}
