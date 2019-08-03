package com.stolfa.service.impl;

import com.stolfa.service.GameService;
import com.stolfa.util.Outcome;
import com.stolfa.view.Game;
import java.security.InvalidParameterException;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    /**
     * Validation and get result.
     * @return 
     */
    @Override
    public Game play(int outcomeOne, int outcomeTwo) throws InvalidParameterException {

        checkParameters(outcomeOne, outcomeTwo);

        int result = getResult(outcomeOne, outcomeTwo);
        return new Game(outcomeOne, outcomeTwo, result);
    }

    /**
     * Check if paramters are between 1 and 3.
     *
     * @param outcomeOne
     * @param outcomeTwo
     * @throws InvalidParameterException
     */
    private void checkParameters(int outcomeOne, int outcomeTwo) throws InvalidParameterException {

        if (outcomeOne < 0 || outcomeOne > 3 || outcomeTwo < 0 || outcomeTwo > 3) {
            throw new InvalidParameterException("outcomeOne, outcomeTwo must be between 1 and 3.");
        }
    }

    /**
     * Here is all logic of the game.
     *
     * @param outcomeOne
     * @param outcomeTwo
     * @return
     */
    private int getResult(int outcomeOne, int outcomeTwo) {

        return Outcome.get(outcomeOne, outcomeTwo).winner();
        
    }

}
