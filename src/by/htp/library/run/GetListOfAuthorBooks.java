package by.htp.library.run;

import by.htp.library.entity.Author;
import by.htp.library.entity.Library;

public class GetListOfAuthorBooks {

	public String findBooks(int author_id, Library library, Author[] authors) {
		int countNumberOfBooksOfOneAuthor = 0;
		StringBuilder sb = new StringBuilder();
		String listOfBooksForAuthor = "";

		get_list_of_authors_books: for (int i = 0; i < library.getBooks().length; i++) {
			if (author_id > authors.length) {
				break get_list_of_authors_books;
			}
			for (int j = 0; j < library.getBooks()[i].getAuthor().length; j++) {
				if (author_id == library.getBooks()[i].getAuthor()[j].getAuthor_id()) {
					sb.append(((i + 1) < 10 ? "     " : "    ") + (i + 1) + "      - ");
					sb.append(library.getBooks()[i].getTitle());
					sb.append("\n");
					countNumberOfBooksOfOneAuthor++;
				}
			}
		} // end for loop
		listOfBooksForAuthor = sb.toString();
		return listOfBooksForAuthor;
	}
}
