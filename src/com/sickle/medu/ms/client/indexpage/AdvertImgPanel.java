/**
 * 
 */
package com.sickle.medu.ms.client.indexpage;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Timer;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 大图片展示区域
 * 
 * @author chenhao
 *
 */

public class AdvertImgPanel extends VLayout
{
	
	public  AdvertImgPanel()
	{
        setWidth100( );
        setHeight( "320px" );
        loadPanel();
	}
	
	private void loadPanel()
	{
		HLayout spacePanel = new HLayout( );
		spacePanel.setHeight( "20px" );
		addMember( spacePanel );
		
		final HLayout imagePanel = new HLayout( );
		imagePanel.setAlign( Alignment.CENTER );
		
		Img img1 = new Img("slideshow/sliderimage1.jpg",1200,300);
		img1.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH ) );
		Img img2 = new Img("slideshow/sliderimage2.jpg",1200,300);
		img2.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH ) );
		Img img3 = new Img("slideshow/sliderimage3.jpg",1200,300);
		img3.setWidth( ScreenUtil.getWidth( IPageConst.PAGE_WIDTH ) );
		
		final List<Img> imgs = new ArrayList<Img>();
		imgs.add( img1 );
		imgs.add( img2 );
		imgs.add( img3 );
		
		addMember( imagePanel );

		new Timer(){
			private int count = 0;
			@Override
			public void run( )
			{
				if( count == imgs.size( ) )
				{
					count = 0;
				}
				for( Canvas cas : imagePanel.getMembers( ) )
				{
					imagePanel.removeMember( cas );
				}
				imagePanel.addMember( imgs.get( count ) );
				imagePanel.redraw( );
				imagePanel.animateShow( AnimationEffect.WIPE, null, 500 );
				count ++ ;
			}
		}.scheduleRepeating( 5000 );
	}

}
