/**
 * 
 */

package com.sickle.medu.ms.client.datasource;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;

/**
 * GWt异步返回datasource
 * 
 * @author chenhao
 * 
 */
public abstract class GwtRpcDataSource extends AbstractDataSource
{

	private DataSource datasource;

	public GwtRpcDataSource( )
	{
		datasource = new DataSource( ){
			@Override
			protected Object transformRequest( DSRequest request )
			{
			    String requestId = request.getRequestId();
		        DSResponse response = new DSResponse();
		        response.setAttribute("clientContext", request.getAttributeAsObject("clientContext"));
		        // Asume success
		        response.setStatus(0);
		        switch (request.getOperationType())
		        {
		        case FETCH:
		            executeFetch(requestId, request, response);
		            break;
		        case ADD:
		            executeAdd(requestId, request, response);
		            break;
		        case UPDATE:
		            executeUpdate(requestId, request, response);
		            break;
		        case REMOVE:
		            executeRemove(requestId, request, response);
		            break;
		        default:
		            break;
		        }
		        return request.getData();
			}
			
		};
		datasource.setDataProtocol( DSProtocol.CLIENTCUSTOM );
		datasource.setDataFormat( DSDataFormat.CUSTOM );
		datasource.setClientOnly( false );
	}
	
	protected abstract void executeFetch(String requestId, DSRequest request, DSResponse response);
	protected abstract void executeAdd(String requestId, DSRequest request, DSResponse response);
	protected abstract void executeUpdate(String requestId, DSRequest request, DSResponse response);
	protected abstract void executeRemove(String requestId, DSRequest request, DSResponse response);


	@Override
	public DataSource getDataSource( )
	{
		return datasource;
	}
	
	

}
