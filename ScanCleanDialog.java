import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
class ScanCleanDialog extends JDialog{
	//
	public ScanCleanDialog(DialogFrame owner){ // JFrame
		super(owner, "Scan and Clean", true);
		setSize(300, 200);
		//		
		JProgressBar progressBar = new JProgressBar();
		JLabel progressLabel = new JLabel("Scanning for logs...", javax.swing.SwingConstants.CENTER);
		progressBar.setSize(300, 25);
		progressBar.setIndeterminate(true);
		progressLabel.add(progressBar);
		add(progressLabel, BorderLayout.CENTER);
		//
		if(owner.isWindows()){
			
			//
			setSize(600, 400);
		}
		if(owner.isDebian()){
			
			//
			setSize(600, 400);
		}
	}
}