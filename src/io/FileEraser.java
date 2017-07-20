package io;
import model.*;
import javax.swing.DefaultListModel;
import java.io.FileWriter;
import java.io.IOException;
public class FileEraser{
    private String[] files;
    ScanCleanDialog scnClnDlg;
    private DefaultListModel<String> lME;
    public FileEraser(ScanCleanDialog scanCleanDlg, DefaultListModel<String> lME){
        // files = scanCleanDlg.getCheckedFiles();
        scnClnDlg = scanCleanDlg;
        this.lME = lME;
        if(scanCleanDlg.ownerIsDebian()) files = scanCleanDlg.getDebianFiles();
        if(scanCleanDlg.ownerIsWindows()) files = scanCleanDlg.getWindowsFiles();
        eraseFiles();
    }
    public FileEraser(){};
    public void eraseFiles(){
            
        for (int i = 0; i < files.length; i++) {
                    try{
                        FileWriter eraser = new FileWriter(files[i]);
                        if(eraser != null && files[i] != null) {
                            eraser.write(0);
                            eraser.close();
                        }
                    }catch(NullPointerException ex){
                        scnClnDlg.setError(true);
                        if(scnClnDlg.ownerIsDebian())
                        {
                            lME.addElement(scnClnDlg.getDebianFile(i));
                        }
                        if(scnClnDlg.ownerIsWindows()){
                            lME.addElement(scnClnDlg.getDebianFile(i));
                        }       
                    }catch(IOException ioexc){
                        System.out.println(ioexc);
                    } 
                }
        scnClnDlg.setListModelError(lME);
    }
}

