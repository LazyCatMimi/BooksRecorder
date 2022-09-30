//LibraryBook.java by QUYNH VO
import java.security.SecureRandom;
public class LibraryBook {
	private String author;
	private String title;
	private String isbn;
	private String callNum;
	public static int amount = 0;
	SecureRandom randomNumbers = new SecureRandom();
	
	public LibraryBook(String author, String title, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;

		//xx.yy.z randomly generated, author's first 3 letters, last  num of isbn
		int randNum = 1 + randomNumbers.nextInt(99);
		this.callNum = String.format("%02d.%s.%s", randNum, author.substring(0,3), isbn.substring(isbn.length()-1));
	}
	public static void increAmount() {
		amount++;
	}
		
	
	//getters
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public String getISBN() {
		return isbn;
	}
	public String getCallNum() {
		return callNum;
	}
	
	public String toString() {
		
		return String.format("[%s-%s by %s-%s]", this.isbn, this.title, this.author, this.callNum); //need to put info: ISBN, title, author, [price - price*sale]
	}
	

}