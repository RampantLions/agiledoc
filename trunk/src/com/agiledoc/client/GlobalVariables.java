package com.agiledoc.client;

import java.util.ArrayList;

import com.agiledoc.client.view.performance.Performance;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GlobalVariables {

	// public static final String firstRoot =
	// "C:/eclipse/workspace/PALMS_Browser/src";
	// public static final String firstPackage = "org";

	public static final String INIT_CLASS = "com.agiledoc.client.view.main.InitSystem";

	private static String ROOT = "C:/eclipse2/workspace/AgileDoc/src";
	private static String PACK = "com.agiledoc";

	private static Classe[] CLASSES_LIST;

	private static ArrayList<Performance> progressivePerformance;
	private static Performance cumulativePerformance;

	private static VerticalPanel VP_BODY = new VerticalPanel();

	public static String getROOT() {
		return ROOT;
	}

	public static void setROOT(String rOOT) {
		ROOT = rOOT;
	}

	public static String getPACK() {
		return PACK;
	}

	public static void setPACK(String pACK) {
		PACK = pACK;
	}

	public static Classe[] getCLASSES_LIST() {
		return CLASSES_LIST;
	}

	public static void setCLASSES_LIST(Classe[] cLASSESLIST) {
		CLASSES_LIST = cLASSESLIST;
	}

	public static VerticalPanel getVP_BODY() {
		return VP_BODY;
	}

	public static void setVP_BODY(Widget w) {
		VP_BODY.clear();
		VP_BODY.add(w);
	}

	public static ArrayList<Performance> getProgressivePerformance() {
		return progressivePerformance;
	}

	public static void setProgressivePerformance(
			ArrayList<Performance> progressivePerformance) {
		GlobalVariables.progressivePerformance = progressivePerformance;
	}

	public static Performance getCumulativePerformance() {
		return cumulativePerformance;
	}

	public static void setCumulativePerformance(
			Performance cumulativePerformance) {
		GlobalVariables.cumulativePerformance = cumulativePerformance;
	}

}
