package com.sickle.medu.ms.client.ui.widget;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;


/**
 * 鼠标over时changestyle的label
 * 
 * @author chenhao
 *
 */
public class MouseChangeLabel extends Label
{

	private boolean mousechange = true;
	
	public MouseChangeLabel(String title,boolean withmousechange,final String outstylename,final String instylename)
	{
		super(title);
		mousechange = withmousechange;
		if( mousechange )
		{
			this.setCursor( Cursor.POINTER );
		}
		setStyleName( outstylename );
		setAlign( Alignment.CENTER ) ;
		if( mousechange )
		{
			this.addMouseOverHandler( new MouseOverHandler( ) {

				@Override
				public void onMouseOver( MouseOverEvent event )
				{
					setStyleName( instylename );
				}
			} );

			this.addMouseOutHandler( new MouseOutHandler( ) {

				@Override
				public void onMouseOut( MouseOutEvent event )
				{
					setStyleName( outstylename );
				}
			} );
		}
	}
	
	public MouseChangeLabel(String title,boolean withmousechange)
	{
		this(title,withmousechange,"greenlittlelabel", "greenlittlelabel-mousein");
	}
	
	public MouseChangeLabel(String title)
	{
		this(title, true ,"greenlittlelabel-mousein","greenlittlelabel");
	}

	
	/**
	 * @return the mousechange
	 */
	public boolean isMousechange( )
	{
		return mousechange;
	}

	
	/**
	 * @param mousechange the mousechange to set
	 */
	public void setMousechange( boolean mousechange )
	{
		this.mousechange = mousechange;
	}
	
}
