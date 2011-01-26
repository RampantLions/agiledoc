package sourceagile.server.classRepositories;

import java.io.File;

import org.approvaltests.ApprovalFailureReporter;

import com.spun.util.io.FileUtils;

public class ViDiffReporter implements ApprovalFailureReporter {

	@Override
	public void report(String recieved, String approved) throws Exception {
		File a = new File(approved);
		if (!a.exists()) {

			FileUtils.writeFile(a, "");
		}
		String text = "/Applications/DiffMerge.app/Contents/MacOS/DiffMerge --nosplash  %s %s";
		text = String.format(text, new File(recieved).getAbsolutePath(),
				a.getAbsolutePath());
		Runtime.getRuntime().exec(text);
	}

}
