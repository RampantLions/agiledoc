package sourceagile.client.specification.classViewOptions;

import sourceagile.shared.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

/**
 * Show the source code of the class with the syntax highlighted.
 * 
 * @feature
 */
public class ClassSource {

	public ClassSource(ClassFile entry) {

		FeatureContentPanel.featureContent.clear();

		FeatureContentPanel.featureContent.add(getSyntaxPanel(entry));

		FeatureContentPanel.featureContent
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		FeatureContentPanel.featureContent.add(new Label(" "));

		FeatureContentPanel.featureContent.add(buttonEdit(entry));

		FeatureContentPanel.featureContent
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	}

	public static SyntaxHighlightPanel getSyntaxPanel(ClassFile entry) {

		SyntaxHighlightPanel syntaxPanel = new SyntaxHighlightPanel(
				entry.getTextContent(), SyntaxHighlightPanel.SYNTAX_JAVA);

		syntaxPanel.setSize(700, 600);
		syntaxPanel.setTitle(entry.getClassName());
		syntaxPanel.setAutoScroll(true);

		return syntaxPanel;
	}

	public static Button buttonEdit(final ClassFile entry) {

		Button button = new Button("Edit", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new SourceEditor(entry.getTextContent());

			}
		});

		return button;
	}

}
