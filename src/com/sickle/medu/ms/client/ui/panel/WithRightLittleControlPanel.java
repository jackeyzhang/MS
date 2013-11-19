/**
 * 
 */
package com.sickle.medu.ms.client.ui.panel;

import com.sickle.medu.ms.client.ui.widget.BluelittleLabel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;


/**
 * @author chenhao
 *
 */
public class WithRightLittleControlPanel extends HLayout
{
	
	
	public WithRightLittleControlPanel(int height,int width){
		super();
		this.setWidth( width );
		this.setHeight( height );
		this.setAlign( Alignment.RIGHT );
	}
	
	public WithRightLittleControlPanel(int height){
		super();
		this.setWidth100( );
		this.setHeight( height );
		this.setAlign( Alignment.RIGHT );
	}
	
	public Canvas addControl(String title,int width){
		final HLayout h = new HLayout();
		h.setStyleName( "controlpanel" );
		h.setWidth( width );
		h.setAlign( Alignment.CENTER  );
		BluelittleLabel label = new BluelittleLabel(title,false);
		label.setWidth( width/3 );
		h.addMember( label );
		h.addMouseOverHandler( new MouseOverHandler( ) {
			
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				h.setStyleName( "controlpanel-mousein" );
			}
		} );
		
		h.addMouseOutHandler( new MouseOutHandler( ) {
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				h.setStyleName( "controlpanel" );
			}
		} );
		addMember( h );
		return h;
	}

}
