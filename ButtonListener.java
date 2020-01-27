import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class ButtonListener implements ActionListener{
	public static int c=8;
	public static Border black = BorderFactory.createLineBorder(Color.black, 3);
	public void actionPerformed(ActionEvent evt){
		ImageIcon iballs = new ImageIcon(getClass().getResource("images/iballs.jpg"));
		Border blue = BorderFactory.createLineBorder(Color.blue, 4);
		MButton b = (MButton)evt.getSource();
		if(!Va.isSelected){
			Va.temp = b;
			if(b.getIcon()!=null){
				Va.isSelected = true;
				b.setBorder(blue);
			}
		}
		else{
			Va.isSelected = false;
			Va.temp.setBorder(black);
			if(b.getIcon()==null){
				b.setIcon(iballs);
				Va.temp.setIcon(null);
				if(!Va.temp.isBoard && b.isBoard)
					c--;
				else if(Va.temp.isBoard && !b.isBoard)
					c++;
				if(c==0){
					if(check(b.i, b.j)){
						blackBorder();
						Va.sound.play();
						JOptionPane.showMessageDialog(Va.main, "Yayyyy! you did it.");
					}
				}
				if(b.isBoard){
					blackBorder();
					check(b.i, b.j);					
				}
			}
		}
	}
	private static boolean check(int a, int b){
		Border red = BorderFactory.createLineBorder(Color.red, 4);
		boolean is=true;
		for(int i=0; i<8; i++){
			if(Va.bt[a][i]!=Va.bt[a][b] && Va.bt[a][i].getIcon()!=null){
				Va.bt[a][i].setBorder(red);
				is = false;
			}
			if(Va.bt[i][b]!=Va.bt[a][b] && Va.bt[i][b].getIcon()!=null){
				Va.bt[i][b].setBorder(red);
				is = false;
			}
			for(int j=0; j<8; j++){
				if(Va.bt[i][j]!=Va.bt[a][b] && a-i==b-j && Va.bt[i][j].getIcon()!=null){
					Va.bt[i][j].setBorder(red);
					is = false;
				}
				if(Va.bt[i][j]!=Va.bt[a][b] && a+b==i+j && Va.bt[i][j].getIcon()!=null){
					Va.bt[i][j].setBorder(red);
					is = false;
				}
			}
		}
		return is;
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