import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
final String[] debianLogs = {"", "", ""}; // !!!!!!!!
final String[] windowsLogs = {"", "", ""}; // !!!!!!!
class ScanCleanDialog extends JDialog{
	//
	public ScanCleanDialog(DialogFrame owner){ // JFrame
		super(owner, "Scan and Clean", true);
		setSize(300, 200);
		// "/Desktop/LogCleaner/LogCleaner/test/1"
		JProgressBar progressBar = new JProgressBar();
		JLabel progressLabel = new JLabel("Scanning for logs...", javax.swing.SwingConstants.CENTER);
		progressBar.setSize(300, 25);
		progressBar.setIndeterminate(true);
		progressLabel.add(progressBar);
		add(progressLabel, BorderLayout.CENTER);
		//
		File dir = new File("/root/Desktop/LogCleaner/LogCleaner/test/2");
		progressLabel = new JLabel(" " + dir.isDirectory());
		add(progressLabel);
		// at the end
		remove(progressLabel);
	}
}