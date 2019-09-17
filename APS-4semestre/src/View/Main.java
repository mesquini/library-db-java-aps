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
		
		
		ArrayList<BooksAuthors> ok = c.searchBooksAuthors("teste");
		
		for(BooksAuthors ba : ok) {
			System.out.println(ba.title+ " " + ba.url +" "+ ba.price);
		}
		
		ArrayList<Authors> as = c.getAllAuthors();
		
		System.out.println(as.size());
		
		for(Authors a : as) {
			System.out.println("ID:"+ a.author_id + " Nome: " + a.name + " Sobrenome: " + a.fname);
		}

	}

}
