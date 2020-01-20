import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		ImageIcon iballs = new ImageIcon(getClass().getResource("images/iballs.jpg"));
		Border blue = BorderFactory.createLineBorder(Color.blue, 4);
		Border black = BorderFactory.createLineBorder(Color.black, 3);
		MButton b = (MButton)evt.getSource();
		if(!Va.isSelected){
			Va.temp = b;
			if(!(b.getIcon()==null)){
				Va.isSelected = true;
				b.setBorder(blue);
				System.out.println("selected");
			}
		}
		else{
			Va.isSelected = false;
			if(b.getIcon()==null){
				Va.temp.setBorder(black);
				System.out.println("not selected");
				b.setIcon(iballs);
				Va.temp.setIcon(null);
			}
		}
	}
}