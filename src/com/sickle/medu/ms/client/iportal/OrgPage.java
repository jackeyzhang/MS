/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.card.BigOrgCard;
import com.sickle.medu.ms.client.rpc.OrgService;
import com.sickle.medu.ms.client.rpc.OrgServiceAsync;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.tabpanel.AbstractTab;
import com.sickle.medu.ms.client.ui.widget.LinkLabel;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.sickle.pojo.edu.Org;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.TabSet;


/**
 * 机构查看详细页
 * 
 */
public class OrgPage extends AbstractPage
{

	private static OrgPage instance = new OrgPage();
	
	private OrgPannel orgPannel;
	
	private SchoolPannel schoolPannel;
	
	
	public static OrgPage getInstance()
	{
		return instance;
	}
	
	private OrgPage()
	{
		super( IPageConst.PAGE_ORG );
		init();
	}
	

	private void init( )
	{
		this.setWidth100( );
		this.setHeight100( );
		
		//上部分
		this.addMember( getDefaultTopPanel() );
		//中间部分
		this.addMember( getOrgPanel() );
		//下部分
		this.addMember( getDefaultVersionPanel() ) ;
	}
	
	public void loadingOrg( int orgid )
	{
		final OrgServiceAsync service =  OrgService.Util.getInstance( );
		service.getOrgById(orgid ,new AsyncCallbackWithStatus<Org>( "加载机构名片" ) {
			@Override
			public void call( Org org )
			{
				orgPannel.setTitle( org.getName( ) + "的资料" );
				orgPannel.fillpanel( org );
			}
		});
	}
	
	private Canvas getOrgPanel()
	{
		VLayout orgrpage = new VLayout();
		orgrpage.setStyleName( "orgpage" );
		
		LinkLabel returnpage = new LinkLabel(">>返回首页");
		returnpage.setHeight( ScreenUtil.getHeight( 0.05 ) );
		returnpage.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_MEDU );
			}
		} );
		orgrpage.addMember( returnpage );
		
		TabSet ts = new TabSet();
		ts.setUseSimpleTabs( true );
		ts.setSmoothFade( true );
		ts.setTabBarPosition( Side.LEFT );
		ts.setTabBarThickness( ScreenUtil.getWidthInt( 0.1 ) );
		
		orgPannel = new OrgPannel();
		schoolPannel = new SchoolPannel();
		
		ts.addTab( orgPannel );
		ts.addTab( schoolPannel );
		
		orgrpage.addMember( ts );
		return orgrpage;
	}
	
	class OrgPannel extends AbstractTab
	{
		private VLayout wholepanel ;
		
		public OrgPannel()
		{
			super("机构信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			wholepanel = new VLayout();
			return wholepanel;
		}
		
		public void fillpanel(Org org)
		{
			wholepanel.setWidth100( );
			wholepanel.setHeight100( );
			for( Canvas mem : wholepanel.getMembers( ))
			{
				wholepanel.removeMember( mem );
			}
			wholepanel.addMember( new BigOrgCard( org, ScreenUtil.getWidth( 0.89 ), ScreenUtil.getHeight( 0.78 ) ) );
		}
		
	}
	
	class SchoolPannel extends AbstractTab
	{
		public SchoolPannel()
		{
			super("分校信息","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			return new Label("School page" + this.getTitleStyle( ));
		}
		
	}

}
