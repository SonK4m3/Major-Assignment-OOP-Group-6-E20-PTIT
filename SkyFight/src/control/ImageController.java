package control;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageController {
	
	public BufferedImage logo;
	
	public BufferedImage blueSkyImage;
	public BufferedImage nightSkyImage;

	public BufferedImage blueAircraftLeftImage;
	public BufferedImage blueAircraftRightImage;
	public BufferedImage blueAircraftTopImage;
	public BufferedImage blueAircraftBottomImage;

	public BufferedImage redAircraftLeftImage;
	public BufferedImage redAircraftRightImage;
	public BufferedImage redAircraftTopImage;
	public BufferedImage redAircraftBottomImage;
	
	public BufferedImage board1Image;
	public BufferedImage board2Image;
	
	public BufferedImage quitButtonImage;
	public BufferedImage saveButtonImage;
	public BufferedImage defaultButtonImage;
	public BufferedImage startButtonImage;
	public BufferedImage optionButtonImage;
	public BufferedImage backButtonImage;
	
	String logoPath = "image/logo.png";
	String blueSkyPath = "image/screen/blue_sky.jpg";
	String nightSkyPath = "image/screen/night_sky.jpg";

	String blueAircraftLeftPath = "image/aircraft/aircraft_blue_left.png";
	String blueAircraftRightPath = "image/aircraft/aircraft_blue_right.png";
	String blueAircraftTopPath = "image/aircraft/aircraft_blue_top.png";
	String blueAircraftBottomPath = "image/aircraft/aircraft_blue_bottom.png";
	
	String redAircraftLeftPath = "image/aircraft/aircraft_red_left.png";
	String redAircraftRightPath = "image/aircraft/aircraft_red_right.png";
	String redAircraftTopPath = "image/aircraft/aircraft_red_top.png";
	String redAircraftBottomPath = "image/aircraft/aircraft_red_bottom.png";
	
	String board1Path = "image/board/board_1.png";
	String board2Path = "image/board/board_2.png";
	
	String quitButtonPath = "image/button/quit_button.png";
	String startButtonPath = "image/button/start_button.png";
	String optionButtonPath = "image/button/option_button.png";
	String backButtonPath = "image/button/back_button.png";
	String saveButtonPath = "image/button/save_button.png";
	String defaultButtonPath = "image/button/default_button.png";
	
	public ImageController() {
		
	}
	
	BufferedImage readImage(String filename) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	void readingButtons() {
		quitButtonImage = this.readImage(quitButtonPath);
		startButtonImage = this.readImage(startButtonPath);
		optionButtonImage = this.readImage(optionButtonPath);
		saveButtonImage = this.readImage(saveButtonPath);
		backButtonImage = this.readImage(backButtonPath);
		defaultButtonImage = this.readImage(defaultButtonPath);
	}
	
	void readingAircrafts() {
		blueAircraftBottomImage = this.readImage(blueAircraftBottomPath);
		blueAircraftLeftImage = this.readImage(blueAircraftLeftPath);
		blueAircraftRightImage = this.readImage(blueAircraftRightPath);
		blueAircraftTopImage = this.readImage(blueAircraftTopPath);
		
		redAircraftBottomImage = this.readImage(redAircraftBottomPath);
		redAircraftLeftImage = this.readImage(redAircraftLeftPath);
		redAircraftRightImage = this.readImage(redAircraftRightPath);
		redAircraftTopImage = this.readImage(redAircraftTopPath);
	}
	
	void readingBoard() {
		board1Image = this.readImage(board1Path);
		board2Image = this.readImage(board2Path);
	}
	
	public void initImage() {
		logo = readImage(logoPath);
		blueSkyImage = readImage(blueSkyPath);
		nightSkyImage = readImage(nightSkyPath);

		this.readingButtons();
		this.readingBoard();
		this.readingAircrafts();
	}
	
	
}
