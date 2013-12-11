/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Student/legal/epl-v10.html
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
import com.sickle.dto.StudentDTO;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.StudentService;
import com.sickle.pojo.edu.Cls;
import com.sickle.pojo.edu.Student;
import com.sickle.service.itf.IClsService;
import com.sickle.service.itf.IStudentService;

public class StudentServiceImpl extends RemoteServiceServlet implements StudentService {

	private static final long serialVersionUID = -1237972296199346411L;
	
	private static IStudentService service = null;

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( IStudentService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> listAllStudent( int startIndex, int length )
	{
		List<Student> students = null;
		try
		{
			students = service.listStudents(startIndex, length );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		if( students == null )
		{
			students = new ArrayList<Student>();
		}
		return new StudentDTO().to( students );
	}

	@Override
	public List<Student> listStudent( int[] ids )
	{
		List<Student>  students = new ArrayList<Student>();
		for(int id : ids )
		{
			try
			{
				Student m = findStudent( id );
				if( m != null)
				{
					students.add( m );
				}
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}
		}
		return new StudentDTO().to( students );
	}

	@Override
	public Student addStudent( int classid, Student student ) throws Exception
	{
		Student stu = service.addStudent( classid, student );
		return new StudentDTO( ).to( stu );
	}

	@Override
	public Student modifyStudent( Student student ) throws Exception
	{
		
		Student stu = service.modifyStudent( student );
		return new StudentDTO( ).to( stu );
	}

	@Override
	public Student deleteStudent(int classid, Student student ) throws Exception
	{
		IClsService classservice =  DaoServiceFactory.getService(IClsService.class);
		Cls cls = classservice.getClassById( classid );
		cls.removeStudent( student );
		classservice.modifyCls( cls );
		
		service.removeStudentById( student.getId( ) );
		return new StudentDTO().to( student );
	}

	@Override
	public Student findStudent( int id ) throws Exception
	{
		Student stu = service.getStudentById( id );
		if(stu == null)
		{
			return null;
		}
		return new StudentDTO().to( stu );
	}


}
