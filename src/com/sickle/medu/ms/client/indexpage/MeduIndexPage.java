/**
 * 
 */

package com.sickle.medu.ms.client.indexpage;

import com.sickle.medu.ms.client.ui.MainPageTopBar;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.sickle.pojo.edu.Teacher;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
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
		setAlign( Alignment.CENTER );
		//#1 add topbar
		addTopBar();
		//#2 添加大广告图片
		addAdvertpanel();
		//#3 添加网站介绍
		addProductpanel();
		//#4 添加老师名片区域
		addPersonCardPanel();
		//#5 添加学校介绍区域
		
		//#6 添加课程推荐区域
		
		//#7 添加footer
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
	
	private void addProductpanel()
	{
		HLayout productPanel = new HLayout();
		productPanel.setWidth("98%");
		productPanel.setHeight( "10%" );
		productPanel.setAlign( Alignment.CENTER );
		
		Label school = new Label("机构进入" );
		productPanel.addMember( school );
		
		Label teacher = new Label("老师进入" );
		productPanel.addMember( teacher );
		
		Label student = new Label("学生进入" );
		productPanel.addMember( student );
		
		addMember(productPanel);
	}
	
	private void addPersonCardPanel()
	{
		Teacher teacher = new Teacher();
		teacher.setName( "王老师" );
		teacher.setGrade( 0.56f );
		teacher.setContact( "浦东南路1271号" );
		
		
		HLayout cardPanel = new HLayout();
		cardPanel.setWidth100( );
		cardPanel.setHeight100( );
		cardPanel.setAlign( Alignment.CENTER );
		
		HLayout onecardpanel = new HLayout();
		onecardpanel.setWidth( ScreenUtil.getWidth( 0.98 )  );
		onecardpanel.setHeight100( );
		
		double width = ScreenUtil.getWidthNum( 0.98 );
		
		for(int i = 0; i < (width/IPageConst.CARD_WIDTH)-1 ;i ++)
		{
			PersonalCard p = new PersonalCard(teacher,IPageConst.CARD_WIDTH + "px",IPageConst.CARD_HEIGHT + "px");
			onecardpanel.addMember( p );
		}
		
		cardPanel.addMember( onecardpanel 	);
		
		addMember(cardPanel);
	}

}
