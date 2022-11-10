package task1.dao;

import task1.entity.Appliance;

import java.util.ArrayList;
/**
 * An interface for getting appliance by certain criteria from data source.
 */
public interface ApplianceDAO {
	/**
	 * Finds all appliances of the selected type with selected sorting order
	 * @param type Appliance type to search
	 * @param cheapFirst Sort order
	 * @return the list of appliance corresponding to this type and sorted
	 * @throws DAOException Exception of the dao layer
	 */
	ArrayList<Appliance> findByType(String type, boolean cheapFirst) throws DAOException;

	/**
	 * Adds items to the database
	 * @param appliance Added element
	 * @throws DAOException Exception of the dao layer
	 */
	void add(Appliance appliance) throws DAOException;
}
