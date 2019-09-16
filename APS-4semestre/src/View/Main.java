package View;

import java.util.ArrayList;

import DTO.Authors;
import UTIL.*;

public class Main {

	public static void main(String[] args) {
		Commands c = new Commands();
		
		//c.addAuthor("teste", "mesquini");
		Authors author = c.searchAuthor("teste");
		
		System.out.println(author.name);
		
		c.deleteAuthor(1);
		
		c.updateAuthor(1, "qqq", "isso");
		
		ArrayList<Authors> as = c.getAllAuthors();
		
		System.out.println(as.size());
		
		for(Authors a : as) {
			System.out.println("ID:"+ a.author_id + " Nome: " + a.name + " Sobrenome: " + a.fname);
		}

	}

}
