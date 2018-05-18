package by.htp.library.run;

import by.htp.library.entity.Author;
import by.htp.library.entity.Library;

public class PrintListOfAuthorBooks {

	private PrintMessage pm;
	private FormatAuthorName fan;

	public PrintListOfAuthorBooks() {
		pm = new PrintMessage();
		fan = new FormatAuthorName();
	}

	public void printListOfBooks(String listOfBooks, int author_id, Library library, Author[] authors) {
		if (listOfBooks.length() > 0) {
			System.out.println("The list of books of author " + fan.getIDandFIO(author_id, authors));
			pm.printTopMessage("Book number - Book title");
			System.out.println(listOfBooks);
		} else if (author_id > authors.length) {
			System.out.println("You entered incorrect author's number!" + "\nPlease try again.");
		} else if (listOfBooks.length() == 0) {
			System.out.println("No books of author " + fan.getIDandFIO(author_id, authors));
		} // end if else
	}

}
