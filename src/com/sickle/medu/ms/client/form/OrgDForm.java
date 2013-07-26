/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.OrgDataSource;
import com.smartgwt.client.widgets.grid.ListGrid;


/**
 * @author chenhao
 *
 */
public class OrgDForm extends ListGrid 
{

	public OrgDForm()
	{
		setWidth100( );
		setHeight100( );
		setAutoFetchData(true);
		setDataSource( OrgDataSource.getInstance( ).getDataSource( ) );
	}
}
