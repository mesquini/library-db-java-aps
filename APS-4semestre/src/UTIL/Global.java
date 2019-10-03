package UTIL;

public final class Global {

	private Global() {
	};

	private static String title;
	private static String isbn;
	private static String price;
	private static String valume;
	private static int editora;
	private static int[] objIdAuthors;
	private static int[] ObjIdPublisher;
	private static boolean telaAlteracao;

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

	public static void limpaCampos() {
		Global.title = null;
		Global.isbn = null;
		Global.price = null;
		Global.valume = null;
		Global.editora = 0;
		Global.objIdAuthors = null;
		Global.ObjIdPublisher = null;
		Global.telaAlteracao = false;
	}

}
