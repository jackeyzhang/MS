/**
 * 
 */

package com.sickle.medu.ms.client.iportal.card;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.widget.BluelittleLabel;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
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

	private HLayout information = new HLayout( );

	private HLayout operate = new HLayout( );

	private Member member;

	public MemberCard( Member member, String width, String height )
	{
		super( );
		this.setTooltip( "单击名字查看该老师更多信息" );
		this.member = member;
		this.setWidth( width );
		this.setHeight( height );
		init( );
		addMember( information );
		addMember( operate );
	}

	private void init( )
	{
		initLayout( );
		initInformation( );
		initOperate( );
	}

	private void initLayout( )
	{
		this.setMargin( 2 );
		this.setStyleName( "membercardborder" );
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
		information.setHeight( "90%" );
		information.setWidth100( );
	}

	private void initInformation( )
	{
		// 个人信息
		VLayout baseinformation = new VLayout( );
		baseinformation.setWidth( "35%" );
		baseinformation.setHeight( "100%" );
		baseinformation.setAlign( Alignment.CENTER );
		
		HLayout headiconandname = new HLayout();
		headiconandname.setHeight( 45 );
		headiconandname.setAlign( Alignment.CENTER );
		
		String icon = member.getIcon( );
		if( icon == null || icon.length( ) == 0 )
		{
			icon = IPageConst.DEFAULT_HEAD_ICON;
		}
		
		Img img = new Img(icon,40,40);

		Label name = new Label( member.getName( ) );
		name.setHeight( 15 );
		name.setStyleName( "membercardname" );
		name.setCursor( Cursor.POINTER );
		name.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				boolean validok = valid( );
				if ( validok )
				{
					History.newItem( IPageConst.PAGE_MEMBER
							+ IPageConst.PAGE_EQ + member.getId( ) );
				}
			}
		} );

		Label address = new Label( member.getCity( ) + "-" + member.getArea( ) );
		address.setHeight( 15 );
		address.setStyleName( "membercardorgname" );

		Label orgname = new Label( member.getOrgname( ) );
		orgname.setHeight( 15 );
		orgname.setStyleName( "membercardorgname" );

		Label title = new Label( member.getTitle( ) );
		title.setHeight( 15 );
		title.setStyleName( "membercardtitle" );

		headiconandname.addMember( img );
		baseinformation.addMember( headiconandname );
		baseinformation.addMember( name );
		baseinformation.addMember( address );
		baseinformation.addMember( orgname );
		baseinformation.addMember( title );

		// 简历
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );

		Label resume = new Label( member.getResume( ) );
		resume.setHeight( 15 );
		resume.setStyleName( "membercardresume" );

		extendinformation.addMember( resume );

		// 分base和extends左右两部分
		information.addMember( baseinformation );
		information.addMember( extendinformation );
	}

	private void initOperate( )
	{
		// 操作
		operate.setAlign( Alignment.RIGHT );
		operate.setWidth100( );
		operate.setHeight( 16 );
		operate.setStyleName( "membercardoppanel" );
		operate.setVisible( false );
		ClickHandler msgcl = new ClickHandler( ) {

			@Override
			public void onClick( ClickEvent event )
			{
				SC.askforValue( "请填写留言信息", "请输入信息内容", null );
			}
		};
		ClickHandler reportcl = new ClickHandler( ) {

			@Override
			public void onClick( ClickEvent event )
			{
				boolean validok = valid( );
				if ( validok )
				{
					History.newItem( IPageConst.PAGE_MEMBER
							+ IPageConst.PAGE_EQ + member.getId( ) );
				}
			}
		};
		ClickHandler detailcl = new ClickHandler( ) {

			@Override
			public void onClick( ClickEvent event )
			{
				boolean validok = valid( );
				if ( validok )
				{
					History.newItem( IPageConst.PAGE_MEMBER
							+ IPageConst.PAGE_EQ + member.getId( ) );
				}
			}
		};
		Canvas message = getControlWidget( "留言", msgcl, 40, "#ffce7b" );
		Canvas detail = getControlWidget( "查看", detailcl, 40, "#d9d6c3" );
		Canvas report = getControlWidget( "开设课程", reportcl, 60, "#c7a252" );

		operate.addMember( detail );
		operate.addMember( message );
		operate.addMember( report );
	}

	private Canvas getControlWidget( String controlname, ClickHandler cl,
			int width, final String backgroundColor )
	{
		final HLayout operate = new HLayout( );
		operate.setWidth( width );
		operate.setAlign( Alignment.CENTER );
		operate.setStyleName( "membercard-operate" );
		operate.setBackgroundColor( backgroundColor );
		BluelittleLabel operatelabel = new BluelittleLabel( controlname );
		operatelabel.setAlign( Alignment.CENTER );
		operatelabel.addClickHandler( cl );
		operatelabel.setWidth( width );
		operate.addMember( operatelabel );
		operate.addMouseOverHandler( new MouseOverHandler( ) {

			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				operate.setStyleName( "membercard-operate-mousein" );
				operate.setBackgroundColor( "#e0861a" );
			}
		} );
		operate.addMouseOutHandler( new MouseOutHandler( ) {

			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				operate.setStyleName( "membercard-operate" );
				operate.setBackgroundColor( backgroundColor );
			}
		} );
		return operate;
	}
}
