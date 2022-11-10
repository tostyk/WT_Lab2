package task1.entity;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class TabletPC extends Appliance{
    int batteryCapacity;
    int displayInches;
    int memoryROM;
    int flashMemoryCapacity;

    public TabletPC() { }

    public TabletPC(double price, int batteryCapacity, int displayInches, int memoryROM, int flashMemoryCapacity) {
        super(price);
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
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
                case "batteryCapacity" -> batteryCapacity = Integer.parseInt(value);
                case "displayInches" -> displayInches = Integer.parseInt(value);
                case "memoryROM" -> memoryROM = Integer.parseInt(value);
                case "flashMemoryCapacity" -> flashMemoryCapacity = Integer.parseInt(value);
            }
        }
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + super.getPrice() + "\n" +
                "batteryCapacity: " + batteryCapacity + "\n" +
                "displayInches: " + displayInches + "\n" +
                "memoryROM: " + memoryROM + "\n" +
                "flashMemoryCapacity: " + flashMemoryCapacity + "\n";
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
        element.setAttribute("batteryCapacity", String.valueOf(this.batteryCapacity));
        element.setAttribute("displayInches", String.valueOf(this.displayInches));
        element.setAttribute("memoryROM", String.valueOf(this.memoryROM));
        element.setAttribute("flashMemoryCapacity", String.valueOf(this.flashMemoryCapacity));
        return element;
    }
}
