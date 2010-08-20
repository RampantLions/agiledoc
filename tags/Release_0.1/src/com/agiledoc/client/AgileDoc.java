package com.agiledoc.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @author allineo
 * @modified 04/14/2010
 */
public class AgileDoc implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		InitSystem.init();
	}
}
