/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.card;

import com.sickle.pojo.edu.Notice;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 课程名片
 * 
 * @author chenhao
 *
 */
public class NoticeCard extends AbstractCard
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private Notice notice;
	
	
	public NoticeCard(Notice notice,String width,String height)
	{
		this.notice = notice;
		this.setWidth( width );
		this.setHeight( height );
		init();
		addMember(information);
		addMember(operate);
	}
	
	private void init()
	{
		initLayout();
		initInformation();
		initOperate();
	}
	
	private void initLayout()
	{
		this.setMargin( 2 );
		this.setStyleName( "noticecardborder" );
		information.setHeight( "90%" );
		information.setWidth100( );
		operate.setHeight( "10%" );
		operate.setWidth100( );
		operate.setAlign( Alignment.RIGHT );
		this.addMouseOverHandler( new MouseOverHandler( ) {
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				setStyleName( "noticecardborder-mousein" );
			}
		} );
		this.addMouseOutHandler( new MouseOutHandler( ) {
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				setStyleName( "noticecardborder" );
			}
		} );
		this.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick( ClickEvent event )
			{
				SC.say( "say sth." );
			}
		} );
	}
	
	private void initInformation()
	{
		VLayout baseinformation = new VLayout();
		baseinformation.setWidth( "35%" );
		baseinformation.setHeight( "100%" );
		baseinformation.setAlign( Alignment.CENTER );
		
		
		Label content = new Label( "" + notice.getContent( ));
		content.setStyleName( "noticecardborder-content" );
		content.setHeight( "15px" );
		
		Label datadesc = new Label( "时间:" + notice.getDatedesc( ));
		datadesc.setStyleName( "noticecardborder-datedesc" );
		datadesc.setHeight( "15px" );
		
		Label address = new Label( "地址:" + notice.getAddress( ));
		address.setStyleName( "noticecardborder-address" );
		address.setHeight( "15px" );
		
		baseinformation.addMember( content );
		baseinformation.addMember( datadesc );
		baseinformation.addMember( address );
		
		information.addMember( baseinformation );
		
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		
		Label orgname = new Label( notice.getOrgname( ));
		orgname.setStyleName( "noticecardborder-orgname" );
		orgname.setHeight( "15px" );
		extendinformation.addMember( orgname );
		
		information.addMember( extendinformation );
	}
	
	private void initOperate()
	{
		
	}
}
