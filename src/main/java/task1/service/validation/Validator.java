package task1.service.validation;

/**
 * Validator for checking the entered data.
 */
public class Validator {
    /**
     * Check type of appliance
     * @param type type if appliance
     * @return true if type is correct, false if type is incorrect
     */
    public static boolean CheckType(String type) {
        return switch (type) {
            case "Appliance", "Laptop", "Oven", "Refrigerator", "Speakers", "TabletPC", "Teapot" -> true;
            default -> false;
        };
    }
}
