
package com.sickle.medu.ms.client.datasource;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.sickle.medu.ms.client.rpc.StudentService;
import com.sickle.medu.ms.client.rpc.StudentServiceAsync;
import com.sickle.medu.ms.client.ui.util.AsyncCallbackWithStatus;
import com.sickle.pojo.edu.Student;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * student datasource
 * 
 * @author chenhao
 * 
 */
public class StudentDataSource extends GwtRpcDataSource
{

	private static StudentDataSource instance = null;

	public static StudentDataSource getInstance( )
	{
		if ( instance == null )
		{
			instance = new StudentDataSource( "StudentDataSource" );
		}
		return instance;
	}

	public StudentDataSource( String id )
	{
		getDataSource( Student.class ).setID( id );
	}

	@Override
	protected void executeFetch( final String requestId,final DSRequest request,
			final DSResponse response )
	{
		if( request.getCriteria( ).getAttributeAsIntArray( "id" ) != null )
		{
			int[] array = request.getCriteria( ).getAttributeAsIntArray( "id" );
			StudentServiceAsync service = StudentService.Util.getInstance( );
			service.listStudent( array, new AsyncCallbackWithStatus<List<Student>>( "" ) {
				@Override
				public void call( List<Student> result )
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
					getDataSource( Student.class ).processResponse( requestId,
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
		StudentServiceAsync service = StudentService.Util.getInstance( );
		service.listAllStudent( startIndex,endIndex,
				new AsyncCallbackWithStatus<List<Student>>( ) {

					@Override
					public void call( List<Student> result )
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
						getDataSource( Student.class ).processResponse( requestId,
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
		Student student = new Student( );
		recopyValues( rec, student );
		
		StudentServiceAsync service = StudentService.Util.getInstance( );
		Integer classid = rec.getAttributeAsInt( "classid" );
		
		if( classid == null )
		{
			
		}
		else
		{
			service.addStudent( classid,student, new AsyncCallbackWithStatus<Student>( ) {
				
				public void call( Student result )
				{
					ListGridRecord[] list = new ListGridRecord[1];
					ListGridRecord newRec = new ListGridRecord( );
					copyValues( (Student) result, newRec );
					list[0] = newRec;
					response.setData( list );
					getDataSource( Student.class )
							.processResponse( requestId, response );
				}
			} );
		}
	}

	@Override
	protected void executeUpdate( final String requestId, DSRequest request,
			final DSResponse response )
	{
		JavaScriptObject data = request.getData( );
		ListGridRecord rec = new ListGridRecord( data );
		Student userRec = new Student( );
		recopyValues( rec, userRec );
		StudentServiceAsync service = StudentService.Util.getInstance( );
		service.modifyStudent( userRec, new AsyncCallbackWithStatus<Student>( ) {

			public void call( Student result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord( );
				copyValues( (Student) result, newRec );
				list[0] = newRec;
				response.setData( list );
				getDataSource( Student.class )
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
		Student userRec = new Student( );
		
		Integer classid = rec.getAttributeAsInt( "classid" );
		
		recopyValues( rec, userRec );
		StudentServiceAsync service = StudentService.Util.getInstance( );
		service.deleteStudent(classid, userRec, new AsyncCallbackWithStatus<Student>( ) {

			public void call( Student result )
			{
				ListGridRecord[] list = new ListGridRecord[1];
				list[0] = rec;
				response.setData( list );
				getDataSource( Student.class )
						.processResponse( requestId, response );
			}
		} );
	}
	
	public String getQueryName(){
		return "name";
	}

}
