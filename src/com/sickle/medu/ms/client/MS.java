
package com.sickle.medu.ms.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

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
		IButton button = new IButton("ok");
		button.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick( ClickEvent event )
			{
				SC.say( "hello" );
			}
		} );
		
		button.draw( );
	}
}
