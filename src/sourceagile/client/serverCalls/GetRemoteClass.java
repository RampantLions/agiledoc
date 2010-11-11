package sourceagile.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClasses;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClassesAsync;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteClass {

	private final LoadSubversionRemoteClassesAsync remoteFunctions = GWT
			.create(LoadSubversionRemoteClasses.class);

	public GetRemoteClass(ClassFile classfile, final int viewOption) {

		Specification.featureVisualizationPanel.clear();
		Specification.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classfile,
				new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile entry) {

						updateProjectEntries(entry);

						new Specification(entry, viewOption);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}

	private void updateProjectEntries(ClassFile entry) {

		for (int i = 0; i < ProjectInitialization.projectEntries.length; i++) {

			ClassFile classFile = ProjectInitialization.projectEntries[i];

			if (entry.compareTo(classFile) == 0) {

				ProjectInitialization.projectEntries[i] = entry;

				break;
			}
		}
	}
}
