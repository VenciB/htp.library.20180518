package by.htp.library.run;

import by.htp.library.entity.Author;

public class FormatAuthorName {

	public String getIDandFIO(int author_id, Author[] authors) {
		String idAndFIO = author_id + " (" + authors[author_id - 1].getLastName() + " "
				+ authors[author_id - 1].getFirstName() + " " + authors[author_id - 1].getOtchestvo() + ")";
		return idAndFIO;

	}

}
