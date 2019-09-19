package View;

import java.util.ArrayList;

import DTO.Authors;
import DTO.BooksAuthors;
import UTIL.*;

public class Main {

	public static void main(String[] args) {
		Commands c = new Commands();
		
		/*c.addAuthor("teste", "mesquini");
		c.addPublisher("editora", "url");
		c.addBook("aa" ,1, "java", 8.20);*/
		//c.addBookAuthors(2, "aa", 1);
		
		
		ArrayList<BooksAuthors> ok = c.searchBooksAuthors("ge");
		
		System.out.println(ok.size());
		for(BooksAuthors ba : ok) {

			

			System.out.println("TITLE: "+ba.title+ " |AUTHORS: " + ba.name +" |PRICE: "+ ba.price);
		}
		
		

	}

}
