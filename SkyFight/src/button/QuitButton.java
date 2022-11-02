package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import activities.ActivityAbs;

public class QuitButton extends ButtonAbs implements ButtonImp{
	public QuitButton(ActivityAbs activity, int xPos, int yPos) {
		this.setAcivity(activity);
		this.xPos = xPos;
		this.yPos = yPos;
		this.myButton();
	}
	
	@Override
	public void myButton() {
		this.buttonWidth = 150;
		this.buttonHeight = 40;
		this.isMouseOnButton = false;
	}

	@Override
	public void action() {		
		System.out.println("Quit Button");
	}

	@Override
	public boolean checkMouseOnButton(int x, int y) {
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(this.xPos, this.yPos, this.buttonWidth, this.buttonHeight);
	}
}