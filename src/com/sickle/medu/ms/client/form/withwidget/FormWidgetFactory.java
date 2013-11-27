/**
 * 
 */
package com.sickle.medu.ms.client.form.withwidget;

import java.util.ArrayList;
import java.util.List;

import com.sickle.medu.ms.client.datasource.field.MaskField;
import com.sickle.uireflect.FieldType;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;


/**
 * form widget factory
 * 
 * @author chenhao
 *
 */
public class FormWidgetFactory
{
	
	public static List<FormItem> getWidgets(DataSource ds )
	{
		List<FormItem> items = new ArrayList<FormItem>();
		for(DataSourceField field : ds.getFields( ))
		{
			if( field.getPrimaryKey( ) )
			{
				continue;
			}
			items.add(getWidget(field));
		}
		return items;
	}
	
	public static FormItem getWidget(DataSourceField mfield)
	{
		FormItem item = null;
		if( mfield.getAttribute( MaskField.STYPE).equals( FieldType.Integer.toString( ) ) )
		{
			item = new IntegerItem();
		}
		else if( mfield.getAttribute( MaskField.STYPE).equals( FieldType.Password.toString( ) ) )
		{
			item = new PasswordItem();
		}
		else if( mfield.getAttribute( MaskField.STYPE).equals( FieldType.TextArea.toString( ) ) )
		{
			item = new TextAreaItem();
		}
		else if( mfield.getAttribute( MaskField.STYPE).equals( FieldType.String.toString( ) ) )
		{
			item = new TextItem();
		}
		else if( mfield.getAttribute( MaskField.STYPE).equals( FieldType.Date.toString( ) ) )
		{
			item = new DateItem();
		}
		else if( mfield.getAttribute( MaskField.STYPE).equals( FieldType.DateTime.toString( ) ) )
		{
			item = new DateTimeItem();
		}
		item.setName( mfield.getName( ) );
		return item;
	}

}
