package task1.main;

import task1.entity.Appliance;
import task1.entity.Teapot;
import task1.service.ApplianceService;
import task1.service.ServiceException;
import task1.service.ServiceFactory;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		ArrayList<Appliance> appliances;

		try {
			appliances = service.findByType(Teapot.class.getSimpleName(), false);
			System.out.println("-----Teapots:-----\n");
			PrintApplianceInfo.print(appliances);
		}
		catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

		try {
			appliances = service.findByType(Appliance.class.getSimpleName(), true);
			if (appliances.size() > 0) {
				System.out.println("-----The cheapest product:-----\n");
				PrintApplianceInfo.print(appliances.get(0));
			}
		}
		catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}
