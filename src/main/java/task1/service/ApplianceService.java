package task1.service;

import task1.entity.Appliance;
import java.util.ArrayList;

/**
 * Interface for getting appliances corresponding to type and sorted.
 */
public interface ApplianceService {
	/**
	 * Finds all appliances of the selected type with selected sorting order
	 * @param type Appliance type to search
	 * @param cheapFirst Sort order
	 * @return the list of appliance corresponding to this type and sorted
	 * @throws ServiceException Exception of the service layer
	 */
	ArrayList<Appliance> findByType(String type, boolean cheapFirst) throws ServiceException;
	
}
