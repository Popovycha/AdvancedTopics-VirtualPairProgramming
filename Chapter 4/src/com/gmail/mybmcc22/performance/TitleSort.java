package com.gmail.mybmcc22.performance;

import java.util.Comparator;


import com.gmail.mybmcc22.sortingObjects.Book;

public class TitleSort implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		return arg0.getTitle().compareTo(arg1.getTitle());
	}

	@Override
	public Comparator<Book> reversed() {
		return null;
	}
}
