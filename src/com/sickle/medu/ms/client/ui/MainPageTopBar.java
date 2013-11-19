/**
 * 
 */
package com.sickle.medu.ms.client.ui;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.ui.widget.BluelittleLabel;
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

	private BluelittleLabel welcome = new BluelittleLabel("请先登录",false);
	
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
	        
	        addMember(welcome);

	        BluelittleLabel logoutButton = new BluelittleLabel("退出");
	        logoutButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	                History.newItem( IPageConst.PAGE_LOGIN );
	            }
	        });
	        
	        BluelittleLabel indexButton = new BluelittleLabel("首页");
	        indexButton.setTitle("首页");
	        indexButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	History.newItem( IPageConst.PAGE_MEDU );
	            }
	        });

	        addMember(logoutButton);
	}

	
	/**
	 * @return the welcome
	 */
	public Label getWelcome( )
	{
		return welcome;
	}

	
	/**
	 * @param welcome the welcome to set
	 */
	public void setWelcome( BluelittleLabel welcome )
	{
		this.welcome = welcome;
	}
	
}
