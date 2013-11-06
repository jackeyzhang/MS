/**
 * 
 */
package com.sickle.medu.ms.client.ui;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.ui.widget.LinkLabel;
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

	private LinkLabel welcome = new LinkLabel("请先登录",false);
	
	public MainPageTopBar()
	{
	        setHeight(33);
	        setWidth100();

	        addSpacer(6);
	        ImgButton sgwtHomeButton = new ImgButton();
	        sgwtHomeButton.setSrc("pieces/24/cube_green.png");
	        sgwtHomeButton.setWidth(24);
	        sgwtHomeButton.setHeight(24);
	        sgwtHomeButton.setPrompt("MS");
	        sgwtHomeButton.setHoverStyle("interactImageHover");
	        sgwtHomeButton.setShowRollOver(false);
	        sgwtHomeButton.setShowDownIcon(false);
	        sgwtHomeButton.setShowDown(false);
	        sgwtHomeButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	                com.google.gwt.user.client.Window.open("http://code.google.com/p/smartgwt/",
	                                                       "sgwt", null);
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

	        LinkLabel logoutButton = new LinkLabel("退出");
	        logoutButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	                History.newItem( IPageConst.PAGE_LOGIN );
	            }
	        });
	        
	        LinkLabel indexButton = new LinkLabel("首页");
	        indexButton.setTitle("首页");
	        indexButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	//Window.open( GWT.getHostPageBaseURL( ), "_self", "" );
	            	History.newItem( IPageConst.PAGE_MEDU );
	            }
	        });

	        addMember(logoutButton);
	        addMember(indexButton);

	        addSeparator();

	        ImgButton imgButton = new ImgButton();
	        imgButton.setWidth(18);
	        imgButton.setHeight(18);
	        imgButton.setSrc("silk/emoticon.png");
	        imgButton.setShowFocused(false);
	        imgButton.setShowFocusedIcon(false);
	        imgButton.setPrompt("I'm feeling lucky");
	        imgButton.setHoverWidth(110);
	        imgButton.setHoverStyle("interactImageHover");

	        imgButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	
	            }
	        });

	        addMember(imgButton);

	        addSpacer(6);
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
	public void setWelcome( LinkLabel welcome )
	{
		this.welcome = welcome;
	}
	
}
