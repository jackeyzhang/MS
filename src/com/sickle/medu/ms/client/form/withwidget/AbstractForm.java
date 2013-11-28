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
 * 抽象的form
 * 
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
		preGetAddForm(items);
		setDataSource( getDS(),  items.toArray( new FormItem[items.size( )] )  );
		afterGetAddForm(items);
		return this;
	}
	
	
	public DynamicForm getModifyForm()
	{
		List<FormItem> items = FormWidgetFactory.getWidgets( getDS(), FormConst.OP_MF );
		preGetModifyForm(items);
		setDataSource( getDS(),  items.toArray( new FormItem[items.size( )] )  );
		afterGetModifyForm(items);
		return this;
	}
	
	public DynamicForm getLookForm()
	{
		List<FormItem> items = FormWidgetFactory.getWidgets( getDS(), FormConst.OP_LOOK );
		preGetLookForm(items);
		setDataSource( getDS(),  items.toArray( new FormItem[items.size( )] )  );
		afterGetLookForm(items);
		return this;
	}
	
	public abstract DataSource getDS();
	
	public void preGetAddForm(List<FormItem> items ){}
	public void preGetModifyForm(List<FormItem> items ){}
	public void preGetLookForm(List<FormItem> items ){}
	
	public void afterGetAddForm(List<FormItem> items ){}
	public void afterGetModifyForm(List<FormItem> items ){}
	public void afterGetLookForm(List<FormItem> items ){}
}
