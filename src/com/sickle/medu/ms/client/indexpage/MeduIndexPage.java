/**
 * 
 */

package com.sickle.medu.ms.client.indexpage;

import com.sickle.medu.ms.client.ui.MainPageTopBar;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * MEDU main page
 * 
 * @author chenhao
 * 
 */
public class MeduIndexPage extends VLayout
{

	public MeduIndexPage( )
	{
		setWidth100( );
		setHeight100( );

		//#1 add topbar
		addTopBar();
		//#2 添加大广告图片
		addAdvertpanel();
		
		//#3 添加老师名片区域
		
		//#4 添加学校介绍区域
		
		//#5 添加课程推荐区域
		
		//#6 添加footer
	}
	
	private void addTopBar()
	{
		MainPageTopBar topbar = new MainPageTopBar( );
		addMember( topbar );
	}
	
	private void addAdvertpanel()
	{
		addMember(new AdvertImgPanel());
	}

}
