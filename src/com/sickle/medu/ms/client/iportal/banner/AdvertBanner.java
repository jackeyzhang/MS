/**
 * 
 */
package com.sickle.medu.ms.client.iportal.banner;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Timer;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.panel.WithRightLittleControlPanel;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 大图片展示区域
 * 
 * @author chenhao
 *
 */

public class AdvertBanner extends VLayout
{
	
	private int count = 0;
	
	private List<Img> imgs = new ArrayList<Img>();
	
	private HLayout imagePanel = new HLayout( );
	
	private HLayout controlPanel = new HLayout( );
	
	private Canvas control1,control2,control3;
	
	private boolean started = true;
	
	public  AdvertBanner(double width,double height)
	{
        setWidth100( );
        setHeight( ScreenUtil.getHeight( height ) );
        loadPanel(width);
	}
	
	public  AdvertBanner()
	{
        setWidth100( );
        setHeight( ScreenUtil.getHeight( 0.36 ) );
        loadPanel(IPageConst.PAGE_WIDTH);
	}
	
	private void loadPanel(double width)
	{
		HLayout spacePanel = new HLayout( );
		spacePanel.setHeight( "20px" );
		addMember( spacePanel );
		
		imagePanel.setAlign( Alignment.CENTER );
		controlPanel.setAlign( Alignment.CENTER );
		
		WithRightLittleControlPanel wcontrolPanel = new WithRightLittleControlPanel(20,ScreenUtil.getWidthInt( width ));
		control1 = wcontrolPanel.addControl( "1", 60 );
		control2 = wcontrolPanel.addControl( "2", 60 );
		control3 = wcontrolPanel.addControl( "3", 60 );
		controlPanel.addMember( wcontrolPanel );
		
		addMember( imagePanel );
		addMember( controlPanel );
		
		
		Img img1 = new Img("slideshow/sliderimage1.jpg",ScreenUtil.getWidthInt( width ),ScreenUtil.getHeightInt( 0.35 ));
		Img img2 = new Img("slideshow/sliderimage2.jpg",ScreenUtil.getWidthInt( width ),ScreenUtil.getHeightInt( 0.35 ));
		Img img3 = new Img("slideshow/sliderimage3.jpg",ScreenUtil.getWidthInt( width ),ScreenUtil.getHeightInt( 0.35 ));
		
		imgs.add( img1 );
		imgs.add( img2 );
		imgs.add( img3 );
		
		
		control1.addMouseOverHandler( new MouseOverHandler( ) {
			
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				count = 0;
				started = false;
				animateShow();
			}
		} );
		
		control1.addMouseOutHandler( new MouseOutHandler( ) {
			
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				started = true;				
			}
		} );
		
		control2.addMouseOverHandler( new MouseOverHandler( ) {
				
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				count = 1;
				started = false;
				animateShow();
			}
		} );
		
		control2.addMouseOutHandler( new MouseOutHandler( ) {
			
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				started = true;				
			}
		} );

		control3.addMouseOverHandler( new MouseOverHandler( ) {
			
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				count = 2;
				started = false;
				animateShow();
			}
		} );
		
		control3.addMouseOutHandler( new MouseOutHandler( ) {
			
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				started = true;				
			}
		} );

		new Timer(){
			@Override
			public void run( )
			{
				if( started )
				animateShow();
			}
		}.scheduleRepeating( 4000 );
	}

	
	private void animateShow()
	{
		if( count == imgs.size( ) )
		{
			count = 0;
		}
		for( Canvas cas : imagePanel.getMembers( ) )
		{
			imagePanel.removeMember( cas );
		}
		imagePanel.setVisible( false );
		imagePanel.addMember( imgs.get( count ) );
		imagePanel.animateShow( AnimationEffect.FADE, null, 2000 );
		count ++ ;
	}
	
	
}
