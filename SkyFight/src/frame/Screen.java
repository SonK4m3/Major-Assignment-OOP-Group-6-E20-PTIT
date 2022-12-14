package frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import activities.ActivityAbs;
import control.*;
import input.*;

public class Screen extends ScreenAbs{
		
	private AppController appController;
	
	public Screen(AppController appController, ActivityAbs activity) {
		this.appController = appController;
		this.currentActivity = activity;
		this.init();
		this.setUp();
	}
	
	@Override
	void init() {
		this.xMouse = -1;
		this.yMouse = -1;
		this.mouseState = MouseState.RELEASED;
		this.myMouseListener = new MyMouseListener(this);
	}

	@Override
	void setUp() {
		this.setSize(960, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(currentActivity);
		this.addMouseListener(myMouseListener);
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);		
	}
	
	/*
	 * get center window position 
	 */
	public void centreWindow() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}
	
	public void resetAllActivitiesOptions() {
		this.appController.resetAllActivitiesOptions();
	}
	
	public ImageController getImageController() {
		return appController.imageController;
	}
	
	public void setTheme(int theme) {
		this.appController.theme = theme;
	}
	
	public int getTheme() {
		return appController.theme;
	}
	
	public void setGameSize(int size) {
		this.appController.gameSize = size;
	}
	
	public int getGameSize() {
		return this.appController.gameSize;
	}
	
	public void setAircraftType(int type) {
		this.appController.aircraftType = type;
	}
	
	public int getAircraftType() {
		return this.appController.aircraftType;
	}
	
	public void setBoardType(int type) {
		this.appController.boardType = type;
	}
	
	public int getBoardType() {
		return this.appController.boardType;
	}
}
