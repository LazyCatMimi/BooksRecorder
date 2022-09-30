

//BookProgramMain.java by QUYNH VO
import java.util.Scanner;
public class BookProgramMain {
	
	public static void main(String[] args) {
		System.out.print("Welcome to the book program!");
		
		String createBook;
		String bookMode;
		Scanner input = new Scanner(System.in);
		BookstoreBook bsBook[] = new BookstoreBook[100];
		LibraryBook lbBook[] = new LibraryBook[200];
		
		while (true) {			
			System.out.print("\nWould you like to create a book object? ");
			
			//create book object: loop until user gets it right
			while (true) {
				createBook = input.nextLine();	//get user input
				createBook = createBook.toLowerCase();		//lowercasefy user input
				if (createBook.equals("yes") || createBook.equals("no")) 
					break;
				else
					System.out.printf("I'm sorry but %s isn't a valid answer. Please enter either yes or no: ", createBook);
			}

			if (createBook.equals("no")) //exit loop if user does not want to create anymore
				break;
			

			
			//start to take book inputs
			System.out.print("Please enter the author, title, and the isbn of the book separated by /: ");
			String tempInput[] = input.nextLine().toUpperCase().split("/");

			
			System.out.println("Got it!");
			System.out.print("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book or LB for library book): ");
			
			//Book options: loop until user gets it right
			while (true) {
				bookMode = input.nextLine();	//get user input
				bookMode = bookMode.toUpperCase();	//uppercasefy user input
				if (bookMode.equals("BB") || bookMode.equals("LB"))
					break;
				else
					System.out.print("Oops! That's not a valid entry. Please try again: ");
			}
				
			System.out.println("Got it!");
			
			//2 book options
			if (bookMode.equals("BB")) {
				//create a new book object and pass values
				bsBook[BookstoreBook.amount] = new BookstoreBook(tempInput[0], tempInput[1], tempInput[2]);
				
				//take other values: price and sale
				System.out.printf("Please enter the list price of %s by %s: ", bsBook[BookstoreBook.amount].getTitle(), bsBook[BookstoreBook.amount].getAuthor()); 
				double price = input.nextDouble();
				input.nextLine();	
				bsBook[BookstoreBook.amount].setPrice(price);			
				bsBook[BookstoreBook.amount].setSale();
				System.out.println("Got it!");
				
				//display book info
				System.out.printf("%n%nHere is your bookstore book information%n");
				System.out.printf("%s", bsBook[BookstoreBook.amount].toString());
				
				BookstoreBook.increAmount();
			}
			
			else if (bookMode.equals("LB")) {
				//create a new book object and pass values
				lbBook[LibraryBook.amount] = new LibraryBook(tempInput[0], tempInput[1], tempInput[2]);
				
				//display book info
				System.out.printf("%n%nHere is your bookstore book information%n");
				System.out.printf("%s", lbBook[LibraryBook.amount].toString());
				LibraryBook.increAmount();
			}
			
			System.out.printf("%n%n");
		}
		
		//display info of all books and end
		System.out.println("Sure!");
		System.out.println("Here are all your books...");
		System.out.printf("Library Books (%d)%n", LibraryBook.amount);
		for(int i = 0; i < LibraryBook.amount; i++) {
			System.out.printf("\t%s%n", lbBook[i].toString());
		}
		System.out.println("----");
		System.out.printf("Bookstore Books (%d)%n", BookstoreBook.amount);
		for(int i = 0; i < BookstoreBook.amount; i++) {
			System.out.printf("\t%s%n", bsBook[i].toString());
		}
		
		System.out.println("----");
		System.out.println("Take care now!");

	}
	

}



