/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.sickle.pojo.edu.Org;
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
 * 学校名片
 * 
 * @author chenhao
 *
 */
public class OrgCard extends AbstractCard
{

	private HLayout information = new HLayout();
	
	private HLayout operate = new HLayout();
	
	private Org org;
	
	
	public OrgCard(Org org,String width,String height)
	{
		this.org = org;
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
	}
	
	private void initLayout()
	{
		this.setMargin( 2 );
		this.setStyleName( "orgcardborder" );
		information.setHeight( "90%" );
		information.setWidth100( );
		operate.setHeight( "10%" );
		operate.setWidth100( );
		operate.setAlign( Alignment.RIGHT );
		this.addMouseOverHandler( new MouseOverHandler( ) {
			@Override
			public void onMouseOver( MouseOverEvent event )
			{
				setStyleName( "orgcardborder-mousein" );
			}
		} );
		this.addMouseOutHandler( new MouseOutHandler( ) {
			@Override
			public void onMouseOut( MouseOutEvent event )
			{
				setStyleName( "orgcardborder" );
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
		
		Label name = new Label(org.getName( ));
		name.setHeight( "15px" );
		Label description = new Label( "" + org.getAddress( ));
		description.setHeight( "15px" );
		baseinformation.addMember( name );
		baseinformation.addMember( description );
		
		information.addMember( baseinformation );
		
		VLayout extendinformation = new VLayout( );
		extendinformation.setWidth( "65%" );
		extendinformation.setHeight( "100%" );
		extendinformation.setAlign( Alignment.CENTER );
		
		Label contact = new Label(org.getTelephone( ));
		extendinformation.addMember( contact );
		
		information.addMember( extendinformation );
	}
}
