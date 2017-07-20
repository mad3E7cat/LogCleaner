package view;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import model.*;
public class DrawDialogFrame{
	public DrawDialogFrame(DialogFrame dialogFrm){
		dialogFrm.setTitle("Log Cleaner 0.1");
		dialogFrm.setSize(600, 400);
		JMenuBar menuBar = new JMenuBar();
		dialogFrm.setJMenuBar(menuBar);
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
		chooseOsItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(dialogFrm.getChooseDialog() == null) dialogFrm.setChooseDialog(new ChooseDialog(dialogFrm)); // 1st time called
				dialogFrm.setChooseDialogVisible(true);
			}
		});
		scanAndCleanItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//dialogFrm.setScanCleanDialog(null);
				if(dialogFrm.getScanCleanDialog() == null) dialogFrm.setScanCleanDialog(new ScanCleanDialog(dialogFrm));
				dialogFrm.setScanCleanDialogVisible(true);
			}
		});
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//dialogFrm.setAboutDialog(null);
				if(dialogFrm.getAboutDialog() == null) dialogFrm.setAboutDialog(new AboutDialog()); // first time called
			}
		});
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dialogFrm.setExitDialog(null);
				if(dialogFrm.getExitDialog() == null) dialogFrm.setExitDialog(new ExitDialog());
			}
		});
	}
}