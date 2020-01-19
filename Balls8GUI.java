import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Balls8GUI extends JFrame{
	
	JLabel bg = new JLabel(new ImageIcon(getClass().getResource("images/iii.jpg")));
	JPanel []pa = new JPanel[4];
	ButtonListener btl = new ButtonListener();
	
	public Balls8GUI(){
		super("8-Queens Game");
		setSize(1300,930);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("images/iball.jpg")).getImage());
		add(bg);
		addPanels();
		setVisible(true);
	}
	
	private void addPanels(){
		for(int i=0; i<4; i++){
			pa[i] = new JPanel();
			bg.add(pa[i]);
		}
		pa[0].setBounds(20, 20, 1260, 80);
		pa[1].setBounds(20, 170, 480, 70);
		pa[2].setBounds(30, 300, 460, 480);
		pa[3].setBounds(520, 120, 760, 760);
		
		addButtonsAndLabels();
	}
	
	private void addButtonsAndLabels(){
		javax.swing.border.Border b = BorderFactory.createLineBorder(Color.black,3);
		pa[3].setLayout(new GridLayout(8,8));
		pa[3].setBorder(b);
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				Va.bt[i][j] = new JButton();
				Va.bt[i][j].setBorder(b);
				Va.bt[i][j].addActionListener(btl);
				pa[3].add(Va.bt[i][j]);
			}
		}
		pa[1].add(Va.reset);
		Font f = new Font("georgia", Font.PLAIN, 42);
		Va.reset.setFont(f);
		Va.reset.setBackground(Color.green);
		Va.reset.addActionListener(btl);
		JLabel la = new JLabel(new ImageIcon(getClass().getResource("images/box4.jpg")));
		JLabel la1 = new JLabel("<html><body><div align='justify' style = 'font-size:21px; color: #013220;'><center><font style = 'font-size:23px; color:black;'>Instructions:</font></center><br>^ Place all the 8 balls on the board such that no two balls are in the same row, column or division.<br><br>^ Here, each ball represents the queen of the chess. No queen should kill another queen.</div></body></html>");
		la1.setBounds(33, 5, 421, 442);
		la.add(la1);
		pa[2].add(la);
		pa[2].setOpaque(false);
		pa[1].setOpaque(false);
		pa[0].setLayout(null);
		ImageIcon iballs = new ImageIcon(getClass().getResource("images/iballs.jpg"));
		for(int i=0, j=500; i<8 && j<=1165; i++, j+=95){
			Va.balls[i] = new JButton(iballs);
			//Va.balls[i].setBorder(b);
			Va.balls[i].addActionListener(btl);
			pa[0].add(Va.balls[i]);
			Va.balls[i].setBounds(j, 0, 95, 80);
		}
		JLabel game_name = new JLabel("<html><body><center><font style = 'font-size:50px; color:black;'>8 BALLS</font></center></body></html>");
		game_name.setBounds(120, 0, 300, 80);
		//game_name.setBorder(b);
		pa[0].add(game_name);
		pa[0].setOpaque(false);
	}
	
	public static void main(String[] args){
		new Balls8GUI();
	}
}