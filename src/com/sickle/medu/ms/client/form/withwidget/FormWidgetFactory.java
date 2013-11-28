/**
 * 
 */
package com.sickle.medu.ms.client.form.withwidget;

import java.util.ArrayList;
import java.util.List;

import com.sickle.medu.ms.client.datasource.field.MaskField;
import com.sickle.medu.ms.client.form.FormConst;
import com.sickle.uireflect.FieldType;
import com.sickle.uireflect.Mask;
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
	
	
	public static List<FormItem> getWidgets(DataSource ds ,String op)
	{
		List<FormItem> items = new ArrayList<FormItem>();
		for(DataSourceField field : ds.getFields( ))
		{
			if( field.getPrimaryKey( ) )
			{
				continue;
			}
			items.add(getWidget(field,op));
		}
		return items;
	}
	
	public static FormItem getWidget(DataSourceField mfield,String op)
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
		
		int mask = mfield.getAttributeAsInt( MaskField.MASK );
		if( op.equals( FormConst.OP_LOOK ))
		{
			item.disable( );
		}
		else if( op.equals( FormConst.OP_ADD  ))
		{
			if( (mask & Mask.showInAdd.getValue( )) == 0 )
			{
				item.hide( );
			}
			if( (mask & Mask.enInAdd.getValue( )) == 0 )
			{
				item.disable( );
			}
		}
		else if( op.equals( FormConst.OP_MF  ))
		{
			if( (mask & Mask.showInEdit.getValue( )) == 0 )
			{
				item.hide( );
			}
			if( (mask & Mask.enInEdit.getValue( )) == 0 )
			{
				item.disable( );
			}
		}
		else 
		{
			item.enable( );
		}
		item.setName( mfield.getName( ) ); 
		return item;
	}
	
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