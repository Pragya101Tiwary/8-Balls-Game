import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class ButtonListener implements ActionListener{
	private static Border black = BorderFactory.createLineBorder(Color.black, 3);
	public void actionPerformed(ActionEvent evt){
		ImageIcon iballs = new ImageIcon(getClass().getResource("images/iballs.jpg"));
		Border blue = BorderFactory.createLineBorder(Color.blue, 4);
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
			Va.temp.setBorder(black);
			if(b.getIcon()==null){
				System.out.println("not selected");
				b.setIcon(iballs);
				Va.temp.setIcon(null);
				if(b.isBoard){
					blackBorder();
					check(b.i, b.j);					
				}
			}
		}
	}
	private static void check(int a, int b){
		Border red = BorderFactory.createLineBorder(Color.red, 4);
		for(int i=0; i<8; i++){
			if(Va.bt[a][i]!=Va.bt[a][b] && Va.bt[a][i].getIcon()!=null){
				Va.bt[a][i].setBorder(red);
			}
			if(Va.bt[i][b]!=Va.bt[a][b] && Va.bt[i][b].getIcon()!=null){
				Va.bt[i][b].setBorder(red);
			}
			for(int j=0; j<8; j++){
				if(Va.bt[i][j]!=Va.bt[a][b] && a-i==b-j && Va.bt[i][j].getIcon()!=null){
					Va.bt[i][j].setBorder(red);
				}
				if(Va.bt[i][j]!=Va.bt[a][b] && a+b==i+j && Va.bt[i][j].getIcon()!=null){
					Va.bt[i][j].setBorder(red);
				}
			}
		}
	}
	private static void blackBorder(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(Va.bt[i][j].getIcon()!=null){
					Va.bt[i][j].setBorder(black);
					check(i,j);
				}
			}
		}
	}
}