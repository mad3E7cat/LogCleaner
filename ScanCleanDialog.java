import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
//
class ScanCleanDialog extends JDialog{
	private String[] debianLogs = {"/var/log/alternatives.log", "/var/log/auth.log", "/var/log/bootstrap.log", "/var/log/daemon.log", "/var/log/dpkg.log",
							 "/var/log/kernlog.log", "/var/log/macchanger.log", "/var/log/user.log", "/var/log/wvdialconf.log", "/var/log/Xorg.0.log",
							 "/var/log/messages", "/var/log/btmp", "/var/log/debug", "/var/log/dmesg", "/var/log/faillog",
							 "/var/log/lastlog", "/var/log/syslog", "/var/log/wtmp", "/var/log/apache2/access.log", "/var/log/apache2/error.log",
							 "/var/log/apache2/other_vhosts_access.log", "/var/log/apt/history.log", "/var/log/apt/term.log", "/var/log/chkrootkit", 
							 "/var/log/stunnel4/stunnel.log"};
	private String[] windowsLogs = {"C:\\WINDOWS\\system32\\config\\Internet.evt", "C:\\WINDOWS\\system32\\config\\SecEvent.evt", "C:\\WINDOWS\\system32\\config\\SysEvent.evt",
									"C:\\WINDOWS\\system32\\config\\system.sav", "C:\\WINDOWS\\system32\\config\\AppEvent.evt", "C:\\WINDOWS\\system32\\config\\default.sav",
									"C:\\WINDOWS\\system32\\config\\software.sav"};
	private int checkedFilesCounter;
	public String[] checkedFiles;
	//
	public ScanCleanDialog(DialogFrame owner){ // JFrame
		super(owner, "Scan and Clean", true);
		setSize(500, 300);
		checkedFilesCounter = 0;
		JPanel mainPanel = new JPanel(); // main panel for list and buttons
		mainPanel.setLayout(new BorderLayout(5,5));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		final DefaultListModel<String> listModel = new DefaultListModel<>();
		// String[] checkedFiles = null;
		File checkFile = null;
		setTitle("isDebian(): " + owner.isDebian() + " isWindows(): " + owner.isWindows());
		if(owner.isDebian()){
			checkedFiles = new String[debianLogs.length];
			for (int i = 0; i < debianLogs.length; i++) { // change progressbar here
				checkFile = new File(debianLogs[i]);
				if(checkFile.canWrite() && checkFile.exists()){
					checkedFiles[i] = debianLogs[i];
					listModel.addElement(checkedFiles[i]);
					checkedFilesCounter++;
				}
			}
		}
		if(owner.isWindows()){
			checkedFiles = new String[windowsLogs.length];
			//
		}
		final JList<String> list = new JList<>(listModel);
        list.setFocusable(false);
        list.setVisibleRowCount(15);
        mainPanel.add(new JScrollPane(list));
        //
        JPanel buttonsPanel = new JPanel(); // panel with buttons
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        //
        JButton cleanButton = new JButton("Clean");
        cleanButton.setFocusable(false);
        cleanButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		for (int i = 0; i < (owner.isDebian() ? debianLogs.length : windowsLogs.length); i++) {
        			if(owner.isDebian()){
        				File temp = new File(checkedFiles[i]);
        				try{
        					PrintWriter eraser = new PrintWriter(temp);
        					eraser.write("");
        					eraser.close();
        				}catch(FileNotFoundException exc){
        					System.out.println(exc);
        				}
        			}
        		}
        	}
        });
        buttonsPanel.add(cleanButton);
        //
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		setVisible(false);
        	}
        });
        buttonsPanel.add(cancelButton);
        add(mainPanel);
        //
        //JButton
		// "/Desktop/LogCleaner/LogCleaner/test/1"
		// JProgressBar progressBar = new JProgressBar();
		// JLabel progressLabel = new JLabel("Scanning for logs...", javax.swing.SwingConstants.CENTER);
		// progressBar.setSize(300, 25);
		// progressBar.setIndeterminate(true);
		// progressLabel.add(progressBar);
		// add(progressLabel, BorderLayout.CENTER);
		// remove(progressLabel);
		//
	}
}