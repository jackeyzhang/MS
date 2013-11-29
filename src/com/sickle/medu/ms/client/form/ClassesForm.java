/**
 * 
 */

package com.sickle.medu.ms.client.form;

import java.util.List;

import com.sickle.medu.ms.client.datasource.ClassDataSource;
import com.sickle.medu.ms.client.form.withwidget.AbstractForm;
import com.sickle.pojo.edu.Cls;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * Classes form
 * 
 * @author chenhao
 * 
 */
public class ClassesForm extends AbstractForm
{

	@Override
	public DataSource getDS( )
	{
		return ClassDataSource.getInstance( ).getDataSource( Cls.class );
	}

	@Override
	public void preGetAddForm( List<FormItem> items )
	{
		super.preGetAddForm( items );
		this.setWidth( 400 );
		this.setColWidths( 150,250 );
		for ( FormItem item : items )
		{
			item.setTitleStyle( "h2" );
		}
	}

	@Override
	public void preGetModifyForm( List<FormItem> items )
	{
		super.preGetModifyForm( items );
		this.setWidth( 350 );
		this.setColWidths( 100,250 );
		for ( FormItem item : items )
		{
			item.setTitleStyle( "h2" );
		}
	}

	@Override
	public void preGetLookForm( List<FormItem> items )
	{
		super.preGetLookForm( items );
		this.setWidth( 400 );
		this.setColWidths( 150,250 );
		for ( FormItem item : items )
		{
			item.setTitleStyle( "h2" );
		}
	}

}
