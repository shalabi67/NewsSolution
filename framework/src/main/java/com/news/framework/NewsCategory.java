package com.news.framework;

public enum NewsCategory {
	Sports(1),
	News(2),
	General(3);
	
	private final int value;
    private NewsCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
