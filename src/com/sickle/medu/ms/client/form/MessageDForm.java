/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MessageDataSource;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.data.DataSource;


/**
 * 消息表单
 * 
 * @author chenhao
 *
 */
public class MessageDForm extends AbstractListDForm 
{

	public MessageDForm()
	{
		super();
	}

	@Override
	public int getOP( )
	{
		return -1;
	}

	@Override
	public DataSource getDataSource( )
	{
		return MessageDataSource.getInstance( ).getDataSource( Message.class );
	}

	@Override
	public String getQueryName( )
	{
		return MessageDataSource.getInstance( ).getQueryName( );
	}

	@Override
	public String getAddButtonTitle( )
	{
		return "发送消息";
	}

	@Override
	public String getModifyButtonTitle( )
	{
		return "修改消息";
	}

	@Override
	public String getRemoveButtonTitle( )
	{
		return "删除消息";
	}

	@Override
	public String getSearchButtonTitle( )
	{
		return "根据内容查找";
	}
	
	
}
