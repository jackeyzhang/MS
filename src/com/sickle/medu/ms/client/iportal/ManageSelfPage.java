/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.card.BigMemberCard;
import com.sickle.medu.ms.client.rpc.MemberService;
import com.sickle.medu.ms.client.rpc.MemberServiceAsync;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.tabpanel.AbstractTab;
import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.sickle.medu.ms.client.ui.widget.LabelWithYellow;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
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
	
	public void loadingMember( int memberid )
	{
		if(member != null && memberid !=  member.getId( ))
		{
			History.newItem( IPageConst.PAGE_MEDU );
			return;
		}
		final MemberServiceAsync service = MemberService.Util.getInstance( );
		service.findMember( memberid ,new AsyncCallbackWithStatus<Member>( "加载教师名片" ) {
			@Override
			public void call( Member _member )
			{
				member = _member;
				memberpanel.setTitle( member.getName( ) + "的资料" );
				memberpanel.fillpanel( member );
			}
		});
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
		
		TabSet ts = new TabSet();
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
			for( Canvas mem : wholepanel.getMembers( ))
			{
				wholepanel.removeMember( mem );
			}
			BigMemberCard card = new BigMemberCard( member, ScreenUtil.getWidth( 0.89 ), ScreenUtil.getHeight( 0.78 ) ) ;
			wholepanel.addMember( card );
		}
		
	}
	
	class MessagePanel extends AbstractTab
	{
		public MessagePanel()
		{
			super("已发布课程信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			//TODO 没发布的给出发布按钮 不是老师的建议填写完整老师信息
			
			return new Label("你尚未发布任何课程信息");
		}
		
	}
	
	class AdvertPanel extends AbstractTab
	{
		public AdvertPanel()
		{
			super("已发布学校信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			//TODO 提示发布信息去MS中发布 提供发布链接
			
			return new Label("你尚未发布任何学校信息");
		}
		
	}

}
