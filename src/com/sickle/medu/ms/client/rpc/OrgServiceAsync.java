/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Org;


/**
 * @author chenhao
 *
 */
public interface OrgServiceAsync
{


	void listAllOrg( int s,int length, AsyncCallback<List<Org>> callback );

	void addOrg( Org org, AsyncCallback<Org> callback );

	void deleteOrg( Org org, AsyncCallback<Org> callback );

	void getOrgById(int orgId, AsyncCallback<Org> callback);

}
