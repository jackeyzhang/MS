/**
 * 
 */

package com.sickle.medu.ms.client.indexpage;

import java.util.List;

import com.google.gwt.user.client.ui.Anchor;
import com.sickle.medu.ms.client.indexpage.card.NoticeCard;
import com.sickle.medu.ms.client.indexpage.card.OrgCard;
import com.sickle.medu.ms.client.indexpage.card.TeacherCard;
import com.sickle.medu.ms.client.indexpage.introduce.IntroducePage;
import com.sickle.medu.ms.client.rpc.NoticeService;
import com.sickle.medu.ms.client.rpc.NoticeServiceAsync;
import com.sickle.medu.ms.client.rpc.OrgService;
import com.sickle.medu.ms.client.rpc.OrgServiceAsync;
import com.sickle.medu.ms.client.rpc.TeacherService;
import com.sickle.medu.ms.client.rpc.TeacherServiceAsync;
import com.sickle.medu.ms.client.rpc.util.AsyncCallbackWithStatus;
import com.sickle.medu.ms.client.ui.MainPageTopBar;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.sickle.pojo.edu.Notice;
import com.sickle.pojo.edu.Org;
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

	private static MeduIndexPage instance = new MeduIndexPage();
	
	private MainPageTopBar topbar;
	
	public static MeduIndexPage getInstance()
	{
		return instance;
	}
	
	private MeduIndexPage( )
	{
		setWidth100( );
		setHeight100( );
		
		//#1 add topbar
		addTopBar();
		//#2 添加大广告图片
		addAdvertpanel();
		//#3 添加网站介绍
		addIntroducepanel();
		
		//#4 添加老师名片区域
		insertSpiter("名师推荐");
		loadingTeacherCardPanel();
		
		//#5 添加课程推荐区域
		insertSpiter("推荐课程");
		loadingNoticeCardPanel();
		
		//#6 添加学校介绍区域
		insertSpiter("学校展示");
		loadingSchoolCardPanel();
		
		//#7 添加footer
		loadingSupportPanel();
	}
	
	private void addTopBar()
	{
		topbar = new MainPageTopBar( );
		addMember( topbar );
	}
	
	private void addAdvertpanel()
	{
		addMember(new AdvertImgPanel());
	}
	
	private void addIntroducepanel()
	{
		HLayout productPanel = new HLayout();
		productPanel.setBorder( "2px solid gold" );
		productPanel.setStyleName( "introducepanel" );
		productPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH ) );
		productPanel.setAlign( Alignment.CENTER );
		
		IntroducePage school = new IntroducePage("机构进入" );
		productPanel.addMember( school );
		
		IntroducePage teacher = new IntroducePage("老师进入" );
		productPanel.addMember( teacher );
		
		IntroducePage student = new IntroducePage("学生进入" );
		productPanel.addMember( student );
		
		IntroducePage register = new IntroducePage("用户注册" );
		productPanel.addMember( register );
		
		HLayout thispanel = new HLayout();
		thispanel.setWidth100( );
		thispanel.setHeight( "30px" );
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
		final int columnnum = (int) ( (width/IPageConst.CARD_WIDTH) );
		final int num = columnnum * IPageConst.CARD_ROW_MAX_NUM;
		
		final double increment = (width - columnnum * IPageConst.CARD_WIDTH)/columnnum;
		
		TeacherServiceAsync service = TeacherService.Util.getInstance( );
		service.listAllTeacher( 0, num ,new AsyncCallbackWithStatus<List<Teacher>>( "加载教师名片" ) {
			@Override
			public void call( List<Teacher> result )
			{
				for( int r = 0,i = 0; r < IPageConst.CARD_ROW_MAX_NUM; r++ )
				{
					HLayout onecardpanel = new HLayout();
					for(; i < columnnum * (r + 1) ;i ++)
					{
						if( i >= result.size()){
							break;
						}
						TeacherCard p = new TeacherCard(result.get( i ),IPageConst.CARD_WIDTH+ increment + "px",IPageConst.CARD_HEIGHT + "px");
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
		final int columnnum = (int) ( (width/IPageConst.SCHOOL_CARD_WIDTH) );
		final int num = columnnum * IPageConst.SCHOOL_CARD_ROW_MAX_NUM;
		final double increment = (width - columnnum * IPageConst.SCHOOL_CARD_WIDTH)/columnnum;
		OrgServiceAsync service = OrgService.Util.getInstance( );
		service.listAllOrg( 0, num ,new AsyncCallbackWithStatus<List<Org>>( "加载学校名片" ) {
			@Override
			public void call( List<Org> result )
			{
				for( int r = 0,i = 0; r < IPageConst.SCHOOL_CARD_ROW_MAX_NUM; r++ )
				{
					HLayout onecardpanel = new HLayout();
					for(; i < columnnum * ( r + 1);i ++)
					{
						if( i >= result.size()){
							break;
						}
						OrgCard p = new OrgCard(result.get( i ),IPageConst.SCHOOL_CARD_WIDTH + increment + "px",IPageConst.SCHOOL_CARD_HEIGHT + "px");
						onecardpanel.addMember( p );
					}
					cardPanel.addMember( onecardpanel );
				}
				
			}
		});
	}
	
	private void loadingNoticeCardPanel()
	{
		final VLayout cardPanel = new VLayout();
		cardPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH )  );
		cardPanel.setHeight( IPageConst.NOTICE_CARD_HEIGHT + "px" );
		cardPanel.setAlign( Alignment.CENTER );
		
		
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setAlign( Alignment.CENTER );
		panel.addMember( cardPanel );
		addMember(panel);
		
		
		final double width = ScreenUtil.getWidthNum( IPageConst.PAGE_WIDTH );
		final int columnnum = (int) ( (width/IPageConst.NOTICE_CARD_WIDTH) );
		final int num = columnnum * IPageConst.NOTICE_CARD_ROW_MAX_NUM;
		final double increment = (width - columnnum * IPageConst.NOTICE_CARD_WIDTH)/columnnum;
		
		NoticeServiceAsync service = NoticeService.Util.getInstance( );
		service.listAllNotice( 0, num ,new AsyncCallbackWithStatus<List<Notice>>( "加载通知信息" ) {
			@Override
			public void call( List<Notice> result )
			{
				for( int r = 0,i = 0; r < IPageConst.NOTICE_CARD_ROW_MAX_NUM; r++ )
				{
					HLayout onecardpanel = new HLayout();
					for(; i < columnnum * ( r + 1) ;i ++)
					{
						if( i >= result.size()){
							break;
						}
						NoticeCard p = new NoticeCard(result.get( i ),IPageConst.NOTICE_CARD_WIDTH + increment + "px",IPageConst.NOTICE_CARD_HEIGHT + "px");
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
		panel.setStyleName( "footer" );
		panel.setWidth100( );
		panel.setHeight( 100 );
		panel.setAlign( Alignment.LEFT );
		panel.addMember( new Anchor( "汲原堂语言发展中心","http://www.jiyuantown.com/" , "_blank") );
		addMember(panel);
	}
	
	private void insertSpiter(String spiterwords)
	{
		VLayout cardPanel = new VLayout();
		cardPanel.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH )  );
		cardPanel.setStyleName( "splitter" );
		cardPanel.setAlign( Alignment.CENTER );
		Label label = new Label( spiterwords );
		label.setStyleName( "splitterlabel" );
		label.setHeight( "30px" );
		cardPanel.addMember( label );
		
		HLayout panel = new HLayout();
		panel.setWidth100( );
		panel.setAlign( Alignment.CENTER );
		panel.addMember( cardPanel );
		addMember(panel);
	}

	
	/**
	 * @return the topbar
	 */
	public MainPageTopBar getTopbar( )
	{
		return topbar;
	}

	
	/**
	 * @param topbar the topbar to set
	 */
	public void setTopbar( MainPageTopBar topbar )
	{
		this.topbar = topbar;
	}
}
