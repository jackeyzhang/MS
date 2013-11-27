/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MessageDataSource;
import com.sickle.medu.ms.client.form.withwidget.AbstractForm;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.data.DataSource;


/**
 * 
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
	
}
