class MButton extends javax.swing.JButton{
	boolean isBoard;
	int i,j;
	public MButton(int i, int j){
		this.i = i;
		this.j = j;
		isBoard = true;
	}
	public MButton(int i){
		this.i = i;
		isBoard = false;
	}
}