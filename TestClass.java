import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
// 
public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			EventQueue.invokeLater(new Runnable(){
				public void run() {
					DialogFrame frame = new DialogFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
 
}
// public void itemStateChanged(ItemEvent e){
	// 	Object source = e.getItemSelectable();
	// 	if(source == nginxBox){
	// 		//System.out.println("nginx selected...");
	// 		servers="n";
	// 	}
	// 	if(source == apacheBox){
	// 		//System.out.println("Apache selected...");
	// 		servers="a";
	// 	}
	// }