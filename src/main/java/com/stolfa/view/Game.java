package com.stolfa.view;

public class Game {

	private int outcomeOne;
    
	private int outcomeTwo;

	private int result;

	private String error;
	
	public Game(int outcomeOne, int outcomeTwo, int result) {
		super();
		this.outcomeOne = outcomeOne;
		this.outcomeTwo = outcomeTwo;
		this.result = result;
	}

	public Game(String error) {
		super();
		this.error = error;
	}

	public int getOutcomeOne() {
		return outcomeOne;
	}

	public void setOutcomeOne(int outcomeOne) {
		this.outcomeOne = outcomeOne;
	}

	public int getOutcomeTwo() {
		return outcomeTwo;
	}

	public void setOutcomeTwo(int outcomeTwo) {
		this.outcomeTwo = outcomeTwo;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	} 

	
}
