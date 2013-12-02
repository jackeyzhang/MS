
package com.sickle.medu.ms.client.datasource;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.sickle.medu.ms.client.rpc.MemberService;
import com.sickle.medu.ms.client.rpc.MemberServiceAsync;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * 教师datasource
 * 
 * @author chenhao
 * 
 */
public class MemberDataSource extends GwtRpcDataSource
{

	private static MemberDataSource instance = null;

	public static MemberDataSource getInstance( )
	{
		if ( instance == null )
		{
			instance = new MemberDataSource( "MemberDataSource" );
		}
		return instance;
	}

	public MemberDataSource( String id )
	{
		getDataSource( Member.class ).setID( id );
	}

	@Override
	protected void executeFetch( final String requestId,final DSRequest request,
			final DSResponse response )
	{
		if( request.getCriteria( ).getAttributeAsIntArray( "id" ) != null )
		{
			int[] array = request.getCriteria( ).getAttributeAsIntArray( "id" );
			MemberServiceAsync service = MemberService.Util.getInstance( );
			service.listMember( array, new AsyncCallbackWithStatus<List<Member>>( "" ) {
				@Override
				public void call( List<Member> result )
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
					getDataSource( Member.class ).processResponse( requestId,
							response );
				}
			} );
			return ;
		}
		final int startIndex = ( request.getStartRow( ) < 0 ) ? 0 : request
				.getStartRow( );
		final int endIndex = ( request.getEndRow( ) == null ) ? -1 : request
				.getEndRow( );
		final String namequery = request.getCriteria( ).getAttributeAsString( getQueryName() );
		MemberServiceAsync service = MemberService.Util.getInstance( );
		service.listAllMember( startIndex,endIndex,
				new AsyncCallbackWithStatus<List<Member>>( ) {

					@Override
					public void call( List<Member> result )
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
						getDataSource( Member.class ).processResponse( requestId,
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
		Member userRec = new Member( );
		recopyValues( rec, userRec );
		MemberServiceAsync service = MemberService.Util.getInstance( );
		service.addMember( userRec, new AsyncCallbackWithStatus<Member>( ) {

			public void call( Member result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Member) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Member.class )
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
		Member userRec = new Member( );
		recopyValues( rec, userRec );
		MemberServiceAsync service = MemberService.Util.getInstance( );
		service.modifyMember( userRec, new AsyncCallbackWithStatus<Member>( ) {

			public void call( Member result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Member) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Member.class )
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
		Member userRec = new Member( );
		recopyValues( rec, userRec );
		MemberServiceAsync service = MemberService.Util.getInstance( );
		service.deleteMember( userRec, new AsyncCallbackWithStatus<Member>( ) {

			public void call( Member result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				list[0] = rec;
				response.setData( list );
				getDataSource( Member.class )
						.processResponse( requestId, response );
			}
		} );
	}
	
	public String getQueryName(){
		return "name";
	}

}
