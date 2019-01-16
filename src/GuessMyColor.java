import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GuessMyColor extends JFrame{
	
	private int compRed = 0;
	private int compGreen = 0; 
	private int compBlue = 0; 
	private Color compColor = new Color (compRed, compGreen, compBlue);
	
	//my color 
	private int myRed = 0;
	private int myGreen = 0; 
	private int myBlue = 0; 
	private Color myColor = new Color (myRed, myGreen, myBlue);
	
	private JPanel myPanel = new JPanel();
	
	public GuessMyColor(){	
		
		initGUI();
		
		setTitle("Game Window");
		setSize(400, 200); //pixels
		setResizable(true);
		//pack(); //make everything real tight --> override size 
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

			
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void initGUI(){
		//create label 
		JLabel titleLabel = new JLabel("Guess My Color");
		//customize the label 
		Font titleFont = new Font (Font.SERIF, Font.BOLD + Font.ITALIC, 32);
		titleLabel.setFont(titleFont); 
		titleLabel.setForeground(Color.BLACK);
		//titleLabel.setBackground(new Color(29,62,114));
		titleLabel.setOpaque(true);
		
		//add label to window
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		
		//CENTER PANEL
		JPanel centerPanel = new JPanel(); 
		centerPanel.setBackground(Color.WHITE);
		add(centerPanel, BorderLayout.CENTER); 
		
		Dimension size = new Dimension(50,50); 
	 
		myPanel.setBackground(myColor); //this will change w/buttons
		myPanel.setPreferredSize(size);
		centerPanel.add(myPanel, BorderLayout.PAGE_START); 
		
		JPanel computerPanel = new JPanel();
		generateRandomColor();
		computerPanel.setBackground(compColor); //will be randomized color
		computerPanel.setPreferredSize(size);
		centerPanel.add(computerPanel, BorderLayout.PAGE_START); 
		
		//BUTTON PANEL 
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setBackground(Color.BLACK);
		add(buttonPanel, BorderLayout.PAGE_END); 
		
			//buttons 
			JButton moreRedButton = new JButton("+");
				moreRedButton.setBackground(Color.RED);
				//action listener 
				moreRedButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) { 
						addRed(); 
					}
				});
				buttonPanel.add(moreRedButton);
			JButton lessRedButton = new JButton("-");
				lessRedButton.setBackground(Color.RED);
				lessRedButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) { 
						subRed(); 
					}
				});
				buttonPanel.add(lessRedButton);			
			
			JButton moreGreenButton = new JButton("+");
				moreGreenButton.setBackground(Color.GREEN);
				moreGreenButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) { 
						addGreen(); 
					}
				});
				buttonPanel.add(moreGreenButton);
			JButton lessGreenButton = new JButton("-");
				lessGreenButton.setBackground(Color.GREEN);
				lessGreenButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) { 
						subGreen(); 
					}
				});
				buttonPanel.add(lessGreenButton);
			
			JButton moreBlueButton = new JButton("+");
				moreBlueButton.setBackground(Color.BLUE);
				moreBlueButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) { 
						addBlue(); 
					}
				});
				buttonPanel.add(moreBlueButton);
			JButton lessBlueButton = new JButton("-");
				lessBlueButton.setBackground(Color.BLUE);
				lessBlueButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) { 
						subBlue(); 
					}
				});
				buttonPanel.add(lessBlueButton);
	}

	private void generateRandomColor() { 
		compRed = ((int)(Math.random()*15 +1)*17);
		compGreen = ((int)(Math.random()*15 +1)*17);
		compBlue = ((int)(Math.random()*15 +1)*17);
		
		compColor = new Color(compRed, compGreen, compBlue); 
	}
	
	private void addRed() { 
		myRed += 17; 
		if (myRed > 255) { 
			myRed =0; 
		}
		updateColor(); 
	}
	
	private void updateColor() { 
		myColor = new Color(myRed, myGreen, myBlue); 
		myPanel.setBackground(myColor); 
		
		if (myRed == compRed &&
				myGreen == compGreen && 
				myBlue == compBlue) { 
			JOptionPane.showMessageDialog(null," Congratulations! You won! Isn't that satisfying?");
		}
	}
	
	private void subRed() { 
		myRed -= 17; 
		if (myRed < 0) { 
			myRed = 255; 
		}
		updateColor(); 
	}
	
	private void addGreen() { 
		myGreen += 17; 
		if (myGreen > 255) { 
			myGreen = 0; 
		}
		updateColor(); 
	}
	
	private void subGreen() { 
		myGreen -= 17; 
		if (myGreen < 0) { 
			myGreen = 255; 
		}
		updateColor(); 
	}
	
	private void addBlue() { 
		myBlue += 17; 
		if (myBlue > 255) { 
			myBlue = 0; 
		}
		updateColor(); 
	}
	
	private void subBlue() { 
		myBlue -= 17; 
		if (myBlue < 0) { 
			myBlue = 255; 
		}
		updateColor(); 
	}
	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new GuessMyColor(); //must have a constructor 1st thing called 
            }   
        });

	}

}
