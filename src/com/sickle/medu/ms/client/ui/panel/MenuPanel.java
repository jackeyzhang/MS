/**
 * 
 */
package com.sickle.medu.ms.client.ui.panel;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.Callback;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.sickle.medu.ms.client.ui.widget.label.LabelWithWhite;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * The panel with menu
 * 
 * 
 * @author chenhao
 *
 */
public class MenuPanel extends VLayout
{

	private VLayout logoPanel = new VLayout();
	
	private VLayout menuPanel = new VLayout();
	private VLayout menuSplitterPanel = new VLayout();
	private HLayout menuBarPanel = new HLayout();
	private List<MouseChangePanel> mcpanels = new ArrayList<MouseChangePanel>();
	
	private VLayout contentPanel = new VLayout();
	
	public MenuPanel(int width,int height)
	{
		super();
		setWidth( width );
		setHeight( height );
		
		init();
		
		addMember( logoPanel );
		addMember( menuPanel );
		addMember( contentPanel );
	}
	
	private void init()
	{
		logoPanel.setWidth( getWidth( ) );
		logoPanel.setHeight( "10%" );
		logoPanel.setAlign( Alignment.LEFT );
		logoPanel.setVisible( false );
		
		menuPanel.setWidth( getWidth( ) );
		menuPanel.setHeight( "5%" );
		menuPanel.setAlign( Alignment.LEFT );
		
		
		contentPanel.setWidth( getWidth( ) );
		contentPanel.setHeight( "70%" );
		contentPanel.setAlign( Alignment.CENTER );
		
		initMenuPanel();
	}
	
	private void initMenuPanel()
	{
		menuSplitterPanel.setWidth( getWidth( ) );
		menuSplitterPanel.setHeight( "3px" );
		menuSplitterPanel.setStyleName( "menupanel-splitter" );
		
		menuBarPanel.setWidth( getWidth( ) );
		menuBarPanel.setAlign( Alignment.LEFT );
		menuBarPanel.setHeight( "4%" );
		
		menuPanel.addMember( menuSplitterPanel );
		menuPanel.addMember( menuBarPanel );
	}

	public void addMenu(String menu,final Layout showpanel)
	{
		LabelWithWhite menuitem = new LabelWithWhite( menu );
		menuitem.setCursor( Cursor.POINTER );
		final MouseChangePanel p = new MouseChangePanel(true,"menupanel-choosepanel","menupanel-choosepanel-click");
		p.setWidth( 30 );
		p.addMember( menuitem );
		p.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				ScreenUtil.clearLayout( contentPanel );
				contentPanel.addMember( showpanel );
				for(MouseChangePanel anp : mcpanels)
				{
					anp.removeFixMouseinStyle("menupanel-choosepanel" );
				}
				p.fixMouseinStyle("menupanel-choosepanel-click" );
			}
		} );
		mcpanels.add( p );
		if( mcpanels.size( ) == 1 )
		{
			p.fixMouseinStyle("menupanel-choosepanel-click" );
			contentPanel.addMember( showpanel );
		}
		menuBarPanel.addMember( p );
	}
	
	public void addMenu(String menu,final Callback<?, ?> callback)
	{
		LabelWithWhite menuitem = new LabelWithWhite( menu );
		menuitem.setCursor( Cursor.POINTER );
		final MouseChangePanel p = new MouseChangePanel(true,"menupanel-choosepanel","menupanel-choosepanel-click");
		p.setWidth( 30 );
		p.addMember( menuitem );
		p.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				ScreenUtil.clearLayout( contentPanel );
				for(MouseChangePanel anp : mcpanels)
				{
					anp.removeFixMouseinStyle("menupanel-choosepanel" );
				}
				p.fixMouseinStyle("menupanel-choosepanel-click" );
				callback.onSuccess( null );
			}
		} );
		mcpanels.add( p );
		menuBarPanel.addMember( p );
	}
	
	/**
	 * @return the logoPanel
	 */
	public VLayout getLogoPanel( )
	{
		return logoPanel;
	}

	
	/**
	 * @return the menuPanel
	 */
	public VLayout getMenuPanel( )
	{
		return menuPanel;
	}

	
	/**
	 * @return the contentPanel
	 */
	public VLayout getContentPanel( )
	{
		return contentPanel;
	}
}
