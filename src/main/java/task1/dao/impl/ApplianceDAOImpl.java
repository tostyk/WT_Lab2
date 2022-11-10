package task1.dao.impl;

import task1.dao.ApplianceDAO;
import task1.dao.DAOException;
import task1.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Implementation of the {@link ApplianceDAO} interface for an XML file.
 */
public class ApplianceDAOImpl implements ApplianceDAO{

	String dbFile = "./src/main/resources/appliances_db.xml";

	/**
	 * Getting information about appliances from an XML file
	 * @param filename XML file
	 * @param type Type of
	 * @return type of received appliances from an XML file
	 * @throws DAOException Exception of the dao layer
	 */
	private ArrayList<Appliance> getApplianceList(String filename, String type) throws DAOException {
		ArrayList<Appliance> appliances = new ArrayList<>();

		try {
			String packagePath = Appliance.class.getPackageName();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filename);
			NodeList nodeList;
			if (Objects.equals(type, "Appliance")) {
				nodeList = document.getDocumentElement().getChildNodes();
			}
			else {
				nodeList = document.getDocumentElement().getElementsByTagName(type);
			}
			for (int i = 0; i < nodeList.getLength(); i++) {
				try {
					Appliance appliance = (Appliance) Class.forName(packagePath + '.' + nodeList.item(i).getNodeName()).getDeclaredConstructor().newInstance();
					appliance.setFromNode(nodeList.item(i));
					appliances.add(appliance);
				} catch (Exception ignored) { }
			}
		}
		catch (Exception e) {
			throw new DAOException();
		}
		return appliances;
	}

	/**
	 * Recording information about appliances to an XML file
	 * @param appliances The list of appliances
	 * @param filename XML file
	 * @throws DAOException Exception of the dao layer
	 */
	private void writeApplianceList(ArrayList<Appliance> appliances, String filename) throws DAOException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element rootElement = document.createElement(Appliance.class.getSimpleName());
			for (Appliance appliance : appliances) {
				Element element = document.createElement(appliance.getClass().getSimpleName());
				rootElement.appendChild(appliance.setAttributes(element));
			}
			document.appendChild(rootElement);
			DOMSource source = new DOMSource(document);
			FileWriter writer = new FileWriter(dbFile);
			StreamResult result = new StreamResult(writer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
		} catch (Exception e) {
			throw new DAOException();
		}
	}

	/**
	 * Finds all appliances of the selected type with selected sorting order from the XML file
	 * @param type Appliance type to search
	 * @param cheapFirst Sort order
	 * @return the list of appliances corresponding to this type and sorted
	 * @throws DAOException Exception of the dao layer
	 */
	@Override
	public ArrayList<Appliance> findByType(String type, boolean cheapFirst) throws DAOException {
		ArrayList<Appliance> appliances = getApplianceList(dbFile, type);
		if (cheapFirst) {
			appliances.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
		}
		else {
			appliances.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
		}
		return appliances;
	}

	/**
	 * Adds items to the XML file
	 * @param appliance Added element
	 * @throws DAOException Exception of the dao layer
	 */
	@Override
	public void add(Appliance appliance) throws DAOException {
		ArrayList<Appliance> applianceList = getApplianceList(dbFile, "Appliance");
		applianceList.add(appliance);
		writeApplianceList(applianceList, dbFile);
	}
}
