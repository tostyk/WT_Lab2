package task1.entity;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Teapot extends Appliance {
    private int capacity;
    private int height;
    private int powerConsumption;

    public Teapot() { }

    public Teapot(double price, int capacity, int height, int powerConsumption) {
        super(price);
        this.capacity = capacity;
        this.height = height;
        this.powerConsumption = powerConsumption;
    }

    /**
     * Sets fields from {@link Node}
     * @param node DOM Node
     */
    @Override
    public void setFromNode(Node node) {
        super.setFromNode(node);
        NamedNodeMap attr = node.getAttributes();
        String field;
        String value;
        for (int i = 0; i < attr.getLength(); i++) {
            field = attr.item(i).getNodeName();
            value = attr.item(i).getTextContent();
            switch (field) {
                case "capacity" -> capacity = Integer.parseInt(value);
                case "height" -> height = Integer.parseInt(value);
                case "powerConsumption" -> powerConsumption = Integer.parseInt(value);
            }
        }
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + super.getPrice() + "\n" +
                "capacity: " + capacity + "\n" +
                "height: " + height + "\n" +
                "powerConsumption: " + powerConsumption + "\n";
        return string;
    }

    /**
     * Gets DOM element from appliance object
     * @param element changing DOM element
     * @return {@link Element}
     */
    @Override
    public Element setAttributes(Element element) {
        element = super.setAttributes(element);
        element.setAttribute("capacity", String.valueOf(this.capacity));
        element.setAttribute("height", String.valueOf(this.height));
        element.setAttribute("powerConsumption", String.valueOf(this.powerConsumption));
        return element;
    }
}
