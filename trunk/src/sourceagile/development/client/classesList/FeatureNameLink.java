package sourceagile.development.client.classesList;

import sourceagile.development.client.FilesViewList;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class FeatureNameLink extends TreeNode {

	public FeatureNameLink(final ClassFile entry) {

		String className = entry.getFileName();
		if (entry.getFeature() != null) {
			className = entry.getFeature().getFeatureName();
		}

		if (entry.getClassDoc() != null
				&& entry.getClassDoc().getClassStatus() != null) {

			className += " <font color='red' size=1>*</font>";
		}

		this.setText(className);

		this.setIcon("js/ext/resources/images/default/tree/world.gif");

		this.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				FilesViewList.showClass(entry, OptionsIcons.OPTION_DESCRIPTION);
			}
		});
	}
}
