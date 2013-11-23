/**
 * 
 */
package com.sickle.medu.ms.client.ui;

import com.google.gwt.user.client.History;
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
public class MainPageTopBar extends RibbonBar
{

	private LabelWithBlue welcome = new LabelWithBlue("请先登录");
	
	private LabelWithBlue modifyButton;
	
	private Member member;
	
	public MainPageTopBar()
	{
	        setHeight(33);
	        setWidth100();

	        addSpacer(6);
	        ImgButton sgwtHomeButton = new ImgButton();
	        sgwtHomeButton.setSrc("pieces/24/cube_green.png");
	        sgwtHomeButton.setWidth(24);
	        sgwtHomeButton.setHeight(24);
	        sgwtHomeButton.setPrompt("欢迎登陆爱师网");
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
	        title.setStyleName("sgwtTitle");
	        title.setWidth(300);
	        addMember(title);

	        addFill();
	        
	        welcome.setWidth( 200 );
	        addMember(welcome);
	        
	        
	        modifyButton = new LabelWithBlue("个人信息管理",true);
	        modifyButton.addClickHandler( new com.smartgwt.client.widgets.events.ClickHandler( ) {
				
				@Override
				public void onClick( ClickEvent event )
				{
					 History.newItem( IPageConst.PAGE_MANAGESELF);
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
