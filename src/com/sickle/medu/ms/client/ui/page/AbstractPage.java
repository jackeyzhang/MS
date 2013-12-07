/**
 * 
 */
package com.sickle.medu.ms.client.ui.page;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.sickle.medu.ms.client.ui.widget.LabelWithYellow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 抽象的page
 * 
 * 提供history管理功能
 * 
 * @author chenhao
 *
 */
public abstract class AbstractPage extends VLayout
{
	
	private String tokenhistory = "";
	
	public AbstractPage(final String token)
	{
		this.tokenhistory = token;
	}

	
	/**
	 * @return the token
	 */
	public String getToken( )
	{
		return tokenhistory;
	}
	
	public Layout getPage()
	{
		return this;
	}
	
	public void clear()
	{
		if( this.isCreated( ))
		{
			super.clear( );
		}
	}
	
	public Layout getDefaultTopPanel()
	{
		HLayout toppanel = new HLayout( );
		
		toppanel.setWidth100( );
		toppanel.setHeight( ScreenUtil.getHeight( 0.05 ) );
		toppanel.setStyleName( "defaulttoppanel" );
		
		ImgButton sgwtHomeButton = new ImgButton( );
		sgwtHomeButton.setSrc( "icons/toppanel/teachers512.png" );
		sgwtHomeButton.setWidth( 50 );
		sgwtHomeButton.setHeight( 50 );
		sgwtHomeButton.setPrompt( IPageConst.SITE_NAME );
		sgwtHomeButton.setHoverStyle( "interactImageHover" );
		sgwtHomeButton.setShowRollOver( false );
		sgwtHomeButton.setShowDownIcon( false );
		sgwtHomeButton.setShowDown( false );
		sgwtHomeButton
				.addClickHandler( new com.smartgwt.client.widgets.events.ClickHandler( ) {

					public void onClick( ClickEvent event )
					{
						History.newItem( IPageConst.PAGE_MEDU );
					}
				} );
		toppanel.addMember( sgwtHomeButton );
		
		LabelWithYellow title = new LabelWithYellow( IPageConst.SITE_NAME,true );
		title.setWidth( 300 );
		title.setHeight( 50 );
		title.setAlign( Alignment.LEFT );
		title.setValign(VerticalAlignment.CENTER);
		title.addClickHandler( new ClickHandler(){
			@Override
			public void onClick( ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_MEDU );
			}
		} );
		toppanel.addMember( title );
		
		return toppanel;
	}
	
	public Layout getDefaultVersionPanel()
	{
		HLayout versionpanel = new HLayout( );
		versionpanel.setWidth100( );
		versionpanel.setHeight(  ScreenUtil.getHeightInt( 0.9 ) - 450  );
		versionpanel.setAlign( Alignment.CENTER );
		versionpanel.setStyleName("versionpanel");
		
		Label version = new Label("Copyright ©2013 sickle");
		version.setWidth( 200 );

		versionpanel.addMember( version );
		return versionpanel;
	}
}
