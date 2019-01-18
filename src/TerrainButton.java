import java.awt.Dimension;

import javax.swing.JButton;

public class TerrainButton extends JButton {

	public TerrainButton() {
		private int row = 0; 
		private int col =0; 
		private int nextToHole = 0; 
		
		private boolean hole = false;
		private boolean revealed = false;
		
		public static final int SIZE = 50;
		
		public TerrainButton (int row, int col) { 
			int r = row; 
			int c = col; 
			
			Dimension sizeWide = new Dimension(); 
			Dimension sizeHeight = new Dimension(); 
			terrainButton.setPreferredSize(SIZE); 
		}
		
	}
	
	public int getRow() { 
		return row(); 
	}
	
	public int getCol() { 
		return col; 
	}
	public boolean isRevealed() { 
		return revealed; 
	}
	public boolean hasHole() { 
		return revealed; 
	}

}
