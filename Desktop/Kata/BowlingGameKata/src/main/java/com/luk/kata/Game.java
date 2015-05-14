package com.luk.kata;

public class Game {
	
	private int score = 0;
	
	public void roll(int points) {
		score=score+points;
	}
	
	public int score() {
		return score;
	}
}