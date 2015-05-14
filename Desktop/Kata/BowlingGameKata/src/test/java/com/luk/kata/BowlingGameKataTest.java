package com.luk.kata;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Test;

public class BowlingGameKataTest {

	@Test
 	public void gameWithoutPoints() {
		Game g = new Game();
		rollAFewTimes(g,0);
		assertThat(g.score(), is(0));
	}
	
	
	@Test
 	public void gameWith20Points() {
		Game g = new Game();
		rollAFewTimes(g,1);
		assertThat(g.score(), is(20));
	}
	
	public void rollAFewTimes(Game game , int points)
	{
		for (int i =0; i<20; i++) {
			game.roll(points);
			
		}
	}
}
