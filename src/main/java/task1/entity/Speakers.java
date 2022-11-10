package task1.entity;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Speakers extends Appliance{
    int powerConsumption;
    int numberOfSpeakers;
    String frequencyRange;
    int cordLength;

    public Speakers() { }

    public Speakers(double price, int powerConsumption, int numberOfSpeakers, String frequencyRange, int cordLength) {
        super(price);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
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
                case "powerConsumption" -> powerConsumption = Integer.parseInt(value);
                case "numberOfSpeakers" -> numberOfSpeakers = Integer.parseInt(value);
                case "frequencyRange" -> frequencyRange = value;
                case "cordLength" -> cordLength = Integer.parseInt(value);
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
        element.setAttribute("powerConsumption", String.valueOf(this.powerConsumption));
        element.setAttribute("numberOfSpeakers", String.valueOf(this.numberOfSpeakers));
        element.setAttribute("frequencyRange", String.valueOf(this.frequencyRange));
        element.setAttribute("cordLength", String.valueOf(this.cordLength));
        return element;
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + super.getPrice() + "\n" +
                "powerConsumption: " + powerConsumption + "\n" +
                "numberOfSpeakers: " + numberOfSpeakers + "\n" +
                "frequencyRange: " + frequencyRange + "\n" +
                "cordLength: " + cordLength + "\n";
        return string;
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public int getCordLength() {
        return cordLength;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }
}
