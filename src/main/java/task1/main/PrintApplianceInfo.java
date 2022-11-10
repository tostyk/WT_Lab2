package task1.main;

import task1.entity.Appliance;

import java.util.ArrayList;

/**
 * Prints appliance information
 */
public class PrintApplianceInfo {

	/**
	 * Prints appliances information
	 * @param appliances the list of appliance
	 */
	public static void print(ArrayList<Appliance> appliances) {
		for (Appliance appliance : appliances) {
			System.out.println(appliance);
		}
	}

	/**
	 * Prints appliance information
	 * @param appliance appliance
	 */
	public static void print(Appliance appliance) {
		System.out.println(appliance);
	}
}
