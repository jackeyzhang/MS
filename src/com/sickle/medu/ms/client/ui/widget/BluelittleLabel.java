/**
 * 
 */

package com.sickle.medu.ms.client.ui.widget;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;

/**
 * @author chenhao
 * 
 */
public class BluelittleLabel extends Label
{
	private boolean changeui = true;
	public BluelittleLabel( String title ,boolean _changeui)
	{
		super( title );
		this.changeui = _changeui;
		this.setCursor( Cursor.HAND );
		setStyleName( "greenlittlelabel" );
		this.addMouseOverHandler( new MouseOverHandler( ) {

			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				if( changeui == false)
				{
					return;
				}
				setStyleName( "greenlittlelabel-mousein" );
			}
		} );

		this.addMouseOutHandler( new MouseOutHandler( ) {

			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				if( changeui == false)
				{
					return;
				}
				setStyleName( "greenlittlelabel" );
			}
		} );
	}
	
	public BluelittleLabel( String title )
	{
		this( title, true);
	}
}
