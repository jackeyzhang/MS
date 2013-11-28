/**
 * 
 */
package com.sickle.medu.ms.client.ui.widget;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;




/**
 * MEDU Button
 * 
 * default width: 50px
 * 
 * @author chenhao
 *
 */
public abstract class MButton extends MouseChangePanel
{

	private LabelWithWhite label = null;
	
	public MButton( String title)
	{
		this.setWidth( 50 );
		this.setHeight( 25 );
		label = new LabelWithWhite(title,true,"whitelittlelabel","whitelittlelabel");
		this.addMember( label );
		this.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick( ClickEvent event )
			{
				handleClick();				
			}
		} );
		
		label.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick( ClickEvent event )
			{
				handleClick();				
			}
		} );
	}
	
	public abstract void handleClick();
	

}
