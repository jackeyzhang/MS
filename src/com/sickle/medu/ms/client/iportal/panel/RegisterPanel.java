package com.sickle.medu.ms.client.iportal.panel;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.form.MemberDform;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class RegisterPanel extends HLayout
{

	private int op = 0;// 0 regiser;1 modify;2 look
	
	private MemberDform registerform;
	
	private ChooseIconPanel chooseiconpanel;
	
	public RegisterPanel( )
	{
		this(0);
	}
	
	public RegisterPanel(int op)
	{
		this.op = op;
		setWidth100( );
		setHeight( ScreenUtil.getHeightInt( IPageConst.REGISTER_HEIGHT_PER ) );
		setAlign( Alignment.CENTER );
		setStyleName( "registerpage" );
		init();
	}
	
	private void init()
	{
		VLayout contentpage = new VLayout();
		contentpage.setWidth( ScreenUtil.getWidthInt( IPageConst.REGISTER_WIDTH_PER ) );
		contentpage.setHeight( ScreenUtil.getHeightInt( IPageConst.REGISTER_HEIGHT_PER )  );
		contentpage.setStyleName( "abstractdialog-content" );
		
		HLayout registerpanel = new HLayout();
		registerform = new MemberDform( ScreenUtil.getWidthInt( IPageConst.REGISTER_WIDTH_PER ) );
		chooseiconpanel = new ChooseIconPanel();
		registerpanel.addMember( chooseiconpanel );
		registerpanel.addMember( registerform );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setPadding( 10 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.setAlign( Alignment.CENTER );
		
		Button okbutton = new Button("注册");
		okbutton.setWidth( 50 );
		okbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				precommit();
				boolean isValidate = registerform.validate( );
				if( isValidate == false)
				{
					return;
				}
				registerform.submit( );
				SC.say( "注册成功", new BooleanCallback( ) {
					@Override
					public void execute( Boolean value )
					{
						History.newItem( IPageConst.PAGE_LOGIN );
					}
				} );
				
			}
		} );
		
		Button cancelbutton = new Button("返回登陆");
		cancelbutton.setWidth( 50 );
		cancelbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				registerform.cancel( );
				History.newItem( IPageConst.PAGE_LOGIN);
			}
		} );
		
		buttonpanel.addMember( okbutton );
		buttonpanel.addMember( cancelbutton );
		
		contentpage.addMember( registerpanel );
		if(  op == 0 )
		{
			contentpage.addMember( buttonpanel );
		}
		
		addMember( contentpage );
	}
	
	public void edit( Member member )
	{
		ListGridRecord recode = new ListGridRecord();
		MemberDataSource.getInstance( ).copyValues( member, recode );
		registerform.editRecord( recode );
		boolean isteacher = member.getCharacter( ).equalsIgnoreCase( "teacher" );
		if(isteacher )
		{
			registerform.setValue( "forhelp", isteacher);
			registerform.showTeacherField( );
		}
		chooseiconpanel.setIcon( member.getIcon( ) );
	}

	
	/**
	 * @return the registerform
	 */
	public MemberDform getRegisterform( )
	{
		return registerform;
	}

	
	/**
	 * @param registerform the registerform to set
	 */
	public void setRegisterform( MemberDform registerform )
	{
		this.registerform = registerform;
	}
	
	
	public void precommit()
	{
		registerform.setIcon( chooseiconpanel.getChooseIcon( ) );
	}
	
}
