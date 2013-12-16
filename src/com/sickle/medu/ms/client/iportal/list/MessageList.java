package com.sickle.medu.ms.client.iportal.list;

import com.sickle.medu.ms.client.datasource.MessageDataSource;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;


public class MessageList extends ListGrid
{

	public MessageList()
	{
		setWidth( "90%" );
		setHeight( "90%" );
		setFixedFieldWidths( false );
		setAutoFitFieldWidths( true );
		setAutoFitHeaderHeights( true );
		setAutoFetchData( true );
		setDataSource( getDataSource( ) );
		setGroupByField( "send" );
		setSortField( "receivetime" );
		
	}
	
	public DataSource getDataSource( )
	{
		return MessageDataSource.getInstance( ).getDataSource( Message.class );
	}
}
