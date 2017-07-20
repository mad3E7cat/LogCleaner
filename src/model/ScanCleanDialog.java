package model;
import io.FileEraser;
import io.FileChecker;
import model.DialogFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.Dimension;
import java.io.File;
import javax.swing.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
//
public class ScanCleanDialog extends JDialog{
	private String[] debianLogs = {"/var/log/alternatives.log", "/var/log/auth.log", "/var/log/bootstrap.log", "/var/log/daemon.log", "/var/log/dpkg.log",
							 "/var/log/kernlog.log", "/var/log/macchanger.log", "/var/log/user.log", "/var/log/wvdialconf.log", "/var/log/Xorg.0.log",
							 "/var/log/messages", "/var/log/btmp", "/var/log/debug", "/var/log/dmesg", "/var/log/faillog",
							 "/var/log/lastlog", "/var/log/syslog", "/var/log/wtmp", "/var/log/apache2/access.log", "/var/log/apache2/error.log",
							 "/var/log/apache2/other_vhosts_access.log", "/var/log/apt/history.log", "/var/log/apt/term.log", "/var/log/stunnel4/stunnel.log"};
	private String[] windowsLogs = {"C:\\WINDOWS\\system32\\config\\Internet.evt", "C:\\WINDOWS\\system32\\config\\SecEvent.evt", "C:\\WINDOWS\\system32\\config\\SysEvent.evt",
									"C:\\WINDOWS\\system32\\config\\system.sav", "C:\\WINDOWS\\system32\\config\\AppEvent.evt", "C:\\WINDOWS\\system32\\config\\default.sav",
									"C:\\WINDOWS\\system32\\config\\software.sav"};
	private int checkedFilesCounter;
	private int lines;
	public String[] checkedFiles;
	private boolean isDeb;
	private boolean isWin;
	private boolean error;
	private ScanCleanDialog thisObj;
	private DefaultListModel<String> listModelError;
	public ScanCleanDialog(DialogFrame owner){ // JFrame

		super(owner, "Scan and Clean", true);
		setSize(500, 300);
		error = false;
		FileChecker check = new FileChecker(debianLogs);
		if(check.isOk()) JOptionPane.showMessageDialog(null, "It seems like all files exist and can be wiped...", "Files are OK...",  
	                JOptionPane.INFORMATION_MESSAGE);
		if(!check.isOk()) JOptionPane.showMessageDialog(null, "It seems like not all files are available for wiping...", "Alert!",  
	                JOptionPane.INFORMATION_MESSAGE);
		isDeb = owner.isDebian();
		isWin = owner.isWindows();
		checkedFilesCounter = 0;
		JPanel mainPanel = new JPanel(); // main panel for list and buttons
		mainPanel.setLayout(new BorderLayout(5,5));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		DefaultListModel<String> listModel = new DefaultListModel<>();
		File checkFile = null;
		setTitle("Scanned files");
		if(owner.isDebian()){
			checkedFiles = new String[debianLogs.length];
			for (int i = 0; i < debianLogs.length; i++) { 
				checkFile = new File(debianLogs[i]);
				if(checkFile.canWrite() && checkFile.exists()){
					checkedFiles[i] = debianLogs[i];
					listModel.addElement(checkedFiles[i]);
					checkedFilesCounter++;
				}else{
					checkedFiles[i] = null;
				}
			}
		}
		if(owner.isWindows()){
			checkedFiles = new String[windowsLogs.length];
			for (int i = 0; i < windowsLogs.length; i++) { 
				checkFile = new File(windowsLogs[i]);
				if(checkFile.canWrite() && checkFile.exists()){
					checkedFiles[i] = windowsLogs[i];
					listModel.addElement(checkedFiles[i]);
					checkedFilesCounter++;
				}else{
					checkedFiles[i] = null;
				}
			}
		}
        JList<String> list = new JList<>(listModel);
        list.setFocusable(false);  
        list.setVisibleRowCount(15);
        mainPanel.add(new JScrollPane(list));
        //
        JPanel buttonsPanel = new JPanel(); // panel with buttons
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        //
        JButton cleanButton = new JButton("Clean");
        cleanButton.setFocusable(false);
        listModelError = new DefaultListModel<>();
        thisObj = this;
        cleanButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        	 	FileEraser erase = new FileEraser(thisObj, listModelError);
        		JList<String> listError = new JList<>(listModelError);
        		listError.setBackground(Color.RED);
	        	JScrollPane scrollPane = new JScrollPane(listError);  
				scrollPane.setPreferredSize( new Dimension( 400, 200 ) );
				if(error){
					JOptionPane.showMessageDialog(null, scrollPane, "Permission denied",  
	                JOptionPane.INFORMATION_MESSAGE);
	            }
	        }		
        	//errorList.setFocusable(false);  
        	//errorList.setVisibleRowCount(15);
        });
        //
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
        buttonsPanel.add(new JLabel("Files checked: " + checkedFilesCounter));
        add(mainPanel);
	}
	public String getDebianFile(int idx){
		return debianLogs[idx];
	}
	public String getWindowsFile(int idx){
		return windowsLogs[idx];
	}
	public String[] getWindowsFiles(){
		return windowsLogs;
	}
	public String[] getDebianFiles(){
		return debianLogs;
	}
	public boolean ownerIsDebian(){
		return isDeb;
	}
	public boolean ownerIsWindows(){
		return isWin;
	}
	public void setListModelError(DefaultListModel<String> lME){
		listModelError = (DefaultListModel<String>)lME;
	}
	public void setError(boolean flg){
		error = flg;
	}
}