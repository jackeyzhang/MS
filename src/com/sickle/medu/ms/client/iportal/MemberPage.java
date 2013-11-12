/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.card.MemberCard;
import com.sickle.medu.ms.client.rpc.MemberService;
import com.sickle.medu.ms.client.rpc.MemberServiceAsync;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.tabpanel.AbstractTab;
import com.sickle.medu.ms.client.ui.widget.LinkLabel;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.TabSet;


/**
 * 用户查看界面
 * 
 * @author chenhao
 *
 */
public class MemberPage extends AbstractPage
{

	private static MemberPage instance = new MemberPage();
	
	private MemberPanel memberpanel;
	
	private MessagePanel messagepanel;
	
	
	public static MemberPage getInstance()
	{
		return instance;
	}
	
	private MemberPage()
	{
		super( IPageConst.PAGE_MEMBER );
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
		final MemberServiceAsync service = MemberService.Util.getInstance( );
		service.findMember( memberid ,new AsyncCallbackWithStatus<Member>( "加载教师名片" ) {
			@Override
			public void call( Member result )
			{
				MemberCard p = new MemberCard(result ,IPageConst.CARD_WIDTH + "px",IPageConst.CARD_HEIGHT + "px");
				memberpanel.setPane( p );
			}
		});
	}
	
	private Canvas getMemberPanel()
	{
		VLayout memberpage = new VLayout();
		memberpage.setStyleName( "registerpage" );
		
		LinkLabel returnpage = new LinkLabel(">>返回首页");
		returnpage.setHeight( 30 );
		returnpage.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_MEDU );
			}
		} );
		memberpage.addMember( returnpage );
		
		TabSet ts = new TabSet();
		ts.setSmoothFade( true );
		ts.setTabBarPosition( Side.LEFT );
		ts.setTabBarThickness( 100 );
		
		memberpanel = new MemberPanel();
		messagepanel = new MessagePanel();
		
		ts.addTab( memberpanel );
		ts.addTab( messagepanel );
		
		memberpage.addMember( ts );
		return memberpage;
	}
	
	class MemberPanel extends AbstractTab
	{
		public MemberPanel()
		{
			super("个人信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			return new Label("member page");
		}
		
	}
	
	class MessagePanel extends AbstractTab
	{
		public MessagePanel()
		{
			super("消息管理","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			return new Label("message page");
		}
		
	}

}
