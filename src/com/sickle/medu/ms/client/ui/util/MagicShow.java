/**
 * 
 */
package com.sickle.medu.ms.client.ui.util;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;


/**
 * magic show:provide a group of magic function for canvas  
 * 
 * @author chenhao
 *
 */
public class MagicShow
{
	
	/**
	 * add mouseover highlight show for the canvas
	 * 
	 * @param canvas
	 */
	public static void addHighlightWhenMouseOver(final Canvas canvas)
	{
		canvas.setStyleName( "choosepanel" );
		canvas.addMouseOutHandler( new MouseOutHandler( ) {
			
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				canvas.setStyleName( "choosepanel" );
			}
		} );
		
		canvas.addMouseOverHandler( new MouseOverHandler( ) {
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				canvas.setStyleName( "choosepanel-mousein" );
			}
		} );
	}
}
