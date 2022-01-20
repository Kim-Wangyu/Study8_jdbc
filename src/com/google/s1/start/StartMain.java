package com.google.s1.start;

import java.sql.SQLException;
import java.util.List;

import com.google.s1.department.DepartmentDAO;
import com.google.s1.department.DepartmentDTO;
import com.google.s1.department.DepartmentView;
import com.google.s1.location.LocationDAO;
import com.google.s1.location.LocationDTO;
import com.google.s1.location.LocationView;
import com.google.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB연동 테스트 시작");
		
		
//		-------------Department test-------------
	DepartmentDAO departmentDAO = new DepartmentDAO();
//	DepartmentView departmentView = new DepartmentView();
	try {
		DepartmentDTO departmentDTO = departmentDAO.getOne(20);
		System.out.println(departmentDTO.getDepartment_name());
//		List<DepartmentDTO>ar =departmentDAO.getList();
	//	departmentView.view(ar);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();

		
		List<LocationDTO> ar = locationDAO.getList();
		locationView.view(ar);
		
		
		System.out.println("DB연동 테스트 끝");

	}

}
