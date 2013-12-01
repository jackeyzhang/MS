package com.sickle.medu.ms.client.iportal.list;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;


public class MemberList extends ListGrid
{

	public MemberList()
	{
		setWidth( "90%" );
		setHeight( "90%" );
		setAutoFetchData( true );
		setDataSource( getDataSource( ) );
	}
	
	public DataSource getDataSource( )
	{
		return MemberDataSource.getInstance( ).getDataSource( Member.class );
	}
}
