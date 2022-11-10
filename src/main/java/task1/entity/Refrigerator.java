package task1.entity;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Refrigerator extends Appliance{
    int freezerCapacity;
    double height;
    int overallCapacity;
    int powerConsumption;
    double weight;
    double width;

    public Refrigerator() { }

    public Refrigerator(double price, int freezerCapacity, int overallCapacity, double height, int powerConsumption, double weight, double width) {
        super(price);
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.width = width;
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + super.getPrice() + "\n" +
                "freezerCapacity: " + freezerCapacity + "\n" +
                "overallCapacity: " + overallCapacity + "\n" +
                "height: " + height + "\n" +
                "powerConsumption: " + powerConsumption + "\n" +
                "weight: " + weight + "\n" +
                "width: " + width + "\n";
        return string;
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
                case "freezerCapacity" -> freezerCapacity = Integer.parseInt(value);
                case "overallCapacity" -> overallCapacity = Integer.parseInt(value);
                case "height" -> height = Double.parseDouble(value);
                case "powerConsumption" -> powerConsumption = Integer.parseInt(value);
                case "weight" -> weight = Double.parseDouble(value);
                case "width" -> width = Double.parseDouble(value);
            }
        }
    }

    /**
     * Gets DOM element from appliance object
     * @param element changing DOM element
     * @return {@link Element}
     */
    @Override
    public Element setAttributes(Element element) {
        element = super.setAttributes(element);
        element.setAttribute("capacity", String.valueOf(this.freezerCapacity));
        element.setAttribute("depth", String.valueOf(this.overallCapacity));
        element.setAttribute("height", String.valueOf(this.height));
        element.setAttribute("powerConsumption", String.valueOf(this.powerConsumption));
        element.setAttribute("weight", String.valueOf(this.weight));
        element.setAttribute("width", String.valueOf(this.width));
        return element;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public int getOverallCapacity() {
        return overallCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public void setOverallCapacity(int overallCapacity) {
        this.overallCapacity = overallCapacity;
    }
}