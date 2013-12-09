/**
 * 
 */
package com.sickle.medu.ms.client.ui.panel;

import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * @author chenhao
 *
 */
public class BluePanel extends VLayout
{
	
	public BluePanel(String width,String height,String content)
	{
		setSize( width, height );
		setStyleName( "descpanel-middlepanel" );
		addMember( new LabelWithWhite( content ) );
	}
	
	

}
