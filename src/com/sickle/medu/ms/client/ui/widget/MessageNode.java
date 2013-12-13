/**
 * 
 */

package com.sickle.medu.ms.client.ui.widget;

import com.sickle.medu.ms.client.ui.widget.label.LabelWithBlue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * message node
 * 
 * 带实心三角箭头的panel 
 * 1 支持四个方向箭头展示 
 * 2 支持style定制：style分content和箭头两部分设置
 * 
 * @author chenhao
 * 
 */
public class MessageNode extends Layout
{

	public final static int D_LEFT = 1, D_RIGHT = 2, D_TOP = 3, D_BOTTOM = 4;

	private Layout wholepanel;

	private VLayout arrow = new VLayout( );

	private VLayout content = new VLayout( );
	
	public MessageNode(String contentstr,int direction,String contentstyle,String arrowstyle)
	{

		if ( direction == D_LEFT || direction == D_RIGHT )
		{
			wholepanel = new HLayout( );
		}
		else
		{
			wholepanel = new VLayout( );
		}

		Layout warp = null;
		if(  direction == D_LEFT || direction == D_RIGHT  )
		{
			warp = new VLayout( );
			warp.setAutoWidth( );
			warp.setHeight100( );
			warp.setAlign( VerticalAlignment.CENTER );
		}
		else
		{
			warp = new HLayout( );
			warp.setWidth100( );
			warp.setAutoHeight( );
			warp.setAlign( Alignment.CENTER );
		}
		

		content.setStyleName( contentstyle );
		content.addMember( new LabelWithBlue( contentstr ) );
		
		arrow.setSize( "10px", "10px" );
		warp.addMember( arrow );
		if ( direction == D_LEFT )
		{
			arrow.setStyleName( arrowstyle );
			wholepanel.addMember( warp );
			wholepanel.addMember( content );
		}
		else if ( direction == D_RIGHT )
		{
			arrow.setStyleName( arrowstyle );
			wholepanel.addMember( content );
			wholepanel.addMember( warp );
		}
		else if ( direction == D_TOP )
		{
			arrow.setStyleName( arrowstyle );
			wholepanel.addMember( warp );
			wholepanel.addMember( content );
		}
		else if ( direction == D_BOTTOM )
		{
			arrow.setStyleName( arrowstyle );
			wholepanel.addMember( content );
			wholepanel.addMember( warp );
		}

		addMember( wholepanel );
	
	}

	public MessageNode( String contentstr, int direction )
	{
		this( contentstr,direction,"messagenode-content","messagenode-leftrightarrow");
		if ( direction == D_LEFT )
		{
			arrow.setStyleName( "messagenode-leftrightarrow" );
		}
		else if ( direction == D_RIGHT )
		{
			arrow.setStyleName( "messagenode-rightarrow" );
		}
		else if ( direction == D_TOP )
		{
			arrow.setStyleName( "messagenode-toparrow" );
		}
		else if ( direction == D_BOTTOM )
		{
			arrow.setStyleName( "messagenode-bottomarrow" );
		}
	}

}
