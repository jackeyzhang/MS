/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.card.BigMemberCard;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.tabpanel.AbstractTab;
import com.sickle.medu.ms.client.ui.widget.LabelWithBlue;
import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.sickle.medu.ms.client.ui.widget.LabelWithYellow;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.TabSet;


/**
 * 用户修改个人信息界面
 * 
 * @author chenhao
 *
 */
public class ManageSelfPage extends AbstractPage
{

	private static ManageSelfPage instance = new ManageSelfPage();
	
	private TabSet ts;
	
	private MemberPanel memberpanel;
	
	private MessagePanel messagepanel;
	
	private AdvertPanel advertpanel;
	
	private Member member;
	
	public static ManageSelfPage getInstance()
	{
		return instance;
	}
	
	private ManageSelfPage()
	{
		super( IPageConst.PAGE_MANAGESELF );
		init();
	}
	

	private void init( )
	{
		this.setWidth100( );
		this.setHeight100( );
		
		//上部分
		this.addMember( getDefaultTopPanel() );
		//中间部分
		this.addMember( getMemberPanel() );
		//下部分
		this.addMember( getDefaultVersionPanel() ) ;
	}
	
	public void loadingMember( Member _member )
	{
		if( _member == null )
		{
			History.newItem( IPageConst.PAGE_MEDU );
			return;
		}
		member = _member;
		memberpanel.setTitle( member.getName( ) + "的资料" );
		memberpanel.fillpanel( member );
		messagepanel.fillpanel( member );
		advertpanel.fillpanel( member );
	}
	
	private Canvas getMemberPanel()
	{
		VLayout memberpage = new VLayout();
		memberpage.setStyleName( "memberpage" );
		
		HLayout titlepanel = new HLayout();
		titlepanel.setHeight( ScreenUtil.getHeight( 0.05 ) );
		
		LabelWithYellow returnpage = new LabelWithYellow("返回首页");
		returnpage.setWidth( ScreenUtil.getWidth( 0.1 ) );
		returnpage.setHeight( ScreenUtil.getHeight( 0.05 ) );
		returnpage.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_MEDU );
			}
		} );
		
		LabelWithWhite title = new LabelWithWhite("修改个人信息");
		title.setAlign( Alignment.CENTER );
		title.setWidth( ScreenUtil.getWidth( 0.9 ) );
		title.setHeight( ScreenUtil.getHeight( 0.05 ) );
		
		titlepanel.addMember( returnpage );
		titlepanel.addMember( title );
		
		memberpage.addMember( titlepanel );
		
		ts = new TabSet();
		ts.setUseSimpleTabs( true );
		ts.setSmoothFade( true );
		ts.setTabBarPosition( Side.LEFT );
		ts.setTabBarThickness( ScreenUtil.getWidthInt( 0.1 ) );
		
		memberpanel = new MemberPanel();
		messagepanel = new MessagePanel();
		advertpanel = new AdvertPanel();
		
		ts.addTab( memberpanel );
		ts.addTab( messagepanel );
		ts.addTab( advertpanel );
		
		memberpage.addMember( ts );
		return memberpage;
	}
	
	class MemberPanel extends AbstractTab
	{
		private VLayout wholepanel ;
		
		public MemberPanel()
		{
			super("个人信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			wholepanel = new VLayout();
			return wholepanel;
		}
		
		public void fillpanel(final Member member)
		{
			wholepanel.setWidth100( );
			wholepanel.setHeight100( );
			wholepanel.setStyleName( "bigmembercardborder" );
			ScreenUtil.clearLayout( wholepanel );
			BigMemberCard card = new BigMemberCard( true , member, ScreenUtil.getWidth( 0.89 ), ScreenUtil.getHeight( 0.78 ) ) ;
			wholepanel.addMember( card );
		}
		
	}
	
	class MessagePanel extends AbstractTab
	{
		private VLayout wholepanel ;
		
		public MessagePanel()
		{
			super("已发布课程信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			wholepanel = new VLayout();
			return wholepanel;
		}
		
		public void fillpanel(final Member member)
		{
			wholepanel.setWidth100( );
			wholepanel.setHeight100( );
			wholepanel.setStyleName( "bigmembercardborder" );
			ScreenUtil.clearLayout( wholepanel );
			//TODO 没发布的给出发布按钮 不是老师的建议填写完整老师信息
			boolean isteacher = member.isTeacher( );
			if( isteacher )
			{
				wholepanel.addMember( new Label("你尚未发布任何课程信息") );
			}
			else
			{
				LabelWithBlue modify = new LabelWithBlue( "你还不是本网站注册教师,只有教师才可以发布课程信息,请在个人信息里填写教师信息.",true );
				modify.addClickHandler( new ClickHandler( ) {
					@Override
					public void onClick( ClickEvent event )
					{
						ts.selectTab( 0 );
					}
				} );
				wholepanel.addMember( modify );
			}
		}
	}
	
	class AdvertPanel extends AbstractTab
	{
		private VLayout wholepanel ;
		
		public AdvertPanel()
		{
			super("已发布学校信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			wholepanel = new VLayout();
			return wholepanel;
		}
		
		public void fillpanel(final Member member)
		{
			wholepanel.setWidth100( );
			wholepanel.setHeight100( );
			wholepanel.setStyleName( "bigmembercardborder" );
			ScreenUtil.clearLayout( wholepanel );
			//TODO 没发布的给出发布按钮 不是老师的建议填写完整老师信息
			boolean isteacher = member.isTeacher( );
			if( isteacher )
			{
				wholepanel.addMember( new Label("你尚未发布任何学校信息") );
			}
			else
			{
				LabelWithBlue modify = new LabelWithBlue( "你还不是本网站注册教师,只有教师才可以发布学校信息,请在个人信息里填写教师信息.",true );
				modify.addClickHandler( new ClickHandler( ) {
					@Override
					public void onClick( ClickEvent event )
					{
						ts.selectTab( 0 );
					}
				} );
				wholepanel.addMember( modify );
			}
		}
		
	}

}
