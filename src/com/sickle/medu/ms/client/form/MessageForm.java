/**
 * 
 */
package com.sickle.medu.ms.client.form;

import java.util.List;

import com.sickle.medu.ms.client.datasource.MessageDataSource;
import com.sickle.medu.ms.client.form.withwidget.FormWidgetFactory;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;


/**
 * @author chenhao
 *
 */
public class MessageForm extends DynamicForm
{

	private DataSource ds = MessageDataSource.getInstance( ).getDataSource( Message.class );
	
	public MessageForm()
	{
		List<FormItem> items = FormWidgetFactory.getWidgets( ds );
		setDataSource( ds,  items.toArray( new FormItem[items.size( )] )  );
	}
	
}
