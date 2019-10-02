package UTIL;

public final class Global {
	
	private Global() {};
	
	private static String title;
	private static String isbn;
	private static Double price;
	private static String valume;
	private static int editora;

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Global.title = title;
	}

	public static String getIsbn() {
		return isbn;
	}

	public static Double getPrice() {
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

	public static void setPrice(Double price) {
		Global.price = price;
	}

	public static void setValume(String valume) {
		Global.valume = valume;
	}

	public static void setEditora(int editora) {
		Global.editora = editora;
	}

}
