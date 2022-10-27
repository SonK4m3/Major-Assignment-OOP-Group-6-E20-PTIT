package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import button.ButtonAbs;
import button.ButtonImp;
import frame.ActivityAbs;

public class SwitchScreenButton extends ButtonAbs implements ButtonImp{
	
	ActivityAbs nextActivity;
	
	public SwitchScreenButton(ActivityAbs activity, int xPos, int yPos) {
		this.setAcivity(activity);
		this.xPos = xPos;
		this.yPos = yPos;
		this.init();
		this.myButton();
	}
	
	@Override
	public void init() {
		this.isMouseOnButton = false;
		
	}

	@Override
	public void myButton() {
		this.buttonWidth = 130;
		this.buttonHeight = 30;		
	}

	@Override
	public void action() {
		System.out.println("Switch Screen Button");
		
	}

	@Override
	public boolean checkMouseOnButton(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
		g2d.fillRect(this.xPos, this.yPos, this.buttonWidth, this.buttonHeight);
	}

}
