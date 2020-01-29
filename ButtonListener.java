import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class ButtonListener implements ActionListener{
	public static int c=8;
	public void actionPerformed(ActionEvent evt){
		ImageIcon iballs = new ImageIcon(getClass().getResource("images/iballs.png"));
		ImageIcon igold = new ImageIcon(getClass().getResource("images/igold4.png"));
		Border black = BorderFactory.createLineBorder(Color.black, 3);
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
					if(isWinner()){
						for(int i=0; i<8; i++)
							for(int j=0; j<8; j++)
								if(Va.bt[i][j].getIcon()!=null)
									Va.bt[i][j].setIcon(igold);
						Va.sound.play();
						JOptionPane.showMessageDialog(Va.main, "Yayyyy! you did it.");
					}
				}
			}
		}
	}
	private static boolean check(int a, int b){
		for(int i=0; i<8; i++){
			if(Va.bt[a][i]!=Va.bt[a][b] && Va.bt[a][i].getIcon()!=null)
				return false;
			if(Va.bt[i][b]!=Va.bt[a][b] && Va.bt[i][b].getIcon()!=null)
				return false;
			for(int j=0; j<8; j++){
				if(Va.bt[i][j]!=Va.bt[a][b] && a-i==b-j && Va.bt[i][j].getIcon()!=null)
					return false;
				if(Va.bt[i][j]!=Va.bt[a][b] && a+b==i+j && Va.bt[i][j].getIcon()!=null)
					return false;
			}
		}
		return true;
	}
	private static boolean isWinner(){
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				if(Va.bt[i][j].getIcon()!=null && !check(i, j))
					return false;
		return true;
	}
}