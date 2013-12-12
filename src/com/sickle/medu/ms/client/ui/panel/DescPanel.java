/**
 * 
 */

package com.sickle.medu.ms.client.ui.panel;

import com.sickle.medu.ms.client.ui.widget.label.LabelWithWhite;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 带描述框的panel
 * 
 * 黑底白字的title + 蓝底白字的panel
 * 
 * @author chenhao
 * 
 */
public class DescPanel extends VLayout
{

	private HLayout toppanel = new HLayout();
	
	private HLayout middlepanel = new HLayout();
	
	public DescPanel(String width, String height,String title)
	{
		setWidth( width );
		setHeight( height  );
		
		toppanel.setHeight( 25 );
		toppanel.setAlign( Alignment.CENTER );
		toppanel.setStyleName( "descpanel-toppanel" );
		
		middlepanel.setHeight100( );
		middlepanel.setStyleName( "descpanel-middlepanel" );
		middlepanel.setAlign( Alignment.CENTER );
		
		toppanel.addMember( new LabelWithWhite( title ) );
		
		setStyleName( "descpanel" );
		setMembersMargin( 1 );
		addMember( toppanel );
		addMember( middlepanel );
	}

	
	/**
	 * @return the toppanel
	 */
	public HLayout getToppanel( )
	{
		return toppanel;
	}

	
	/**
	 * @return the middlepanel
	 */
	public HLayout getMiddlepanel( )
	{
		return middlepanel;
	}
	
}
