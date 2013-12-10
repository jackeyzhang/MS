/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.form.SearchDform;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.ui.widget.LabelWithBlue;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.toolbar.RibbonBar;


/**
 * 主界面topbar
 * 
 * @author chenhao
 *
 */
public class IndexPageTopPanel extends RibbonBar
{

	private LabelWithBlue welcome = new LabelWithBlue("请先登录");
	
	private LabelWithBlue modifyButton;
	
	private Member member;
	
	public IndexPageTopPanel()
	{
	        setHeight(50);
	        setWidth100();

	        addSpacer(6);
	        ImgButton sgwtHomeButton = new ImgButton();
	        sgwtHomeButton.setSrc("icons/toppanel/teachers512.png");
	        sgwtHomeButton.setWidth( 50 );
	        sgwtHomeButton.setHeight(50);
	        sgwtHomeButton.setPrompt("欢迎登陆" + IPageConst.SITE_NAME);
	        sgwtHomeButton.setHoverStyle("interactImageHover");
	        sgwtHomeButton.setShowRollOver(false);
	        sgwtHomeButton.setShowDownIcon(false);
	        sgwtHomeButton.setShowDown(false);
	        sgwtHomeButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	History.newItem( IPageConst.PAGE_MEDU );
	            }
	        });
	        addMember(sgwtHomeButton);
	        addSpacer(6);

	        Label title = new Label(IPageConst.SITE_NAME);
	        title.setStyleName("welcomelabel");
	        title.setWidth(300);
	        addMember(title);
	        
	        addMember( new SearchDform());

	        addFill();
	        
	        welcome.setWidth( 200 );
	        addMember(welcome);
	        
	        
	        modifyButton = new LabelWithBlue("【个人中心】",true);
	        modifyButton.addClickHandler( new com.smartgwt.client.widgets.events.ClickHandler( ) {
				
				@Override
				public void onClick( ClickEvent event )
				{
					 History.newItem( IPageConst.PAGE_MS);
				}
			} );
	        modifyButton.setVisible( false );
	        addMember(modifyButton);

	        LabelWithBlue logoutButton = new LabelWithBlue("退出",true);
	        logoutButton.addClickHandler( new com.smartgwt.client.widgets.events.ClickHandler( ) {
				
				@Override
				public void onClick( ClickEvent event )
				{
					History.newItem( IPageConst.PAGE_LOGIN);
				}
			} );

	        addMember(logoutButton);
	}

	
	public void setMember( Member member )
	{
		this.member = member;
		welcome.setContents( "欢迎你," + member.getName( ) );
		if ( modifyButton != null )
		{
			modifyButton.setVisible( true );
			modifyButton.setTooltip( "点击进入个人信息管理界面" );
		}
	}

	
	/**
	 * @return the member
	 */
	public Member getMember( )
	{
		return member;
	}
	
	
}
