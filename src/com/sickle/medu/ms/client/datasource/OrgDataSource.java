package com.sickle.medu.ms.client.datasource;

import java.util.List;

import com.sickle.medu.ms.client.rpc.AsyncCallbackWithStatus;
import com.sickle.medu.ms.client.rpc.OrgService;
import com.sickle.medu.ms.client.rpc.OrgServiceAsync;
import com.sickle.medu.ms.client.rpc.RpcHelper;
import com.sickle.pojo.edu.Org;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.grid.ListGridRecord;


/**
 * 消息datasource
 * 
 * @author chenhao
 *
 */
public class OrgDataSource extends GwtRpcDataSource
{
	
	private static OrgDataSource instance = null;
	
    public static OrgDataSource getInstance() {
        if (instance == null) {
            instance = new OrgDataSource("OrgDataSource");
        }
        return instance;
    }

	public OrgDataSource(String id)
	{
		getDataSource( ).setID( id );
		
		DataSourceField fieldID = new DataSourceIntegerField("ID", "ID");
        fieldID.setPrimaryKey(true);
        fieldID.setHidden(true);
        getDataSource( ).addField(fieldID);
        
        DataSourceField loginame = new DataSourceTextField("LOGINNAME", "登录名");
        getDataSource( ).addField(loginame);
        
        DataSourceField manager = new DataSourceTextField("MANAGER", "管理者");
        getDataSource( ).addField(manager);
        
        DataSourceField name = new DataSourceTextField("NAME", "姓名");
        getDataSource( ).addField(name);
        
        DataSourceField telephone = new DataSourceTextField("TELEPHONE", "电话");
        getDataSource( ).addField(telephone);
	}

	@Override
	protected void executeFetch(final String requestId, DSRequest request,
			final DSResponse response )
	{
		 final int startIndex = (request.getStartRow() < 0) ? 0 : request.getStartRow();
		 final int endIndex = (request.getEndRow() == null) ? -1 : request.getEndRow();
		OrgServiceAsync service = RpcHelper.getService( OrgService.class );
		service.listAllOrg( startIndex, new AsyncCallbackWithStatus<List<Org>>( "loading"  ) {
			@Override
			public void call( List<Org> result )
			{
			    int size = result.size();
                if (endIndex >= 0) {
                    if (endIndex < startIndex) {
                        size = 0;
                    } else {
                        size = endIndex - startIndex + 1;
                    }
                }
                ListGridRecord[] list = new ListGridRecord[size];
                if (size > 0) {
                    for (int i = 0; i < result.size(); i++) {
                        if (i >= startIndex && i <= endIndex) {
                            ListGridRecord record = new ListGridRecord();
                            copyValues(result.get(i), record);
                            list[i - startIndex] = record;
                        }
                    }
                }
				response.setData(list);
				 response.setTotalRows(result.size());
				getDataSource().processResponse(requestId, response);
			}
		} );
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
	
   private static void copyValues(Org from, ListGridRecord to) {
        to.setAttribute("ID", from.getId( ));
        to.setAttribute("LOGINNAME", from.getLoginName( ));
        to.setAttribute("MANAGER", from.getManager( ));
        to.setAttribute("NAME", from.getName( ));
        to.setAttribute("TELEPHONE", from.getTelephone( ));
    }

}
