package io;
import model.*;
import javax.swing.DefaultListModel;
import java.io.FileWriter;
import java.io.IOException;
public class FileEraser{
    private String[] files;
    // private DefaultListModel<String> lME;
    public FileEraser(ScanCleanDialog scanCleanDlg, DefaultListModel<String> lME){
        // files = scanCleanDlg.getCheckedFiles();
        if(scanCleanDlg.ownerIsDebian()) files = scanCleanDlg.getDebianFiles();
        if(scanCleanDlg.ownerIsWindows()) files = scanCleanDlg.getWindowsFiles();    
        for (int i = 0; i < files.length; i++) {
                    try{
                        FileWriter eraser = new FileWriter(files[i]);
                        if(eraser != null && files[i] != null) {
                            eraser.write(0);
                            eraser.close();
                        }
                    }catch(NullPointerException ex){
                        scanCleanDlg.setError(true);
                        if(scanCleanDlg.ownerIsDebian())
                        {
                            lME.addElement(scanCleanDlg.getDebianFile(i));
                        }
                        if(scanCleanDlg.ownerIsWindows()){
                            lME.addElement(scanCleanDlg.getDebianFile(i));
                        }       
                    }catch(IOException ioexc){
                        System.out.println(ioexc);
                    } 
                }
        scanCleanDlg.setListModelError(lME);
    }
}

