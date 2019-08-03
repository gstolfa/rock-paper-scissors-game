package com.stolfa;

import com.stolfa.service.GameService;
import com.stolfa.view.Game;
import java.security.InvalidParameterException;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockPaperScissorGameApplicationTests {

	@Autowired
	GameService service;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldThrowInvalidParameterException() throws Exception {
	    expectedEx.expect(InvalidParameterException.class);
	    expectedEx.expectMessage("outcomeOne, outcomeTwo must be between 1 and 3.");
	    service.play(1, 8);
	}

	@Test
	public void shoudWinPlayerTwo() {
		Game game = service.play(1, 3);
		assertTrue(game.getResult() == 2);

		game = service.play(2, 1);
		assertTrue(game.getResult() == 2);

		game = service.play(3, 2);
		assertTrue(game.getResult() == 2);
	}
	
	@Test
	public void shoudWinPlayerOne() {
		Game game = service.play(3, 1);
		assertTrue(game.getResult() == 1);

                game = service.play(1, 2);
		assertTrue(game.getResult() == 1);

		game = service.play(2, 3);
		assertTrue(game.getResult() == 1);
	}
	
	@Test
	public void shoudGetDraw() {
		Game game = service.play(3, 3);
		assertTrue(game.getResult() == 0);

		game = service.play(1, 1);
		assertTrue(game.getResult() == 0);

		game = service.play(2, 2);
		assertTrue(game.getResult() == 0);
	}

}
