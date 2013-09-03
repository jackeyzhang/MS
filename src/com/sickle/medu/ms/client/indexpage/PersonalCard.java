/**
 * 
 */
package com.sickle.medu.ms.client.indexpage;

import com.sickle.pojo.edu.Teacher;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 名片
 * 
 * @author chenhao
 *
 */
public class PersonalCard extends VLayout
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private Teacher teacher;
	
	
	public PersonalCard(Teacher teacher,String width,String height)
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
		this.setBorder( "2px solid gold" );
		this.setMargin( 2 );
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
		name.setHeight( "15px" );
		Label description = new Label( "" + teacher.getGrade( ));
		description.setHeight( "15px" );
		baseinformation.addMember( name );
		baseinformation.addMember( description );
		
		information.addMember( baseinformation );
		
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		
		Label contact = new Label(teacher.getContact( ));
		extendinformation.addMember( contact );
		
		information.addMember( extendinformation );
	}
	
	private void initOperate()
	{
		Button detailbutton = new Button("detail");
		operate.addMember( detailbutton );
	}
}
