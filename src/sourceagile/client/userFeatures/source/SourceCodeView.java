package sourceagile.client.userFeatures.source;

import sourceagile.client.userFeatures.specification.classViewOptions.ClassVizualizationPanel;
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
public class SourceCodeView {

	public SourceCodeView(ClassFile entry) {

		ClassVizualizationPanel.featureContent.clear();

		ClassVizualizationPanel.featureContent.add(getSyntaxPanel(entry));

		ClassVizualizationPanel.featureContent
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		ClassVizualizationPanel.featureContent.add(new Label(" "));

		ClassVizualizationPanel.featureContent.add(buttonEdit(entry));

		ClassVizualizationPanel.featureContent
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	}

	public static SyntaxHighlightPanel getSyntaxPanel(ClassFile entry) {

		SyntaxHighlightPanel syntaxPanel = new SyntaxHighlightPanel(
				entry.getSourceCode(), SyntaxHighlightPanel.SYNTAX_JAVA);

		syntaxPanel.setSize(700, 600);
		syntaxPanel.setTitle(entry.getFileName());
		syntaxPanel.setAutoScroll(true);

		return syntaxPanel;
	}

	public static Button buttonEdit(final ClassFile entry) {

		Button button = new Button("Edit", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new SourceEditor(entry.getSourceCode());

			}
		});

		return button;
	}

}
