/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.tabpanel.AbstractTab;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
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
		
	}
	
	private Canvas getMemberPanel()
	{
		HLayout memberpage = new HLayout();
		TabSet ts = new TabSet();
		memberpanel = new MemberPanel();
		
		ts.addTab( memberpanel );
		
		memberpage.addMember( ts );
		return memberpage;
	}
	
	class MemberPanel extends AbstractTab
	{
		public MemberPanel()
		{
			super("member","",false);
		}
		
		@Override
		public Canvas getPanel( )
		{
			return new Label("member page");
		}
		
	}

}
