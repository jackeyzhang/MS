/**
 * 
 */
package com.sickle.medu.ms.client.ui.tabpanel;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;


/**
 * 网站编辑页面
 * 
 * @author chenhao
 *
 */
public class WebSiteEditTab extends AbstractTab
{

	public WebSiteEditTab()
	{
		super( "网站内容编辑", "silk/application_view_tile.png", true );
	}

	@Override
	public Canvas getPanel( )
	{
		return new Label("编辑内容");
	}

}
