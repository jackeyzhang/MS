/**
 * 
 */

package com.sickle.medu.ms.client.indexpage;

import java.util.List;

import com.google.gwt.user.client.ui.Anchor;
import com.sickle.medu.ms.client.indexpage.card.TeacherCard;
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
		loadingTeacherCardPanel();
		//#5 添加学校介绍区域
		loadingSchoolCardPanel();
		//#6 添加课程推荐区域
		loadingClassesCardPanel();
		//#7 添加footer
		loadingSupportPanel();
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
	
	private void loadingTeacherCardPanel()
	{
		final VLayout cardPanel = new VLayout();
		cardPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH )  );
		cardPanel.setHeight( IPageConst.CARD_HEIGHT + "px" );
		cardPanel.setAlign( Alignment.CENTER );
		
		
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setAlign( Alignment.CENTER );
		panel.addMember( cardPanel );
		addMember(panel);
		
		
		final double width = ScreenUtil.getWidthNum( IPageConst.PAGE_WIDTH );
		final int columnnum = (int) ( (width/IPageConst.CARD_WIDTH) - 1 );
		final int num = columnnum * IPageConst.CARD_ROW_MAX_NUM;
		
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.listAllTeacher( 0, num ,new AsyncCallbackWithStatus<List<Teacher>>( "加载教师名片" ) {
			@Override
			public void call( List<Teacher> result )
			{
				for( int r = 0,i = 0; r < IPageConst.CARD_ROW_MAX_NUM; r++ )
				{
					HLayout onecardpanel = new HLayout();
					for(; i < columnnum ;i ++)
					{
						if( i >= result.size()){
							break;
						}
						TeacherCard p = new TeacherCard(result.get( i ),IPageConst.CARD_WIDTH + "px",IPageConst.CARD_HEIGHT + "px");
						onecardpanel.addMember( p );
					}
					cardPanel.addMember( onecardpanel );
				}
				
			}
		});
		
	}
	
	private void loadingSchoolCardPanel()
	{
		final VLayout cardPanel = new VLayout();
		cardPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH )  );
		cardPanel.setHeight( IPageConst.SCHOOL_CARD_HEIGHT + "px" );
		cardPanel.setAlign( Alignment.CENTER );
		
		
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setAlign( Alignment.CENTER );
		panel.addMember( cardPanel );
		addMember(panel);
		
		
		final double width = ScreenUtil.getWidthNum( IPageConst.PAGE_WIDTH );
		final int columnnum = (int) ( (width/IPageConst.SCHOOL_CARD_WIDTH) - 1 );
		final int num = columnnum * IPageConst.CARD_ROW_MAX_NUM;
		
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.listAllTeacher( 0, num ,new AsyncCallbackWithStatus<List<Teacher>>( "加载学校名片" ) {
			@Override
			public void call( List<Teacher> result )
			{
				for( int r = 0,i = 0; r < IPageConst.CARD_ROW_MAX_NUM; r++ )
				{
					HLayout onecardpanel = new HLayout();
					for(; i < columnnum ;i ++)
					{
						if( i >= result.size()){
							break;
						}
						TeacherCard p = new TeacherCard(result.get( i ),IPageConst.CARD_WIDTH + "px",IPageConst.CARD_HEIGHT + "px");
						onecardpanel.addMember( p );
					}
					cardPanel.addMember( onecardpanel );
				}
				
			}
		});
	}
	
	private void loadingClassesCardPanel()
	{
		final VLayout cardPanel = new VLayout();
		cardPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH )  );
		cardPanel.setHeight( IPageConst.CLASS_CARD_HEIGHT + "px" );
		cardPanel.setAlign( Alignment.CENTER );
		
		
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setAlign( Alignment.CENTER );
		panel.addMember( cardPanel );
		addMember(panel);
		
		
		final double width = ScreenUtil.getWidthNum( IPageConst.PAGE_WIDTH );
		final int columnnum = (int) ( (width/IPageConst.CLASS_CARD_WIDTH) - 1 );
		final int num = columnnum * IPageConst.CARD_ROW_MAX_NUM;
		
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.listAllTeacher( 0, num ,new AsyncCallbackWithStatus<List<Teacher>>( "加载班级名片" ) {
			@Override
			public void call( List<Teacher> result )
			{
				for( int r = 0,i = 0; r < IPageConst.CARD_ROW_MAX_NUM; r++ )
				{
					HLayout onecardpanel = new HLayout();
					for(; i < columnnum ;i ++)
					{
						if( i >= result.size()){
							break;
						}
						TeacherCard p = new TeacherCard(result.get( i ),IPageConst.CARD_WIDTH + "px",IPageConst.CARD_HEIGHT + "px");
						onecardpanel.addMember( p );
					}
					cardPanel.addMember( onecardpanel );
				}
				
			}
		});
	}
	
	private void loadingSupportPanel()
	{
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setHeight( "200px" );
		panel.setAlign( Alignment.LEFT );
		panel.addMember( new Anchor( "汲原堂语言发展中心","http://www.jiyuantown.com/" , "_blank") );
		addMember(panel);
	}

}