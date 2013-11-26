
package com.sickle.medu.ms.client.datasource;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.sickle.medu.ms.client.rpc.MessageService;
import com.sickle.medu.ms.client.rpc.MessageServiceAsync;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * 消息datasource
 * 
 * @author chenhao
 * 
 */
public class MessageDataSource extends GwtRpcDataSource
{

	private static MessageDataSource instance = null;

	public static MessageDataSource getInstance( )
	{
		if ( instance == null )
		{
			instance = new MessageDataSource( "MessageDataSource" );
		}
		return instance;
	}

	public MessageDataSource( String id )
	{
		getDataSource( Message.class ).setID( id );
	}

	@Override
	protected void executeFetch( final String requestId,final DSRequest request,
			final DSResponse response )
	{
		final Integer startIndex = ( request.getStartRow( ) < 0 ) ? 0 : request
				.getStartRow( );
		final int endIndex = ( request.getEndRow( ) == null ) ? -1 : request
				.getEndRow( );
		final String namequery = request.getCriteria( ).getAttributeAsString( getQueryName() );
		MessageServiceAsync service = MessageService.Util.getInstance( );
		service.listMessages( startIndex,
				new AsyncCallbackWithStatus<List<Message>>( ) {

					@Override
					public void call( List<Message> result )
					{
						int size = result.size( );
						if ( endIndex >= 0 )
						{
							if ( endIndex < startIndex )
							{
								size = 0;
							}
							else
							{
								size = endIndex - startIndex + 1;
							}
						}
						List<ListGridRecord> list = new ArrayList<ListGridRecord>();
						if ( size > 0 )
						{
							
							for ( int i = 0; i < result.size( ); i++ )
							{
								if ( i >= startIndex && i <= endIndex )
								{
									ListGridRecord record = new ListGridRecord( );
									if( null != namequery && !namequery.isEmpty( ))
									{
										if(result.get( i ).getTitle( ).contains( namequery  ))
										{
											copyValues( result.get( i ), record );
											list.add(record);
										}
									}
									else
									{
										copyValues( result.get( i ), record );
										list.add(record);
									}
									
								}
							}
						}
						response.setData( list.toArray( new ListGridRecord[list.size( )] ) );
						response.setTotalRows( result.size( ) );
						getDataSource( Message.class ).processResponse( requestId,
								response );
					}
				} );
	}

	@Override
	protected void executeAdd( final String requestId, final DSRequest request,
			final DSResponse response )
	{
		JavaScriptObject data = request.getData( );
		ListGridRecord rec = new ListGridRecord( data );
		Message userRec = new Message( );
		recopyValues( rec, userRec );
		MessageServiceAsync service = MessageService.Util.getInstance( );
		service.addMessage( userRec, new AsyncCallbackWithStatus<Message>( ) {
			public void call( Message result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Message) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Message.class )
						.processResponse( requestId, response );
			}
		} );
	}

	@Override
	protected void executeUpdate( final String requestId, DSRequest request,
			final DSResponse response )
	{
		executeAdd( requestId, request, response );
	}

	@Override
	protected void executeRemove( final String requestId, DSRequest request,
			final DSResponse response )
	{
		JavaScriptObject data = request.getData( );
		final ListGridRecord rec = new ListGridRecord( data );
		Message userRec = new Message( );
		recopyValues( rec, userRec );
		MessageServiceAsync service = MessageService.Util.getInstance( );
		service.deleteMessage( userRec, new AsyncCallbackWithStatus<Message>( ) {

			public void call( Message result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				list[0] = rec;
				response.setData( list );
				getDataSource( Message.class )
						.processResponse( requestId, response );
			}
		} );
	}
	
	public String getQueryName(){
		return "title";
	}

}
