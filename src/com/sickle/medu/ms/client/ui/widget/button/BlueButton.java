/**
 * 
 */
package com.sickle.medu.ms.client.ui.widget.button;

import com.sickle.medu.ms.client.ui.panel.MouseChangePanel;
import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;




/**
 * MEDU Button
 * 
 * default width: 50px height:25px
 * default style: 白底蓝字 over时变蓝底白字
 * 
 * @author chenhao
 *
 */
public abstract class BlueButton extends MouseChangePanel
{

	private LabelWithWhite label = null;
	
	
	public BlueButton( String title,String width)
	{
		this.setWidth( width );
		this.setHeight( 25 );
		
		label = new LabelWithWhite(title,true,"whitelittlelabel","whitelittlelabel");
		label.setWidth( width );
		this.addMember( label );
		
		label.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick( ClickEvent event )
			{
				handleClick();				
			}
		} );
	}
	
	public BlueButton( String title)
	{
		this(title,"100px");
	}
	
	public abstract void handleClick();
	

}
