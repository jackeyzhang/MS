/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.card;

import com.sickle.pojo.edu.School;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 学校名片
 * 
 * @author chenhao
 *
 */
public class SchoolCard extends VLayout
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private School school;
	
	
	public SchoolCard(School school,String width,String height)
	{
		this.school = school;
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
		
		Label name = new Label(school.getName( ));
		name.setHeight( "15px" );
		Label description = new Label( "" + school.getName( ));
		description.setHeight( "15px" );
		baseinformation.addMember( name );
		baseinformation.addMember( description );
		
		information.addMember( baseinformation );
		
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		
		Label contact = new Label(school.getOrg( ).getName( ));
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
