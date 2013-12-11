package com.sickle.medu.ms.client.iportal.list;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.medu.ms.client.datasource.StudentDataSource;
import com.sickle.medu.ms.client.form.withwidget.AbstractListGrid;
import com.sickle.medu.ms.client.rpc.ClassesService;
import com.sickle.medu.ms.client.rpc.ClassesServiceAsync;
import com.sickle.pojo.edu.Student;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridRecord;

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
		setHeaderHeight(40); 
		setAutoFetchData( false );
		setSelectionType( SelectionStyle.SINGLE );
		DataSource ds = getDataSource();
		maskAndSetFields( ds );
		
		ds.getField( "name" ).setTitle( "学生名字" );
		setHeaderSpans(new HeaderSpan("学生列表", ds.getFieldNames( )));
	}
	
	public DataSource getDataSource( )
	{
		return StudentDataSource.getInstance( ).getDataSource( Student.class );
	}
	
	public void fetchStudentByClassid(final int classid )
	{
		ClassesServiceAsync service = ClassesService.Util.getInstance( );
		service.findStudents( classid, new AsyncCallback<List<Student>>( ) {
			@Override
			public void onSuccess( List<Student> result )
			{
				List<Record> records = new ArrayList<Record>();
				for( Student m : result )
				{
					ListGridRecord record = new ListGridRecord();
					StudentDataSource.getInstance( ).copyValues( m, record );
					records.add( record );
				}
				Record[] rs = records.toArray( new Record[records.size( )]);
				setData( rs );
			}
			
			@Override
			public void onFailure( Throwable caught )
			{
				SC.say( "loading error" + caught.getMessage( ));
			}
		} );
	}
}
