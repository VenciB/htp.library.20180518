package by.htp.library.logic;

import by.htp.library.entity.Author;
import by.htp.library.entity.Book;
import by.htp.library.entity.Library;
import by.htp.library.run.BookFinder;
import by.htp.library.run.GetAnswer;
import by.htp.library.run.GetListOfAuthorBooks;
import by.htp.library.run.PrintListOfAuthorBooks;
import by.htp.library.run.PrintMessage;
import by.htp.library.run.PrintOneBookFullInformation;

public class Librarian {

	private Author[] authors;
	private Library library;
	private PrintMessage pm;
	private PrintOneBookFullInformation pobfi;
	private GetAnswer ga;
	private BookFinder bf;
	private GetListOfAuthorBooks gloab;
	private PrintListOfAuthorBooks ploab;

	public Librarian(Library library, Author[] authors) {
		this.library = library;
		this.authors = authors;
		pm = new PrintMessage();
		pobfi = new PrintOneBookFullInformation();
		ga = new GetAnswer();
		bf = new BookFinder();
		gloab = new GetListOfAuthorBooks();
		ploab = new PrintListOfAuthorBooks();
	}

	public void addNewBooks(Book[] listOfBooks) {
		for (int i = 0; i < listOfBooks.length; i++) {
			library.addBook(listOfBooks[i]);
		} // end for loop
	} // end addNewBooks

	// ##################################################
	// case 1, printing a list of all books #
	// ##################################################
	public void printAllBooks(Library library, String message) {
		pm.printTopMessage(message);
		for (int i = 0; i < library.getBooks().length; i++) {
			System.out.println("Book " + (i + 1) + ": " + library.getBookName(i));
		} // end for loop
	} // end printAllBooks

	// ##################################################
	// case 2, printing full information about one book #
	// ##################################################
	public void printFullInformationOfOneBook(String message) {
		pm.printTopMessage(message);
		int numberOfBook = ga.getInt("Enter the book number: ");
		pobfi.printBookFullInformation(numberOfBook, library);

	} // end case 2, printing full information about one book

	// #################################################
	// case 3, printing list of all authors #
	// #################################################
	public void printListOfAllAuthors(String message) {
		pm.printTopMessage(message);
		for (int i = 0; i < authors.length; i++) {
			System.out.print("Autor " + (i + 1) + ":");
			System.out.print("\t" + authors[i].getLastName() + " " + authors[i].getFirstName() + " "
					+ authors[i].getOtchestvo() + "\n");
		} // end for loop
		pm.printLongLine();

	} // end case 3, printing list of all authors

	// ################################################
	// case 4, searching by author, title and year #
	// ################################################
	public void searchByAuthorTitleYear(String message) {
		pm.printTopMessage(message);

		int book_year = ga.getInt("Enter year of the book:");
		String book_title = ga.getString("Enter the book title:");
		String author_last_name = ga.getString("Enter the author's last name:");
		String author_first_name = ga.getString("Enter the author's first name:");
		String author_otchestvo = ga.getString("Enter the author's otchestvo:");

		int book_founded = bf.findBookByYearTitleAuthor(library, book_year, book_title, author_last_name,
				author_first_name, author_otchestvo);

		printIfFoundBook(book_founded);

	} // end case 4, searching by author, title and year

	private void printIfFoundBook(int book_founded) {
		if (book_founded > 0) { // start if - else
			System.out.println(
					"The book with such parameters was found." + "\nHere is the full information about the book:");
			pm.printLongLine();
			pobfi.printBookFullInformation(book_founded, library);
		} else {
			System.out.println("The book with such parameters was not found!" + "\nPlease try again.");
			pm.printLongLine();
		} // end if - else
	}

	// ################################################
	// case 5, printing all books of one author #
	// ################################################
	public void printAllBooksByAuthor(String message) {

		pm.printTopMessage(message);
		int author_id = ga.getInt("Enter the author number: ");

		String listOfBooks = gloab.findBooks(author_id, library, authors);

		ploab.printListOfBooks(listOfBooks, author_id, library, authors);

	} // end case 5, printAllBooksByAuthor

	public void printMenu() {
		pm.printMenu();
	}

}
