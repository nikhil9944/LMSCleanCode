package com.yash.mockito.mock;

import java.util.List;

import com.yash.mockito.bean.Book;
import com.yash.mockito.bean.LibraryRecord;

public interface LibraryRecordDAO {
	public List<LibraryRecord> findByBook(Book book);
	public boolean save(LibraryRecord libraryRecord);
}
