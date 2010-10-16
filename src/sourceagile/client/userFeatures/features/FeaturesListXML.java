package sourceagile.client.userFeatures.features;

import sourceagile.client.systemNavigation.Documentation;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.ClassFile;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Text;
import com.google.gwt.xml.client.XMLParser;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

public class FeaturesListXML {

	public FeaturesListXML(ClassFile[] entries) {

		Documentation.documentationPanel.clear();
		Documentation.documentationPanel
				.add(getSyntaxPanel(getFeaturesXML(entries)));
	}

	public String getFeaturesXML(ClassFile[] entries) {

		Document xmlDocument = XMLParser.createDocument();

		String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

		Element features = xmlDocument.createElement("features");
		features.setAttribute("project",
				ProjectInitialization.currentProject.getName());
		xmlDocument.appendChild(features);

		for (ClassFile entry : entries) {

			if (entry.getClassDoc().isFeature()) {

				Element feature = xmlDocument.createElement("feature");

				Element className = xmlDocument.createElement("className");
				Text classNameText = xmlDocument.createTextNode(entry
						.getClassDoc().getClassName());
				className.appendChild(classNameText);
				feature.appendChild(className);

				Element classPath = xmlDocument.createElement("classPath");
				Text classPathText = xmlDocument.createTextNode(entry
						.getClassDoc().getClassPackage());
				classPath.appendChild(classPathText);
				feature.appendChild(classPath);

				Element featureName = xmlDocument.createElement("featureName");
				Text featureNameText = xmlDocument.createTextNode(entry
						.getFeature().getFeatureName());
				featureName.appendChild(featureNameText);
				feature.appendChild(featureName);

				Element description = xmlDocument.createElement("description");
				Text descriptionText = xmlDocument.createTextNode(entry
						.getClassDoc().getDescription());
				description.appendChild(descriptionText);
				feature.appendChild(description);

				features.appendChild(feature);
			}
		}

		return xmlHeader + xmlDocument.toString();
	}

	private SyntaxHighlightPanel getSyntaxPanel(String xmlContent) {

		SyntaxHighlightPanel syntaxPanel = new SyntaxHighlightPanel(xmlContent,
				SyntaxHighlightPanel.SYNTAX_XML);

		syntaxPanel.setSize(700, 600);
		syntaxPanel.setTitle("Features List XML format");
		syntaxPanel.setAutoScroll(true);

		return syntaxPanel;
	}

}
