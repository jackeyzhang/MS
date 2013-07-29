/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sickle.medu.ms.server.rpc;

import java.util.List;

import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sickle.dao.DaoServiceFactory;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.OrgService;
import com.sickle.pojo.edu.Org;
import com.sickle.service.itf.IOrgService;

public class OrgServiceImpl extends RemoteServiceServlet implements OrgService {

	private static final long serialVersionUID = -3779445533342577760L;
	
	private static IOrgService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( IOrgService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}



	@Override
	public List<Org> listAllOrg(int startIndex)
	{
		List<Org> orgs = service.listAllOrg( );
		for(Org org : orgs){
			org.setSchools( null );
		}
		return orgs;
	}



	@Override
	public Org addOrg( Org org ) throws Exception
	{
		return service.addOrg( org );
	}



	@Override
	public Org deleteOrg( Org org ) throws Exception
	{
		if( service.removeOrgById( org.getId( ) ))
		{
			return org;
		}
		return null;
	}

}
