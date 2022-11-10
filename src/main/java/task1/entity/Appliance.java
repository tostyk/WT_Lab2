package task1.entity;

import org.w3c.dom.*;

/**
 * Class represents the appliance.
 */
public class Appliance {
    private double price;

    /**
     * Parameterless constructor
     */
    public Appliance() {}

    /**
     * Constructor
     * @param price appliance price
     */
    public Appliance(double price) {
        this.price = price;
    }

    /**
     * Gets DOM element from appliance object
     * @param element changing DOM element
     * @return {@link Element}
     */
    public Element setAttributes(Element element) {
        element.setAttribute("price", String.valueOf(this.price));
        return element;
    }

    /**
     * Sets fields from {@link Node}
     * @param node DOM Node
     */
    public void setFromNode(Node node) {
        NamedNodeMap attr = node.getAttributes();
        String field;
        String value;
        for (int i = 0; i < attr.getLength(); i++) {
            field = attr.item(i).getNodeName();
            value = attr.item(i).getTextContent();
            switch (field) {
                case "price":
                    price = Double.parseDouble(value);
                    break;
            }
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + price;
        return string;
    }
}
