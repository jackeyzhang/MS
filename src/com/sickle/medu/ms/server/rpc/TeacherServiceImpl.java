/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Teacher/legal/epl-v10.html
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
import com.sickle.dto.TeacherDTO;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.TeacherService;
import com.sickle.pojo.edu.Teacher;
import com.sickle.service.itf.ITeacherService;

public class TeacherServiceImpl extends RemoteServiceServlet implements TeacherService {

	private static final long serialVersionUID = -3779445533342577760L;
	
	private static ITeacherService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( ITeacherService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}



	@Override
	public List<Teacher> listAllTeacher(int startIndex,int length )
	{
		List<Teacher> teachers = null;
		try
		{
			teachers = service.listTeachers(startIndex, length );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		if( teachers == null )
		{
			teachers = new ArrayList<Teacher>();
		}
		return new TeacherDTO().to( teachers );
	}



	@Override
	public Teacher addTeacher( Teacher Teacher ) throws Exception
	{
		Teacher oTeacher = service.addTeacher( Teacher );
		return new TeacherDTO().to( oTeacher );
	}



	@Override
	public Teacher deleteTeacher( Teacher Teacher ) throws Exception
	{
		if( service.removeTeacherById( Teacher.getId( ) ))
		{
			return new TeacherDTO().to( Teacher );
		}
		return null;
	}

}
