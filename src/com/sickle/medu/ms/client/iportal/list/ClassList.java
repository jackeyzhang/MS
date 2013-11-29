package com.sickle.medu.ms.client.iportal.list;

import com.sickle.medu.ms.client.datasource.ClassDataSource;
import com.sickle.pojo.edu.Cls;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;


public class ClassList extends ListGrid
{

	public ClassList()
	{
		setWidth( "90%" );
		setHeight( "90%" );
		setAutoFetchData( true );
		setDataSource( getDataSource( ) );
	}
	
	public DataSource getDataSource( )
	{
		return ClassDataSource.getInstance( ).getDataSource( Cls.class );
	}
}
