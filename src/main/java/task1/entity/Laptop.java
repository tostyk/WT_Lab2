package task1.entity;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


public class Laptop extends Appliance{
    double batteryCapacity;
    String cpu;
    double displayInches;
    int memoryROM;
    String os;
    int systemMemory;

    /**
     * Parameterless constructor
     */
    public Laptop() { }

    /**
     * Constructor
     * @param price appliance price
     * @param batteryCapacity appliance battery capacity
     * @param cpu appliance CPU
     * @param displayInches appliance display inches
     * @param memoryROM appliance memory ROM
     * @param os appliance OS
     * @param systemMemory appliance systemMemory
     */
    public Laptop(double price, double batteryCapacity, String cpu, double displayInches, int memoryROM, String os, int systemMemory) {
        super(price);
        this.batteryCapacity = batteryCapacity;
        this.cpu = cpu;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.os = os;
        this.systemMemory = systemMemory;
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
                case "batteryCapacity" -> batteryCapacity = Double.parseDouble(value);
                case "cpu" -> cpu = value;
                case "displayInches" -> displayInches = Double.parseDouble(value);
                case "memoryROM" -> memoryROM = Integer.parseInt(value);
                case "os" -> os = value;
                case "systemMemory" -> systemMemory = Integer.parseInt(value);
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
        element.setAttribute("batteryCapacity", String.valueOf(this.batteryCapacity));
        element.setAttribute("cpu", String.valueOf(this.cpu));
        element.setAttribute("displayInches", String.valueOf(this.displayInches));
        element.setAttribute("memoryROM", String.valueOf(this.memoryROM));
        element.setAttribute("os", String.valueOf(this.os));
        element.setAttribute("systemMemory", String.valueOf(this.systemMemory));
        return element;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public int getMemoryROM() {
        return memoryROM;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public String getCpu() {
        return cpu;
    }

    public String getOs() {
        return os;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public void setMemoryROM(int memoryROM) {
        this.memoryROM = memoryROM;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    @Override
    public String toString() {
        String string = "";
        string += this.getClass().getSimpleName() + ":\n" +
                "price: " + super.getPrice() + "\n" +
                "batteryCapacity: " + batteryCapacity + "\n" +
                "cpu: " + cpu + "\n" +
                "displayInches: " + displayInches + "\n" +
                "memoryROM: " + memoryROM + "\n" +
                "os: " + os + "\n" +
                "systemMemory: " + systemMemory + "\n";
        return string;
    }
}
