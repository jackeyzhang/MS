package com.sickle.medu.ms.client.datasource;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;


/**
 * 消息datasource
 * 
 * @author chenhao
 *
 */
public class MessageDataSource extends GwtRpcDataSource
{
	
	private static MessageDataSource instance = null;
	
    public static MessageDataSource getInstance() {
        if (instance == null) {
            instance = new MessageDataSource("MessageDataSource");
        }
        return instance;
    }

	public MessageDataSource(String id)
	{
		getDataSource( ).setID( id );
		
	}

	@Override
	protected void executeFetch( String requestId, DSRequest request,
			DSResponse response )
	{

	}

	@Override
	protected void executeAdd( String requestId, DSRequest request,
			DSResponse response )
	{

	}

	@Override
	protected void executeUpdate( String requestId, DSRequest request,
			DSResponse response )
	{

	}

	@Override
	protected void executeRemove( String requestId, DSRequest request,
			DSResponse response )
	{

	}

}
