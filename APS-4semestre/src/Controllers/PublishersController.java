package Controllers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.PublishersDAO;
import Model.Publishers;

public class PublishersController {
	
	static ArrayList<Publishers> publishers;
	static PublishersDAO publishersDAO = new PublishersDAO();

	public DefaultTableModel createTablePublisher(DefaultTableModel modelo, String name) {
		modelo.setNumRows(0);

		publishers = new ArrayList<Publishers>();

		publishers = name != " " ? publishersDAO.searchPublisher(name) : publishersDAO.getAllPublishers();

		for (Publishers a : publishers) {
			modelo.addRow(new Object[] { a.getPublisher_id(), a.getName(), a.getUrl() });
		}

		return modelo;

	}

}
