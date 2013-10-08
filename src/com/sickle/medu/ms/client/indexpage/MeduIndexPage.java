/**
 * 
 */

package com.sickle.medu.ms.client.indexpage;

import java.util.List;

import com.sickle.medu.ms.client.rpc.RpcHelper;
import com.sickle.medu.ms.client.rpc.TeacherService;
import com.sickle.medu.ms.client.rpc.TeacherServiceAsync;
import com.sickle.medu.ms.client.rpc.util.AsyncCallbackWithStatus;
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
		
		//#1 add topbar
		addTopBar();
		//#2 添加大广告图片
		addAdvertpanel();
		//#3 添加网站介绍
		addProductpanel();
		//#4 添加老师名片区域
		loadingPersonCardPanel();
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
		productPanel.setBorder( "2px solid gold" );
		productPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH ) );
		productPanel.setAlign( Alignment.CENTER );
		
		Label school = new Label("机构进入" );
		productPanel.addMember( school );
		
		Label teacher = new Label("老师进入" );
		productPanel.addMember( teacher );
		
		Label student = new Label("学生进入" );
		productPanel.addMember( student );
		
		Label register = new Label("新用户注册" );
		productPanel.addMember( register );
		
		HLayout thispanel = new HLayout();
		thispanel.setWidth100( );
		thispanel.setHeight( "60px" );
		thispanel.setAlign( Alignment.CENTER );
		thispanel.addMember( productPanel );
		
		addMember(thispanel);
	}
	
	private void loadingPersonCardPanel()
	{
		HLayout cardPanel = new HLayout();
		cardPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH )  );
		cardPanel.setHeight100( );
		cardPanel.setAlign( Alignment.CENTER );
		
		final HLayout onecardpanel = new HLayout();
		
		onecardpanel.setHeight100( );
		
		final double width = ScreenUtil.getWidthNum( IPageConst.PAGE_WIDTH );
		
		
		cardPanel.addMember( onecardpanel );
		
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setAlign( Alignment.CENTER );
		panel.addMember( cardPanel );
		
		addMember(panel);
		
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.listAllTeacher( 0 ,new AsyncCallbackWithStatus<List<Teacher>>( "加载教师名片" ) {
			@Override
			public void call( List<Teacher> result )
			{
				for(int i = 0; i < (width/IPageConst.CARD_WIDTH)-1 ;i ++)
				{
					if( i >= result.size()){
						break;
					}
					PersonalCard p = new PersonalCard(result.get( i ),IPageConst.CARD_WIDTH + "px",IPageConst.CARD_HEIGHT + "px");
					onecardpanel.addMember( p );
				}
			}
		});
		
		
	}

}
