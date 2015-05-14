package com.luk.kata;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Test;

public class BowlingGameKataTest {

	@Test
 	public void gameWithoutPoints() {
		Game g = new Game();
		for(int i =0; i<20; i++){
			g.roll(0);
			assertThat(g.score(), is(0));
		}
	
	}
}
