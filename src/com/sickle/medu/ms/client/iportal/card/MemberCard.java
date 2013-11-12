/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Img;
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
 * 老师名片
 * 
 * @author chenhao
 *
 */
public class MemberCard extends AbstractCard
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private Member member;
	
	
	public MemberCard(Member member,String width,String height)
	{
		super();
		this.setTooltip( "单击查看该老师更多信息" );
		this.member = member;
		this.setWidth( width );
		this.setHeight( height );
		init();
		information.setCursor( Cursor.POINTER );
		operate.setCursor( Cursor.POINTER );
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
		this.setStyleName( "membercardborder" );
		this.setCursor( Cursor.POINTER );
		this.addMouseOverHandler( new MouseOverHandler( ) {
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				setStyleName( "membercardborder-mousein" );
				operate.setVisible( true );
			}
		} );
		this.addMouseOutHandler( new MouseOutHandler( ) {
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				setStyleName( "membercardborder" );
				operate.setVisible( false );
			}
		} );
		this.addClickHandler( new ClickHandler( ) {
			
			@Override
			public void onClick( ClickEvent event )
			{
				boolean validok = valid();
				if( validok )
				{
					History.newItem( IPageConst.PAGE_MEMBER + IPageConst.PAGE_EQ + member.getId( ) );
				}
			}
		} );
		information.setHeight( "90%" );
		information.setWidth100( );
	}
	
	private void initInformation()
	{
		//个人信息
		VLayout baseinformation = new VLayout();
		baseinformation.setWidth( "35%" );
		baseinformation.setHeight( "100%" );
		baseinformation.setAlign( Alignment.CENTER );
		baseinformation.setCursor( Cursor.POINTER );
		
		Label name = new Label(member.getName( ));
		name.setHeight( 15 );
		name.setStyleName( "membercardname" );
		name.setCursor( Cursor.POINTER );
		
		Label orgname = new Label(member.getOrgname( ));
		orgname.setHeight( 15 );
		orgname.setStyleName( "membercardorgname" );
		orgname.setCursor( Cursor.POINTER );
		
		Label title = new Label( member.getTitle( ));
		title.setHeight( 15 );
		title.setStyleName( "membercardtitle" );
		title.setCursor( Cursor.POINTER );
		
		baseinformation.addMember( name );
		baseinformation.addMember( orgname );
		baseinformation.addMember( title );
		
		//简历
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		extendinformation.setCursor( Cursor.POINTER );
		
		Label resume = new Label(member.getResume( ));
		resume.setHeight( 15 );
		resume.setStyleName( "membercardresume" );
		resume.setCursor( Cursor.POINTER );
		
		extendinformation.addMember( resume );

		
		//分base和extends左右两部分
		information.addMember( baseinformation );
		information.addMember( extendinformation );
	}
	
	private void initOperate()
	{
		//操作
		operate.setAlign( Alignment.RIGHT );
		operate.setWidth100( );
		operate.setHeight( 16 );
		operate.setStyleName( "membercardoppanel" );
		operate.setVisible( false );
		
		Img message = new Img("icons/16/message.png");
		message.setPadding( 5 );
		message.setSize( "16px", "16px" );
		message.setTooltip( "留言" );
		message.setCursor( Cursor.POINTER );
		operate.addMember( message );
		
		Img telephone = new Img("crystal/16/actions/irc_online.png");
		telephone.setPadding( 5 );
		telephone.setSize( "16px", "16px" );
		telephone.setTooltip( "查看联系方式" );
		telephone.setCursor( Cursor.POINTER );
		operate.addMember( telephone );
		
		Img kecheng = new Img("demoApp/icon_view.png");
		kecheng.setPadding( 5 );
		kecheng.setSize( "16px", "16px" );
		kecheng.setTooltip( "查看开设课程" );
		kecheng.setCursor( Cursor.POINTER );
		operate.addMember( kecheng );
	}
}
