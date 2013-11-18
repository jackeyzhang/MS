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
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
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
		
		control1.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				count = 0;
				animateShow();
			}
		} );
		
		control2.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				count = 1;
				animateShow();
			}
		} );
		
		control3.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				count = 2;
				animateShow();
			}
		} );

		new Timer(){
			@Override
			public void run( )
			{
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
