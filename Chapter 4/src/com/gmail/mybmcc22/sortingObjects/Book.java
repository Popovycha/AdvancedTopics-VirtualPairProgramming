package com.gmail.mybmcc22.sortingObjects;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book>{
    //Nested Class static
	public static class ReverseTitleComparator implements Comparator<Book> {
		public int compare(Book arg0, Book arg1) {
			return - arg0.getTitle().compareTo(arg1.getTitle());
		}
	}

	private int id;
	private String title;
	private String author;



	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public String toString() {
		return title + " by " + author;
	}

	//Order by Title where are different authors
	@Override
	public int compareTo(Book book) {
		int result = this.title.compareTo(book.getTitle());
		if (result == 0) {
			return (this.author.compareTo(book.getAuthor()));
		}
		else {
			return result;
		}
	}
    //hashMap chapter 4
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return Objects.equals(title, book.title) &&
				Objects.equals(author, book.author);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
}
