package com.excilys.kataspoker.model;

public class NotEnoughCardsException extends Exception {
	public NotEnoughCardsException() {
		super("Not enough cards in the deck");
	}
}
