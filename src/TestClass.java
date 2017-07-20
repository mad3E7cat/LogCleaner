import java.awt.EventQueue;
import javax.swing.JFrame;
import model.DialogFrame;
// 
public class TestClass {
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable(){
				public void run() {
					DialogFrame frame = new DialogFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}