package com.agiledoc.client;

import com.agiledoc.shared.model.Classe;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GlobalVariables {

	// public static final String firstRoot =
	// "C:/eclipse/workspace/PALMS_Browser/src";
	// public static final String firstPackage = "org";

	private static String ROOT = "C:/eclipse-jee-galileo-SR2-win32 (1)/eclipse/workspace/AgileDoc/src";
	private static String PACK = "com.agiledoc";
	private static String INIT_CLASS = "com.agiledoc.client.view.main.InitSystem";

	private static Classe[] CLASSES_LIST;

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

	public static String getINIT_CLASS() {
		return INIT_CLASS;
	}

	public static void setINIT_CLASS(String iNITCLASS) {
		INIT_CLASS = iNITCLASS;
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

}
