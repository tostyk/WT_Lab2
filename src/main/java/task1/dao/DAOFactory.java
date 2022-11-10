package task1.dao;

import task1.dao.impl.ApplianceDAOImpl;

/**
 * The class returns references to an object whose class implements {@link ApplianceDAO}.
 */
public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory() {}

	/**
	 * Gets the reference to an object that implements {@link ApplianceDAO}.
	 * @return an object whose class implements {@link ApplianceDAO}.
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	/**
	 * Gets a reference to an object {@link DAOFactory}.
	 * @return the instance of class {@link DAOFactory}.
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
}
