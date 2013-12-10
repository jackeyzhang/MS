/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import java.util.ArrayList;
import java.util.List;

import com.sickle.medu.ms.client.ui.panel.BluePanel;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 搜索面板
 * 
 * @author chenhao
 *
 */
public class SearchPanel extends VLayout
{

	private HLayout toppanel = new HLayout();
	
	private HLayout bottompanel = new HLayout();
	
	private static final int COUNT  = 4;
	
	private int width,height;
	
	private int index = 0;
	
	private List<Choosepanel> choosepanels = new ArrayList<Choosepanel>();
	
	public SearchPanel(int width,int height)
	{
		setWidth( width );
		setHeight( height );
		this.width = width;
		this.height = height;
		setStyleName( "searchpanel" );
		init();
	}
	
	private void init()
	{
		addMember( toppanel );
		addMember( bottompanel );
		BluePanel panel = new BluePanel( width+"px" , height - 25 + "px","搜索1");
		addItem( width/COUNT + "px", "最新动态", panel );
		
		BluePanel panel2 = new BluePanel( width+"px" , height - 25 + "px","搜索2");
		addItem( width/COUNT + "px", "搜索老师", panel2 );
		
		BluePanel panel3 = new BluePanel( width+"px" , height - 25 + "px","搜索3");
		addItem( width/COUNT + "px", "立即注册", panel3 );
		
		BluePanel panel4 = new BluePanel( width+"px" , height - 25 + "px","搜索4");
		addItem( width/COUNT + "px", "企业用户", panel4 );
		
		
	}
	
	private void addItem(String width,String title,final Canvas panel){
		Choosepanel cp = new Choosepanel( width , title){
			@Override
			public void handleclick( )
			{
				ScreenUtil.clearLayout( bottompanel );
				bottompanel.addMember( panel );
				int index = getIndex( );
				for( int i = 0 ; i < choosepanels.size( ); i ++ )
				{
					if( i == index)
					{
						continue;
					}
					choosepanels.get( i ).clearStyle( );
				}
			}
		};
		toppanel.addMember( cp );
		choosepanels.add( cp );
	}
	
	
	class Choosepanel extends HLayout{
		
		private int _index;
		
		public Choosepanel(String width,String title){
			_index = index ++;
			setSize( width, "25px" );
			setStyleName( "searchpanel-choosepanel" );
			setCursor( Cursor.POINTER );
			setAlign( Alignment.CENTER );
			addClickHandler( new ClickHandler( ) {
				@Override
				public void onClick( ClickEvent event )
				{
					setStyleName( "searchpanel-choosepanel-click" );
					handleclick();
				}
			} );
			addMember( new LabelWithWhite( title ) );
		}
		
		public void clearStyle(){
			setStyleName( "searchpanel-choosepanel" );
		}
		
		public void handleclick(){}
		
		public int getIndex()
		{
			return _index;
		}
	}

}
