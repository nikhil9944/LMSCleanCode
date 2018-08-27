package SimpleMavenExample.MockitoEx;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.yash.mockito.bean.Book;
import com.yash.mockito.bean.LibraryRecord;
import com.yash.mockito.libraryimpl.LendingManagerImpl;
import com.yash.mockito.mock.LibraryRecordDAO;

public class LendingManagerImplTest {
	@Mock
	LibraryRecordDAO libraryRecordDAO;

	@InjectMocks
	LendingManagerImpl landingManagerImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Ignore
	@Test
	public void shouldReturnIllegalStateException() {
		Book book = null;
		Mockito.when(libraryRecordDAO.findByBook(book)).thenThrow(IllegalStateException.class);

		/*
		 * LibraryRecord responseLibraryRecord =
		 * landingManagerImpl.returnBook(book);
		 * assertNull(responseLibraryRecord);
		 */
	}

	@Test
	public void shouldReturnBook() {
		Book book = new Book();
		book.setId(1L);
		book.setPublisher("ABC");
		book.setName("ABC");
		book.setISBN("KDVNVSKVN");
		List<LibraryRecord> responseLibraryRecords = new ArrayList<LibraryRecord>();
		LibraryRecord libraryRecord = new LibraryRecord();
		libraryRecord.setBorrowingDate(new Date());
		libraryRecord.setId(1L);
		libraryRecord.setBook(book);
		responseLibraryRecords.add(libraryRecord);

		Mockito.when(libraryRecordDAO.findByBook(book)).thenReturn(responseLibraryRecords);
		Mockito.when(libraryRecordDAO.save(libraryRecord)).thenReturn(true);
		LibraryRecord result = landingManagerImpl.returnBook(book);
		assertNotNull(result);
		
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenPassingNullBorrowingDate() {
		Book book = new Book();
		book.setId(1L);
		book.setPublisher("ABC");
		book.setName("ABC");
		book.setISBN("KDVNVSKVN");
		List<LibraryRecord> responseLibraryRecords = new ArrayList<LibraryRecord>();
		LibraryRecord libraryRecord = new LibraryRecord();
		libraryRecord.setId(1L);
		libraryRecord.setBook(book);
		responseLibraryRecords.add(libraryRecord);

		Mockito.when(libraryRecordDAO.findByBook(book)).thenReturn(responseLibraryRecords);
		Mockito.when(libraryRecordDAO.save(libraryRecord)).thenReturn(true);
		landingManagerImpl.returnBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).findByBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).save(libraryRecord);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenSaveMethodFails() {
		Book book = new Book();
		book.setId(1L);
		book.setPublisher("ABC");
		book.setName("ABC");
		book.setISBN("KDVNVSKVN");
		List<LibraryRecord> responseLibraryRecords = new ArrayList<LibraryRecord>();
		LibraryRecord libraryRcord = new LibraryRecord();
		libraryRcord.setId(1L);
		libraryRcord.setBook(book);
		libraryRcord.setBorrowingDate(new Date());
		responseLibraryRecords.add(libraryRcord);

		Mockito.when(libraryRecordDAO.findByBook(book)).thenReturn(responseLibraryRecords);
		Mockito.when(libraryRecordDAO.save(libraryRcord)).thenReturn(false);
		landingManagerImpl.returnBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).findByBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).save(libraryRcord);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenPassingMoreThanOneRecordWithNullReturnDate() {
		Book book = new Book();
		book.setId(1L);
		book.setPublisher("ABC");
		book.setName("ABC");
		book.setISBN("KDVNVSKVN");
		List<LibraryRecord> responseLibraryRecords = new ArrayList<LibraryRecord>();
		LibraryRecord libraryRecord = new LibraryRecord();
		libraryRecord.setBorrowingDate(new Date());
		libraryRecord.setId(1L);
		libraryRecord.setBook(book);
		responseLibraryRecords.add(libraryRecord);

		libraryRecord = new LibraryRecord();
		libraryRecord.setBorrowingDate(new Date());
		libraryRecord.setId(2L);
		libraryRecord.setBook(book);
		responseLibraryRecords.add(libraryRecord);

		Mockito.when(libraryRecordDAO.findByBook(book)).thenReturn(responseLibraryRecords);
		Mockito.when(libraryRecordDAO.save(libraryRecord)).thenReturn(true);
		landingManagerImpl.returnBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).findByBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).save(libraryRecord);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnEmptyLibraryBook() {
		List<LibraryRecord> libraryRecords = new ArrayList<LibraryRecord>();
		Book book = new Book();
		book.setId(1L);
		book.setPublisher("ABC");
		book.setName("ABC");
		book.setISBN("KDVNVSKVN");

		Mockito.when(libraryRecordDAO.findByBook(book)).thenReturn(libraryRecords);
		LibraryRecord result = landingManagerImpl.returnBook(book);
		Mockito.verify(libraryRecordDAO, Mockito.atLeast(1)).findByBook(book);
		assertNull(result);

	}

}
