/**
 * 
 */
package com.sickle.medu.ms.client.datasource;

import com.smartgwt.client.data.DataSource;


/**
 * @author chenhao
 *
 */
public interface IDataSource
{
	
	<T> DataSource getDataSource(Class<T> cls);
}
