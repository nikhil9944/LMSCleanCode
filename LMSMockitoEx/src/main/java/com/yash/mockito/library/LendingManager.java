package com.yash.mockito.library;

import com.yash.mockito.bean.Book;
import com.yash.mockito.bean.LibraryRecord;

public interface LendingManager {
	public LibraryRecord borrowBook(Book book);

	public LibraryRecord returnBook(Book book);
}
