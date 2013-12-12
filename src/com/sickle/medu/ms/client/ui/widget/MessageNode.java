/**
 * 
 */
package com.sickle.medu.ms.client.ui.widget;

import com.sickle.medu.ms.client.ui.widget.label.LabelWithBlue;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * message node
 * 
 * @author chenhao
 *
 */
public class MessageNode extends HLayout
{

	private VLayout LeftArrow = new VLayout();
	
	private VLayout content = new VLayout();
	
	public MessageNode(String contentstr)
	{
		
		VLayout warp = new VLayout();
		warp.setAutoWidth( );
		warp.setHeight100( );
		warp.setAlign( VerticalAlignment.CENTER );
		
		LeftArrow.setSize( "10px", "10px" );
		LeftArrow.setStyleName( "messagenode-leftarrow" );
		warp.addMember( LeftArrow );
		
		content.setStyleName( "messagenode-content" );
		content.addMember( new LabelWithBlue( contentstr ) );
		
		addMember( warp );
		addMember( content );
	}
	
}
