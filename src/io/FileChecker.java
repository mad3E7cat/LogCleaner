package io;
import model.*;
import java.io.File;
public class FileChecker{
	private File checkFile;
	private int filesChecked;
	private String[] filesToCheck;
	public FileChecker(String[] files){
		filesChecked = 0;
		filesToCheck = files;
		checkFile = null;
	}
	public void check(){
		int size = filesToCheck.length;
		for(int i = 0; i < size; i++){
			checkFile = new File(filesToCheck[i]);
			if(checkFile.exists() && checkFile.canWrite()) filesChecked++;
		}
	}
	public boolean isOk(){
		if(filesToCheck.length == filesChecked) return true;
		else return false;
	}
} 