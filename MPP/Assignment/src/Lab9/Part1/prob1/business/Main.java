package Lab9.Part1.prob1.business;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import Lab9.Part1.prob1.dataaccess.DataAccess;
import Lab9.Part1.prob1.dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingOverdueBook());
		System.out.println(allHavingMultipleAuthors());

	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		//implement
		 return mems.stream()
		.filter(lm->lm.getAddress().getZip().contains("3"))
		.map(lm->lm.getMemberId())
		.collect(Collectors.toList());
		
		
	}
	//Returns a list of all ids of  LibraryMembers that have an overdue book
	public static List<String> allHavingOverdueBook() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		Collection<Book> books = da.readBooksMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		//implement
		/* Have no enough information to find allHavingOverdueBook */
		return null;
		
		
	}
	
	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		//implement
		
		return books.stream()
		.filter(book-> book.getAuthors().size()>1)
		.map(book->book.getIsbn())
		.collect(Collectors.toList());
		}

}
