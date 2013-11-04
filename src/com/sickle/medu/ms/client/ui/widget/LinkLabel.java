/**
 * 
 */

package com.sickle.medu.ms.client.ui.widget;

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;

/**
 * @author chenhao
 * 
 */
public class LinkLabel extends Label
{

	public LinkLabel( String title )
	{
		super( title );
		setStyleName( "linklabel" );
		this.addMouseOverHandler( new MouseOverHandler( ) {

			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				setStyleName( "linklabel-mousein" );
			}
		} );

		this.addMouseOutHandler( new MouseOutHandler( ) {

			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				setStyleName( "linklabel" );
			}
		} );
	}
}
