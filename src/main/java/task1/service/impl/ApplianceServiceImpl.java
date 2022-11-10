package task1.service.impl;

import task1.dao.ApplianceDAO;
import task1.dao.DAOFactory;
import task1.dao.DAOException;
import task1.entity.Appliance;
import task1.service.ApplianceService;
import task1.service.ServiceException;
import task1.service.validation.Validator;

import java.util.ArrayList;

/**
 * Implementation of the {@link ApplianceService} interface.
 */
public class ApplianceServiceImpl implements ApplianceService{

	/**
	 * Finds all appliances of the selected type with selected sorting order
	 * @param type Appliance type to search
	 * @param cheapFirst Sort order
	 * @return the list of appliance corresponding to this type and sorted
	 * @throws ServiceException Exception of the service layer
	 */
	@Override
	public ArrayList<Appliance> findByType(String type, boolean cheapFirst) throws ServiceException {
		if (!Validator.CheckType(type)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		ArrayList<Appliance> appliances;
		try {
			appliances = applianceDAO.findByType(type, cheapFirst);
		}
		catch (DAOException e) {
			throw new ServiceException();
		}
		return appliances;
	}
}
