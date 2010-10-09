package sourceagile.client.serverConnection;

import sourceagile.client.SystemStart;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.specification.Specification;
import sourceagile.client.specification.classViewOptions.OptionsIcons;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteClass {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public GetRemoteClass(ClassFile entry, final int viewOption) {

		Specification.featureVisualizationPanel.clear();
		Specification.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, entry, new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile entry) {

						Specification.showClass(entry,
								OptionsIcons.OPTION_DESCRIPTION);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
