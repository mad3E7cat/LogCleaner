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
	public ScanCleanDialog(JFrame owner){
		super(owner, "Scan and Clean", true);
		//
		JProgressBar progressBar = new JProgressBar();
		JLabel progressLabel = new JLabel("Scanning for logs...");
		progressBar.setSize(400, 25);
		progressBar.setIndeterminate(true);
		progressLabel.add(progressBar, BorderLayout.CENTER);
		add(progressLabel);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		
		//
		setSize(600, 400);	
	}
}