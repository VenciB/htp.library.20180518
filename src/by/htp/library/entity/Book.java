package by.htp.library.entity;

public class Book {

	private int yearOfPublishing;
	private String title;
	private int book_id;
	private Author[] authors;

	public Book(int yearOfPublishing, String title, int book_id, Author... listofauthors) {
		this.yearOfPublishing = yearOfPublishing;
		this.title = title;
		this.book_id = book_id;
		this.authors = createAuthorsArray(listofauthors);

	}

	private Author[] createAuthorsArray(Author... listofauthors) {
		if (listofauthors.length == 0) {
			authors = new Author[1];
			authors[0] = new Author();
		} else {
			authors = new Author[listofauthors.length];
			for (int i = 0; i < listofauthors.length; i++) {
				authors[i] = listofauthors[i];
			} // end for loop
		} // end if - else
		return authors;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public String getTitle() {
		return title;
	}

	public Author[] getAuthor() {
		return authors;
	}

	public int getBook_id() {
		return book_id;
	}

}
