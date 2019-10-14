package UTIL;

import java.util.ArrayList;

import Model.Publishers;

public final class Global {

	private Global() {
	};

	private static boolean telaAlteracao;

	private static String title;
	private static String isbn;
	private static String price;
	private static String valume;

	private static String[] ObjIdBooks;
	private static String[] ObjNameAuthors;

	private static int[] objIdAuthors;
	private static int[] objIdAuthorsSelected;
	private static int[] ObjIdPublisher;

	private static int searchTelaInicial;
	private static int editora;

	private static ArrayList<String> isbnLts;
	private static ArrayList<Integer> IdPublisherLts;

	private static Publishers publisher;

	public static int[] getObjIdPublisher() {
		return ObjIdPublisher;
	}

	public static void setObjIdPublisher(int[] objIdPublisher) {
		ObjIdPublisher = objIdPublisher;
	}

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Global.title = title;
	}

	public static String getIsbn() {
		return isbn;
	}

	public static String getPrice() {
		return price;
	}

	public static String getValume() {
		return valume;
	}

	public static int getEditora() {
		return editora;
	}

	public static void setIsbn(String isbn) {
		Global.isbn = isbn;
	}

	public static void setPrice(String price) {
		Global.price = price;
	}

	public static void setValume(String valume) {
		Global.valume = valume;
	}

	public static void setEditora(int editora) {
		Global.editora = editora;
	}

	public static int[] getObjIdAuthors() {
		return objIdAuthors;
	}

	public static void setObjIdAuthors(int[] objIdAuthors) {
		Global.objIdAuthors = objIdAuthors;
	}

	public static boolean isTelaAlteracao() {
		return telaAlteracao;
	}

	public static void setTelaAlteracao(boolean telaAlteracao) {
		Global.telaAlteracao = telaAlteracao;
	}

	public static int getSearchTelaInicial() {
		return searchTelaInicial;
	}

	public static void setSearchTelaInicial(int searchTelaInicial) {
		Global.searchTelaInicial = searchTelaInicial;
	}

	public static ArrayList<String> getIsbnLts() {
		return isbnLts;
	}

	public static void setIsbnLts(ArrayList<String> isbnLts) {
		Global.isbnLts = isbnLts;
	}

	public static ArrayList<Integer> getIdPublisherLts() {
		return IdPublisherLts;
	}

	public static void setIdPublisherLts(ArrayList<Integer> idPublisherLts) {
		IdPublisherLts = idPublisherLts;
	}

	public static String[] getObjIdBooks() {
		return ObjIdBooks;
	}

	public static void setObjIdBooks(String[] objIdBooks) {
		ObjIdBooks = objIdBooks;
	}

	public static int[] getObjIdAuthorsSelected() {
		return objIdAuthorsSelected;
	}

	public static void setObjIdAuthorsSelected(int[] objIdAuthorsSelected) {
		Global.objIdAuthorsSelected = objIdAuthorsSelected;
	}

	public static Publishers getPublisher() {
		return publisher;
	}

	public static void setPublisher(Publishers publisher) {
		Global.publisher = publisher;
	}

	public static String[] getObjNameAuthors() {
		return ObjNameAuthors;
	}

	public static void setObjNameAuthors(String[] objNameAuthors) {
		ObjNameAuthors = objNameAuthors;
	}

	public static void limpaCampos() {
		Global.title = null;
		Global.isbn = null;
		Global.price = null;
		Global.valume = null;
		Global.editora = 0;
		Global.objIdAuthors = null;
		Global.ObjIdPublisher = null;
		Global.objIdAuthorsSelected = null;
		Global.ObjNameAuthors = null;
		Global.telaAlteracao = false;
		Global.publisher = null;
	}

}
