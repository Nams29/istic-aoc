package aoc.v2.ihm;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonBool extends JButton implements MouseListener {

	private static final long serialVersionUID = 8133731061390398379L;

	private boolean active = false;

	public ButtonBool(String s) {
		super(s);
		addMouseListener(this);
	}
	
	public ButtonBool(ImageIcon s) {
		super(s);
		addMouseListener(this);
	}
	
	

	public boolean isActive() {
		return active;
	}
	
	public void unActive() {
		active=false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		active = true;	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		active = false;
		
	}

}
