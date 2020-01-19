import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		JButton b = (JButton)evt.getSource();
		if(b==Va.balls[0]){
			System.out.print("YES");
		}
	}
}