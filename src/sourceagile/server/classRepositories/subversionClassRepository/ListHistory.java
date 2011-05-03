package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import sourceagile.server.classRepositories.subversionFileRepository.ListRepositoryHistory;
import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.project.Project;

public class ListHistory {

	public static ArrayList<Productivity> getRemoteClasses(Project project,
			User user) {

		ArrayList<Productivity> productivityArray = new ArrayList<Productivity>();

		JSONArray jsonArray = ListRepositoryHistory.getRemoteClasses(
				project.getRepositoryURL(), user.getName(), user.getPassword());

		for (int i = 0; i < jsonArray.length(); i++) {

			try {

				JSONObject jsonProductivityEntry = (JSONObject) jsonArray
						.get(i);

				Productivity productivity = convertJsonToProductivityEntry(jsonProductivityEntry);

				productivityArray.add(productivity);

			} catch (JSONException e) {

				e.printStackTrace();
			}

		}

		return productivityArray;
	}

	private static Productivity convertJsonToProductivityEntry(
			JSONObject jsonEntry) {

		Productivity productivity = new Productivity();

		try {

			productivity.setDate(new Date(jsonEntry
					.getLong(ListRepositoryHistory.TIME)));

			productivity.setClassesCount(jsonEntry
					.getInt(ListRepositoryHistory.TOTAL_FILES));

			productivity.setClassActivityCount(jsonEntry
					.getInt(ListRepositoryHistory.TOTAL_EFFORT));

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return productivity;

	}

}
