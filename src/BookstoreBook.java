//BookstoreBook.java by QUYNH VO

import java.util.Scanner;
public class BookstoreBook {
	
	private String author;
	private String title;
	private String isbn;
	private double price;
	private double sale;
	public static int amount = 0;

	Scanner input = new Scanner(System.in);
	
	//setters	
	public BookstoreBook(String author, String title, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.sale = 0;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSale() {
		System.out.print("Is it on sale? (y/n): ");
		String isOnSale;
		while (true) {
			isOnSale = input.nextLine();	//get user input
			isOnSale = isOnSale.toLowerCase();		//lowercasefy user input
			if (isOnSale.equals("y") || isOnSale.equals("n")) 
				break;
			else
				System.out.printf("I'm sorry but %s isn't a valid answer. Please enter either y or n: ", isOnSale);
		}
		
		if (isOnSale.equals("y"))
		{
			System.out.print("Deduction Percentage: "); 
			String saleInput = input.nextLine(); //take user input as string
			saleInput = saleInput.replaceAll("[^0-9.]", ""); //remove all characters that are not numbers
			this.sale = Float.parseFloat(saleInput); //convert string to float
			
		}
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
	public double getPrice() {
		return price;
	}
	public double getSale() {
		return sale;
	}

	
	public String toString() {
		
		return String.format("[%s-%s by %s, $%.2f listed for $%.2f]", this.isbn, this.title, this.author, this.price, this.price-this.price*(this.sale/100)); //need to put info: ISBN, title, author, [price - price*sale]
	}
	
}
