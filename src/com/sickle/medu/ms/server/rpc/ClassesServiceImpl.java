/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Classes/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sickle.medu.ms.server.rpc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sickle.dao.DaoServiceFactory;
import com.sickle.dto.ClassesDTO;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.ClassesService;
import com.sickle.pojo.edu.Classes;
import com.sickle.service.itf.IClassesService;

public class ClassesServiceImpl extends RemoteServiceServlet implements ClassesService {

	private static final long serialVersionUID = -3779445533342577760L;
	
	private static IClassesService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( IClassesService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}



	@Override
	public List<Classes> listAllClasses(int startIndex, int length)
	{
		List<Classes> Classess = new ArrayList<Classes>();
		try
		{
			Classess = service.listClasses( startIndex, length );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return new ClassesDTO().to( Classess );
	}



	@Override
	public Classes addClasses( Classes Classes ) throws Exception
	{
		Classes oClasses = service.addClasses( Classes );
		return new ClassesDTO().to( oClasses );
	}



	@Override
	public Classes deleteClasses( Classes Classes ) throws Exception
	{
		if( service.removeClassesById( Classes.getId( ) ))
		{
			return new ClassesDTO().to( Classes );
		}
		return null;
	}

}
