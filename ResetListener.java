import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ResetListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		JButton b=(JButton)evt.getSource();
		if(b==Va.reset){
			ImageIcon iballs = new ImageIcon(getClass().getResource("images/iballs.png"));
			for(int i=0; i<8; i++){
				Va.balls[i].setIcon(iballs);
				for(int j=0; j<8; j++){
					Va.bt[i][j].setIcon(null);
				}
			}
			Va.isSelected=false;
			ButtonListener.c=8;			
		}
	}
}