package com.sickle.medu.ms.client.iportal.list;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.form.withwidget.AbstractListGrid;
import com.sickle.medu.ms.client.rpc.ClassesService;
import com.sickle.medu.ms.client.rpc.ClassesServiceAsync;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;

/**
 * 学生list
 * 
 * @author chenhao
 *
 */
public class StudentList extends AbstractListGrid
{

	public StudentList()
	{
		setWidth( "90%" );
		setHeight( "90%" );
		setAutoFetchData( false );
		maskAndSetFields( getDataSource() );
	}
	
	public DataSource getDataSource( )
	{
		return MemberDataSource.getInstance( ).getDataSource( Member.class );
	}
	
	public void fetchStudentByClassid(final int classid )
	{
		ClassesServiceAsync service = ClassesService.Util.getInstance( );
		service.findStudents( classid, new AsyncCallback<List<Member>>( ) {
			
			@Override
			public void onSuccess( List<Member> result )
			{
				Integer[] stuids = new Integer[result.size( )];
				int i = 0;
				for(Member member : result )
				{
					stuids[i++] = member.getId( );
				}
				Criteria criteria = new Criteria();
				criteria.addCriteria( "id", stuids );
				fetchData( criteria );
			}
			
			@Override
			public void onFailure( Throwable caught )
			{
				SC.say( "loading error" + caught.getMessage( ));
			}
		} );
	}
}
