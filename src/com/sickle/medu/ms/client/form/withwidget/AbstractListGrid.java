/**
 * 
 */
package com.sickle.medu.ms.client.form.withwidget;

import com.sickle.medu.ms.client.datasource.field.MaskField;
import com.sickle.uireflect.Mask;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.grid.ListGrid;


/**
 * @author chenhao
 *
 */
public class AbstractListGrid extends ListGrid
{
	
	public AbstractListGrid()
	{
		
	}
	
	protected void maskAndSetFields(DataSource ds)
	{
		DataSourceField[] fs = ds.getFields( );
		for( DataSourceField f : fs)
		{
			if( null == f )
			{
				continue;
			}
			int mask = f.getAttributeAsInt( MaskField.MASK );
			if( (mask & Mask.showInList.getValue( )) == 0)
			{
				f.setHidden( true );
			}
		}
		this.setDataSource( ds );
	}

}
