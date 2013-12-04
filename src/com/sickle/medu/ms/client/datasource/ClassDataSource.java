
package com.sickle.medu.ms.client.datasource;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.sickle.medu.ms.client.rpc.ClassesService;
import com.sickle.medu.ms.client.rpc.ClassesServiceAsync;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
import com.sickle.pojo.edu.Cls;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * 班级datasource
 * 
 * @author chenhao
 * 
 */
public class ClassDataSource extends GwtRpcDataSource
{

	private static ClassDataSource instance = null;

	public static ClassDataSource getInstance( )
	{
		if ( instance == null )
		{
			instance = new ClassDataSource( "ClassDataSource" );
		}
		return instance;
	}

	public ClassDataSource( String id )
	{
		getDataSource( Cls.class ).setID( id );
	}

	@Override
	protected void executeFetch( final String requestId,final DSRequest request,
			final DSResponse response )
	{
		if( request.getCriteria( ).getAttributeAsInt( "memberid" ) != null )
		{
			int memberid = request.getCriteria( ).getAttributeAsInt( "memberid" );
			ClassesServiceAsync service = ClassesService.Util.getInstance( );
			service.listClasses( memberid , new AsyncCallbackWithStatus<List<Cls>>( "" ) {
				@Override
				public void call( List<Cls> result )
				{
					List<ListGridRecord> list = new ArrayList<ListGridRecord>();
					if (result.size() > 0 )
					{
						for ( int i = 0; i < result.size( ); i++ )
						{
							ListGridRecord record = new ListGridRecord( );
							copyValues( result.get( i ), record );
							list.add(record);
						}
					}
					response.setData( list.toArray( new ListGridRecord[list.size( )] ) );
					response.setTotalRows( result.size( ) );
					getDataSource( Cls.class ).processResponse( requestId,
							response );
				}
			} );
			return ;
		}
		final Integer startIndex = ( request.getStartRow( ) < 0 ) ? 0 : request
				.getStartRow( );
		final int endIndex = ( request.getEndRow( ) == null ) ? -1 : request
				.getEndRow( );
		final String namequery = request.getCriteria( ).getAttributeAsString( getQueryName() );
		ClassesServiceAsync service = ClassesService.Util.getInstance( );
		service.listAllClasses( startIndex,endIndex,
				new AsyncCallbackWithStatus<List<Cls>>( ) {

					@Override
					public void call( List<Cls> result )
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
						getDataSource( Cls.class ).processResponse( requestId,
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
		Cls userRec = new Cls( );
		recopyValues( rec, userRec );
		ClassesServiceAsync service = ClassesService.Util.getInstance( );
		service.addClasses( userRec, new AsyncCallbackWithStatus<Cls>( ) {
			public void call( Cls result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Cls) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Cls.class )
						.processResponse( requestId, response );
			}
		} );
	}

	@Override
	protected void executeUpdate( final String requestId, DSRequest request,
			final DSResponse response )
	{
		JavaScriptObject data = request.getData( );
		ListGridRecord rec = new ListGridRecord( data );
		Cls userRec = new Cls( );
		recopyValues( rec, userRec );
		ClassesServiceAsync service = ClassesService.Util.getInstance( );
		service.modifyClasses( userRec, new AsyncCallbackWithStatus<Cls>( ) {
			public void call( Cls result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Cls) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Cls.class )
						.processResponse( requestId, response );
			}
		} );
	}

	@Override
	protected void executeRemove( final String requestId, DSRequest request,
			final DSResponse response )
	{
		JavaScriptObject data = request.getData( );
		final ListGridRecord rec = new ListGridRecord( data );
		Cls userRec = new Cls( );
		recopyValues( rec, userRec );
		ClassesServiceAsync service = ClassesService.Util.getInstance( );
		service.deleteClasses( userRec, new AsyncCallbackWithStatus<Cls>( ) {

			public void call( Cls result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				list[0] = rec;
				response.setData( list );
				getDataSource( Cls.class )
						.processResponse( requestId, response );
			}
		} );
	}
	
	public String getQueryName(){
		return "title";
	}

}
