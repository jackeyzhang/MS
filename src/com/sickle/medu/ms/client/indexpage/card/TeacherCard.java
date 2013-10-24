/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.card;

import com.sickle.pojo.edu.Teacher;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 老师名片
 * 
 * @author chenhao
 *
 */
public class TeacherCard extends VLayout
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
		information.setHeight( "90%" );
		information.setWidth100( );
		operate.setHeight( "10%" );
		operate.setWidth100( );
		operate.setAlign( Alignment.RIGHT );
	}
	
	private void initInformation()
	{
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
		
		/*Label description = new Label( teacher.getGrade( ) == null ? "新老师": teacher.getGrade( ) + "级");
		description.setHeight( 15 );
		description.setStyleName( "teachercarddescription" );*/
		
		baseinformation.addMember( name );
		baseinformation.addMember( orgname );
		baseinformation.addMember( title );
		
		
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
//		Label detail = new Label("detail");
//		detail.setStyleName( "PersonalCardop" );
//		operate.addMember( detail );
	}
}
