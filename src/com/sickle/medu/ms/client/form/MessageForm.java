/**
 * 
 */

package com.sickle.medu.ms.client.form;

import java.util.List;

import com.sickle.medu.ms.client.datasource.MessageDataSource;
import com.sickle.medu.ms.client.form.withwidget.AbstractForm;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * Message form
 * 
 * @author chenhao
 * 
 */
public class MessageForm extends AbstractForm
{

	@Override
	public DataSource getDS( )
	{
		return MessageDataSource.getInstance( ).getDataSource( Message.class );
	}

	@Override
	public void preGetAddForm( List<FormItem> items )
	{
		super.preGetAddForm( items );
		this.setWidth( 500 );
		this.setColWidths( 100,400 );
		for ( FormItem item : items )
		{
			item.setTitleStyle( "form_texttitle" );
			item.setWidth( 350 );
		}
	}

	@Override
	public void preGetModifyForm( List<FormItem> items )
	{
		super.preGetModifyForm( items );
		this.setWidth( 500 );
		this.setColWidths( 100,400 );
		for ( FormItem item : items )
		{
			item.setTitleStyle( "form_texttitle" );
			item.setWidth( 350 );
		}
	}

	@Override
	public void preGetLookForm( List<FormItem> items )
	{
		super.preGetLookForm( items );
		this.setWidth( 500 );
		this.setColWidths( 100,400 );
		for ( FormItem item : items )
		{
			item.setTitleStyle( "form_texttitle" );
			item.setWidth( 350 );
		}
	}

}
