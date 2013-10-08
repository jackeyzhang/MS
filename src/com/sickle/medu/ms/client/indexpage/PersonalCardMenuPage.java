/**
 * 
 */
package com.sickle.medu.ms.client.indexpage;

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 名片导航
 * 
 * @author chenhao
 *
 */
public class PersonalCardMenuPage extends VLayout
{
	
	private String[] types = new String[]{"汉语老师","英语老师","数学老师"};

	public PersonalCardMenuPage(String width,String height)
	{
		this.setWidth( width );
		this.setHeight( height );
		this.setStyleName( "PersonalCardMenuPage" );
		
		init();
	}
	
	private void init()
	{
		for( String type : types )
		{
			Label l = new Label( type );
			l.setStyleName( "PersonalCardMenuPageLabel" );
			addMember( l );
		}
	}
}
