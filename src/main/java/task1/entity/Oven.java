package task1.entity;

import org.w3c.dom.*;

public class Oven extends Appliance{
    private int capacity;
    private double depth;
    private double height;
    private int powerConsumption;
    private double weight;
    private double width;

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + super.getPrice() + "\n" +
                "capacity: " + capacity + "\n" +
                "depth: " + depth + "\n" +
                "height: " + height + "\n" +
                "powerConsumption: " + powerConsumption + "\n" +
                "weight: " + weight + "\n" +
                "width: " + width + "\n";
        return string;
    }

    public Oven() { }

    public Oven(double price, int capacity, double depth, double height, int powerConsumption, double weight, double width) {
        super(price);
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.width = width;
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
                case "depth" -> depth = Double.parseDouble(value);
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
        element.setAttribute("capacity", String.valueOf(this.capacity));
        element.setAttribute("depth", String.valueOf(this.depth));
        element.setAttribute("height", String.valueOf(this.height));
        element.setAttribute("powerConsumption", String.valueOf(this.powerConsumption));
        element.setAttribute("weight", String.valueOf(this.weight));
        element.setAttribute("width", String.valueOf(this.width));
        return element;
    }

    public double getWeight() {
        return weight;
    }

    public double getDepth() {
        return depth;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
