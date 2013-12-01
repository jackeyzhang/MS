package com.sickle.medu.ms.client.iportal.list;

import java.lang.reflect.Member;

import com.sickle.medu.ms.client.datasource.ClassDataSource;
import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.iportal.panel.StudentPanel;
import com.sickle.pojo.edu.Cls;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;


public class ClassList extends ListGrid
{

	public ClassList()
	{
		setWidth( "90%" );
		setHeight( "90%" );
		setAutoFetchData( true );
		setDrawAheadRatio(4); 
		setCanExpandRecords(true);
		setDataSource( getDataSource( ) );
	}
	
	public DataSource getDataSource( )
	{
		return ClassDataSource.getInstance( ).getDataSource( Cls.class );
	}

	@Override
	public DataSource getRelatedDataSource( ListGridRecord record )
	{
		return MemberDataSource.getInstance( ).getDataSource( Member.class );
	}

	@Override
	protected Canvas getExpansionComponent( ListGridRecord record )
	{
		return new StudentPanel();
	}
	
	
}
