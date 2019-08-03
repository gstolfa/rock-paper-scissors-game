package com.stolfa.util;

public enum Outcome {

    SCISSORS_PAPER(1, 2, 1),
    SCISSORS_ROCK(1, 3, 2),
    SCISSORS_SCISSORS(1, 1, 0),
    
    PAPER_ROCK(2, 3, 1),
    PAPER_SCISSORS(2, 1, 2),
    PAPER_PAPER(2, 2, 0),
    
    ROCK_PAPER(3, 2, 2),
    ROCK_SCISSORS(3, 1, 1),
    ROCK_ROCK(3, 3, 0);

    private final int outcomeOne, outcomeTwo, winner;

    Outcome(int outcomeOne, int outcomeTwo, int winner) {
        this.outcomeOne = outcomeOne;
        this.outcomeTwo = outcomeTwo;
        this.winner = winner;
    }

    public int outcomeOne() {
        return this.outcomeOne;
    }

    public int outcomeTwo() {
        return this.outcomeTwo;
    }

    public int winner() {
        return this.winner;
    }

    public static Outcome get(int outcomeOne, int outcomeTwo) {
        for (Outcome dt : Outcome.values()) {
            if (outcomeOne == dt.outcomeOne() && outcomeTwo == dt.outcomeTwo()) {
                return dt;
            }
        }
        return null;
    }

}
