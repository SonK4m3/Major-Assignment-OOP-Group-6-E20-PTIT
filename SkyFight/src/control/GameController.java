package control;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;

import figure.Board;
import input.MouseState;
import player.*;

public class GameController {
	
	int xBoardPos = 122;
	int yBoardPos = 93;
	Computation cal = new Computation();
	private Player P1;
	private Player P2;
	ArrayDeque<Player> turn = new ArrayDeque<>();
	
	public GameController() {
		this.newGame();
	}
	/*
	 * initial player and turn
	 */
	public void newGame() {
		P1 = new Player(this, "P1", 2);
		P2 = new Player(this, "P2", 2);
		turn.clear();
		turn.addLast(P1);
		turn.addLast(P2);
	}
	/*
	 * set image 
	 */
	public void setBoardImage(BufferedImage boardImage) {
		P1.setBoardImage(boardImage);
		P2.setBoardImage(boardImage);
	}
	
	public void setAircraftImage(BufferedImage imageLeft, BufferedImage imageRight, BufferedImage imageTop, BufferedImage imageBottom) {
		P1.setAircraftImage(imageLeft, imageRight, imageTop, imageBottom);
		P2.setAircraftImage(imageLeft, imageRight, imageTop, imageBottom);
	}
	
	public void setBoardPos(int x, int y) {
		this.xBoardPos = x;
		this.yBoardPos = y;
		P1.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
		P2.getBoardOfPlayer().setOxyCoor(this.xBoardPos, this.yBoardPos);
	}
	
	public int getXBoardPos() {
		return this.xBoardPos;
	}
	
	public int getYBoardPos() {
		return this.yBoardPos;
	}
	
	public void changeTurn() {
		Player cur = turn.pollFirst();
		turn.addLast(cur);
	}
	
	public Player getCurrentPlayer() {
		return this.turn.peekFirst();
	}
	
	public Board getCurrentPlayerBoard() {
		return this.getCurrentPlayer().getBoardOfPlayer();
	}
	
	public Player getWattingPlayer() {
		return this.turn.peekLast();
	}
	
	public Player getPlayerIsShooting() {
		return (P1.getState() == PlayerState.shooting) ? P1 : P2;
	}
	
	public Board getWaitingPlayerBoard() {
		return this.getWattingPlayer().getBoardOfPlayer();
	}
	
	public boolean currentPlayerIsCompletedPlaced() {
		return this.getCurrentPlayer().getState() == PlayerState.complete_place;
	}
	
	public boolean gameFinished() {
		return cal.gameFinished(P1, P2);
	}
	
	public Player getwinner() {
		return (P1.getState() == PlayerState.win) ? P1 : P2;
	}
	
	public Player getLoser() {
		return (P1.getState() == PlayerState.lose) ? P1 : P2;
	}
	/*
	 * check 2 player is completed place or not
	 * and update player state to fight round
	 */
	public boolean twoPlayerIsCompletePlaced() {
		if ((this.P1.getState() == PlayerState.complete_place) && (this.P2.getState() == PlayerState.complete_place)){
			P1.setState(PlayerState.shooting);
			P2.setState(PlayerState.waiting);
			return true;
		} else 
			return false;
	}
	/*
	 *  place round
	 *  player place or rotate or remove aircraft
	 *  return state of result
	 */
	public String  playerPlaceAircraft(int xMouse, int yMouse, MouseState mouseState) {
		// 1. check mouse state is left or right to action
		if(mouseState == MouseState.LEFTPRESSED) {
			return cal.placeAirCraft(xMouse, yMouse, this.getCurrentPlayer());
		}
		else {
			return cal.resetOneAircraft(xMouse, yMouse, this.getCurrentPlayer());
		}
	}
	/*
	 * remove 2 aircrafts of player
	 */
	public void playerResetAllAircraft() {
		cal.resetAll(this.getCurrentPlayer());
	}
	/*
	 *  player choose cell to shoot
	 *  check state of cell and return result to show to player
	 *  change state of players
	 */
	public String shootingStage(int xMouse, int yMouse, Player p1) { 
		if(p1.getState() == PlayerState.shooting) {
			Player p2 = this.getWattingPlayer();
			String player_shooted = p1.getPlayerName() + " shoot " + p2.getPlayerName() + " ";
			String notify = cal.shootAircraft(xMouse, yMouse, p2); 
			if(notify != null) {
				notify = player_shooted + notify;
				p1.setState(PlayerState.waiting);
				p2.setState(PlayerState.shooting);
			} else {
				notify = "invalid shoot";
			}
			return notify;
		} else {
			return null;
		}
	}
}
