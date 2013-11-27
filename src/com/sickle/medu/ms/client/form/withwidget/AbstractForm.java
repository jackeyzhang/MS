/**
 * 
 */
package com.sickle.medu.ms.client.form.withwidget;

import java.util.List;

import com.sickle.medu.ms.client.form.FormConst;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;


/**
 * @author chenhao
 *
 */
public abstract class AbstractForm extends DynamicForm
{
	
	public AbstractForm()
	{
		super();
	}

	public DynamicForm getAddForm()
	{
		List<FormItem> items = FormWidgetFactory.getWidgets( getDS(), FormConst.OP_ADD );
		setDataSource( getDS(),  items.toArray( new FormItem[items.size( )] )  );
		return this;
	}
	
	
	public DynamicForm getModifyForm()
	{
		List<FormItem> items = FormWidgetFactory.getWidgets( getDS(), FormConst.OP_MF );
		setDataSource( getDS(),  items.toArray( new FormItem[items.size( )] )  );
		return this;
	}
	
	public DynamicForm getLookForm()
	{
		List<FormItem> items = FormWidgetFactory.getWidgets( getDS(), FormConst.OP_LOOK );
		setDataSource( getDS(),  items.toArray( new FormItem[items.size( )] )  );
		return this;
	}
	
	public abstract DataSource getDS();
}
