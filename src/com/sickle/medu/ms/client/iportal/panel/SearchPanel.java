/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 搜索面板
 * 
 * @author chenhao
 *
 */
public class SearchPanel extends VLayout
{
	
	public SearchPanel(String radius)
	{
		setSize( radius, radius );
		setStyleName( "searchpanel" );
		init();
	}
	
	private void init()
	{
		this.addMember( new LabelWithWhite( "搜索" ) );
	}

}
