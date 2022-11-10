package task1.service;

import task1.service.impl.ApplianceServiceImpl;

/**
 * The class returns references to an object whose class implements {@link ApplianceService}.
 */
public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();
	
	private ServiceFactory() {}

	/**
	 * Gets the reference to an object that implements {@link ApplianceService}.
	 * @return an object whose class implements {@link ApplianceService}.
	 */
	public ApplianceService getApplianceService() {
		return applianceService;
	}

	/**
	 * Gets a reference to an object {@link ServiceFactory}.
	 * @return the instance of class {@link ServiceFactory}.
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}

}
