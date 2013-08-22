
package com.sickle.medu.ms.client.datasource;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.sickle.medu.ms.client.rpc.TeacherService;
import com.sickle.medu.ms.client.rpc.TeacherServiceAsync;
import com.sickle.medu.ms.client.rpc.RpcHelper;
import com.sickle.medu.ms.client.rpc.util.AsyncCallbackWithStatus;
import com.sickle.pojo.edu.Teacher;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * 消息datasource
 * 
 * @author chenhao
 * 
 */
public class TeacherDataSource extends GwtRpcDataSource
{

	private static TeacherDataSource instance = null;

	public static TeacherDataSource getInstance( )
	{
		if ( instance == null )
		{
			instance = new TeacherDataSource( "TeacherDataSource" );
		}
		return instance;
	}

	public TeacherDataSource( String id )
	{
		getDataSource( Teacher.class ).setID( id );
	}

	@Override
	protected void executeFetch( final String requestId,final DSRequest request,
			final DSResponse response )
	{
		final int startIndex = ( request.getStartRow( ) < 0 ) ? 0 : request
				.getStartRow( );
		final int endIndex = ( request.getEndRow( ) == null ) ? -1 : request
				.getEndRow( );
		final String namequery = request.getCriteria( ).getAttributeAsString( getQueryName() );
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.listAllTeacher( startIndex,
				new AsyncCallbackWithStatus<List<Teacher>>( ) {

					@Override
					public void call( List<Teacher> result )
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
										if(result.get( i ).getName( ).contains( namequery  ))
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
						getDataSource( Teacher.class ).processResponse( requestId,
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
		Teacher userRec = new Teacher( );
		copyValues( rec, userRec );
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.addTeacher( userRec, new AsyncCallbackWithStatus<Teacher>( ) {

			public void call( Teacher result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Teacher) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Teacher.class )
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
		Teacher userRec = new Teacher( );
		copyValues( rec, userRec );
		TeacherServiceAsync service = RpcHelper.getService( TeacherService.class );
		service.deleteTeacher( userRec, new AsyncCallbackWithStatus<Teacher>( ) {

			public void call( Teacher result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				list[0] = rec;
				response.setData( list );
				getDataSource( Teacher.class )
						.processResponse( requestId, response );
			}
		} );
	}
	
	public String getQueryName(){
		return "name";
	}

}
