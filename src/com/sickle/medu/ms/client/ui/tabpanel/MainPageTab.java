/**
 * 
 */
package com.sickle.medu.ms.client.ui.tabpanel;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;


/**
 * 主界面默认不可关闭的首页
 * 
 * @author chenhao
 *
 */
public class MainPageTab extends AbstractTab
{

	public MainPageTab()
	{
		super( "主界面", "pieces/16/cube_frame.png", false );
	}

	@Override
	public Canvas getPanel( )
	{
		return new Label("main panel");
	}

}