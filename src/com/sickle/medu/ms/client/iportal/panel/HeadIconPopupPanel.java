/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.widget.HighlightImg;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * @author chenhao
 *
 */
public class HeadIconPopupPanel extends AbstractDialog
{
	
	public final static String ICONPATH = "icons/header/";
	
	private String chooseicon = IPageConst.DEFAULT_HEAD_ICON;

	public HeadIconPopupPanel(  )
	{
		super( "选择头像图标" );
		setSize( "150px", "100px" );
	}

	public static String[] femaleicons = {
			"user_female1.png","user_female2.png"
	};
	
	public static String[] maleicons = {
			"user_male1.png","user_male2.png"
	};
	
	@Override
	public Canvas getView( )
	{
		VLayout wholepanel = new VLayout( );
		wholepanel.setMembersMargin( 10 );
		wholepanel.setSize( "150px", "100px" );
		HLayout femalepanel = new HLayout( );
		femalepanel.setMembersMargin( 10 );
		femalepanel.setWidth100( );
		femalepanel.setAlign( Alignment.CENTER );
		for( int index = 0; index < femaleicons.length; index ++ )
		{
			femalepanel.addMember( getImg(femaleicons,index) );
		}
		
		HLayout malepanel = new HLayout( );
		malepanel.setWidth100( );
		malepanel.setMembersMargin( 10 );
		malepanel.setAlign( Alignment.CENTER );
		for( int index = 0; index < maleicons.length; index ++ )
		{
			malepanel.addMember( getImg(maleicons,index) );
		}
		
		wholepanel.addMember( femalepanel );
		wholepanel.addMember( malepanel );
		return wholepanel;
	}

	private Img getImg(String[] iconarray,int index){
		String iconurl = ICONPATH + iconarray[index];
		final HighlightImg img = new HighlightImg(iconurl);
		img.setSize( "50px", "50px" );
		img.setCursor( Cursor.POINTER );
		img.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				chooseicon = img.getSrc( );
				HeadIconPopupPanel.this.hide( );
				chooseCallback(chooseicon);
			}
		} );
		return img;
	}
	
	public String getHeadIcon()
	{
		return chooseicon;
	}
	
	public void chooseCallback(String chooseicon){}
	
}
