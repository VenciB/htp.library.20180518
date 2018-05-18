package by.htp.library.run;

import by.htp.library.entity.Library;

public class BookFinder {

	public int findBookByYearTitleAuthor(Library library, int book_year, String book_title, String author_last_name,
			String author_first_name, String author_otchestvo) {

		int book_founded = -1;
		search_for_book: for (int i = 0; i < library.getBooksCount(); i++) { // start outer for loop

			if (book_year == library.getBooks()[i].getYearOfPublishing()
					&& book_title.equals(library.getBooks()[i].getTitle())) {
				for (int j = 0; j < library.getBooks()[i].getAuthor().length; j++) { // start inner for loop
					if (author_last_name.equals(library.getBooks()[i].getAuthor()[j].getLastName())
							&& author_first_name.equals(library.getBooks()[i].getAuthor()[j].getFirstName())
							&& author_otchestvo.equals(library.getBooks()[i].getAuthor()[j].getOtchestvo())) {
						book_founded = i + 1;
						break search_for_book;
					}
				} // end inner for loop
			} // end if
		} // end outer for loop, end label search_for_book
		return book_founded;
	} // end method findBookByYearTitleAuthor

} // end class
