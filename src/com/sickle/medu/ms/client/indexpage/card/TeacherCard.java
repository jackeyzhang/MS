/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.card;

import com.sickle.pojo.edu.Teacher;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.util.SC;
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
public class TeacherCard extends AbstractCard
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private Teacher teacher;
	
	
	public TeacherCard(Teacher teacher,String width,String height)
	{
		this.teacher = teacher;
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
		this.setStyleName( "teachercardborder" );
		this.addMouseOverHandler( new MouseOverHandler( ) {
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				setStyleName( "teachercardborder-mousein" );
				setCursor( Cursor.HAND );
				operate.setVisible( true );
			}
		} );
		this.addMouseOutHandler( new MouseOutHandler( ) {
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				setStyleName( "teachercardborder" );
				setCursor( Cursor.DEFAULT );
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
					SC.say( "do smth" );
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
		
		Label name = new Label(teacher.getName( ));
		name.setHeight( 15 );
		name.setStyleName( "teachercardname" );
		
		Label orgname = new Label(teacher.getOrgname( ));
		orgname.setHeight( 15 );
		orgname.setStyleName( "teachercardorgname" );
		
		Label title = new Label( teacher.getTitle( ));
		title.setHeight( 15 );
		title.setStyleName( "teachercardtitle" );
		
		baseinformation.addMember( name );
		baseinformation.addMember( orgname );
		baseinformation.addMember( title );
		
		//简历
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		
		Label resume = new Label(teacher.getResume( ));
		resume.setHeight( 15 );
		resume.setStyleName( "teachercardresume" );
		
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
		operate.setStyleName( "teachercardoppanel" );
		operate.setVisible( false );
		
		Img message = new Img("icons/16/message.png");
		message.setPadding( 5 );
		message.setSize( "16px", "16px" );
		message.setTooltip( "留言" );
		operate.addMember( message );
		
		Img telephone = new Img("crystal/16/actions/irc_online.png");
		telephone.setPadding( 5 );
		telephone.setSize( "16px", "16px" );
		telephone.setTooltip( "查看联系方式" );
		operate.addMember( telephone );
		
		Img kecheng = new Img("demoApp/icon_view.png");
		kecheng.setPadding( 5 );
		kecheng.setSize( "16px", "16px" );
		kecheng.setTooltip( "查看开设课程" );
		operate.addMember( kecheng );
	}
}
