/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.card;

import com.sickle.pojo.edu.Classes;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 课程名片
 * 
 * @author chenhao
 *
 */
public class ClassCard extends VLayout
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private Classes classes;
	
	
	public ClassCard(Classes classes,String width,String height)
	{
		this.classes = classes;
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
		this.setStyleName( "cardborder" );
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
		
		Label name = new Label(classes.getName( ));
		name.setHeight( "15px" );
		Label description = new Label( "" + classes.getName( ));
		description.setHeight( "15px" );
		baseinformation.addMember( name );
		baseinformation.addMember( description );
		
		information.addMember( baseinformation );
		
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		
		Label contact = new Label(classes.getSchool( ).getName( ));
		extendinformation.addMember( contact );
		
		information.addMember( extendinformation );
	}
	
	private void initOperate()
	{
//		Label detail = new Label("detail");
//		detail.setStyleName( "PersonalCardop" );
//		operate.addMember( detail );
	}
}
