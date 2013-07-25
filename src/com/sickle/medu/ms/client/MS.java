
package com.sickle.medu.ms.client;

import com.google.gwt.core.client.EntryPoint;
import com.sickle.medu.ms.client.ui.dialog.LoginDialog;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MS implements EntryPoint
{


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad( )
	{
		new LoginDialog().show( );
	}
}
