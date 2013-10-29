/**
 * 
 */
package com.sickle.medu.ms.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.sickle.medu.ms.client.indexpage.LoginDialog;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;


/**
 * 主界面topbar
 * 
 * @author chenhao
 *
 */
public class MainPageTopBar extends RibbonBar
{

	private Label welcome = new Label("未登录");
	
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

	        Label title = new Label("爱师网");
	        title.setStyleName("sgwtTitle");
	        title.setWidth(300);
	        addMember(title);

	        addFill();
	        
	        welcome.setWidth(100);
	        addMember(welcome);

	        ToolStripButton loginButton = new ToolStripButton();
	        loginButton.setTitle("登录");
	        loginButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	                new LoginDialog( ).show( );
	            }
	        });

	        ToolStripButton logoutButton = new ToolStripButton();
	        logoutButton.setTitle("退出");
	        logoutButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	                SC.say("todo:logout");
	            }
	        });
	        
	        ToolStripButton indexButton = new ToolStripButton();
	        indexButton.setTitle("首页");
	        indexButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	Window.open( GWT.getHostPageBaseURL( ), "_self", "" );
	            }
	        });

	        addButton(loginButton);
	        addButton(logoutButton);
	        addButton(indexButton);

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
	public void setWelcome( Label welcome )
	{
		this.welcome = welcome;
	}
	
}
