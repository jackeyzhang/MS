package com.sickle.medu.ms.client.ui.panel;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;


/**
 * 鼠标over时changestyle的panel
 * 
 * @author chenhao
 *
 */
public class MouseChangePanel extends HLayout
{

	private boolean mousechange = true;
	
	public MouseChangePanel(boolean withmousechange,final String outstylename,final String instylename)
	{
		super();
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
					if(mousechange)
					setStyleName( instylename );
				}
			} );

			this.addMouseOutHandler( new MouseOutHandler( ) {

				@Override
				public void onMouseOut( MouseOutEvent event )
				{
					if(mousechange)
					setStyleName( outstylename );
				}
			} );
		}
	}
	
	public MouseChangePanel(boolean withmousechange)
	{
		this(withmousechange,"mousechangepanel", "mousechangepanel_mousein");
	}
	
	public MouseChangePanel()
	{
		this(true);
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
	
	public void fixMouseinStyle()
	{
		if(mousechange)
		{
			this.setStyleName( "mousechangepanel_mousein" );
			mousechange = false;
		}
	}
	
	public void removeFixMouseinStyle()
	{
		if(!mousechange)
		{
			this.setStyleName( "mousechangepanel" );
			mousechange = true;
		}
	}
	
}
