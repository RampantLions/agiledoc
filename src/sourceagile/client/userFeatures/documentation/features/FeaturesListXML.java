package sourceagile.client.userFeatures.documentation.features;

import sourceagile.client.userFeatures.documentation.Documentation;
import sourceagile.client.userFeatures.documentation.ExportXML;
import sourceagile.shared.ClassFile;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;

public class FeaturesListXML {

	public FeaturesListXML(ClassFile[] entries) {

		Documentation.documentationPanel.clear();
		Documentation.documentationPanel.add(ExportXML.getSyntaxPanel(
				getFeaturesXML(entries), "Features List XML format"));
	}

	public String getFeaturesXML(ClassFile[] entries) {

		Document xmlDocument = XMLParser.createDocument();

		Element featuresElement = ExportXML.getFeaturesElement(xmlDocument);
		xmlDocument.appendChild(featuresElement);

		for (ClassFile entry : entries) {

			if (entry.getClassDoc().isFeature()) {

				Element feature = xmlDocument.createElement(ExportXML.FEATURE);

				feature.appendChild(ExportXML.getElement(xmlDocument,
						ExportXML.CLASS_NAME, entry.getClassDoc()
								.getClassName()));

				feature.appendChild(ExportXML.getElement(xmlDocument,
						ExportXML.CLASS_PATH, entry.getClassDoc()
								.getClassPackage()));

				feature.appendChild(ExportXML.getElement(xmlDocument,
						ExportXML.FEATURE_NAME, entry.getFeature()
								.getFeatureName()));

				feature.appendChild(ExportXML.getElement(xmlDocument,
						ExportXML.DESCRIPTION, entry.getClassDoc()
								.getDescription()));

				featuresElement.appendChild(feature);
			}
		}

		return ExportXML.xmlHeader + xmlDocument.toString();
	}

}
