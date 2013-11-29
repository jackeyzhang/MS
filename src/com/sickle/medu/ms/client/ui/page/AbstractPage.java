/**
 * 
 */
package com.sickle.medu.ms.client.ui.page;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.ui.widget.LabelWithBlue;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.smartgwt.client.types.Alignment;
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
		toppanel.setHeight( ScreenUtil.getHeight( 0.1 ) );
		toppanel.setStyleName( "defaulttoppanel" );
		
		ImgButton sgwtHomeButton = new ImgButton( );
		sgwtHomeButton.setSrc( "pieces/24/cube_green.png" );
		sgwtHomeButton.setWidth( 24 );
		sgwtHomeButton.setHeight( 24 );
		sgwtHomeButton.setPrompt( "MS" );
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
		
		LabelWithBlue title = new LabelWithBlue( "爱师网",true );
		title.setWidth( 300 );
		title.setHeight( 20 );
		title.setAlign( Alignment.LEFT );
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
		versionpanel.setHeight( 50 );
		versionpanel.setAlign( Alignment.CENTER );
		
		Label version = new Label("Copyright ©2013 sickle");
		version.setWidth( 200 );

		versionpanel.addMember( version );
		return versionpanel;
	}
}
