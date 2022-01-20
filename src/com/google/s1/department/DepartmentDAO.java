package com.google.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.s1.util.DBConnector;

public class DepartmentDAO {  //DAO : Data Access object
	private DBConnector dbConnector;
	
	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}
	
	//부서번호로 조회
	public DepartmentDTO getOne(Integer department_id) throws Exception {
		DepartmentDTO departmentDTO = null;
		
		
		//1. DB에 로그인
		Connection con = dbConnector.getConnect();
		//2. SQL Query문 작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = "+department_id ;
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅 없으면 통과
		//5. 최종 전송 후 결과 처리
		ResultSet rs= st.executeQuery();
		//1개의 Row가 있거나 1개도 없거나
		
		if(rs.next()) {  //데이터가 있을 때
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
		}
		
		
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return departmentDTO;
	}
	
	
	public List<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		//SELECT * FROM DEPARTMENTS;
		//1.DB 로그인
		Connection con = dbConnector.getConnect();
		
		//2.SQL Query 문 작성
		//JAVA에서는 ";" 제외
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//3. 작성한 SQL Query 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값을 세팅, 없으면 통과
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		//cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false리턴
		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
//			String name = rs.getString("department_name");
	//		departmentDTO.setDepartment_name(name);
			
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
		//arrayList
			ar.add(departmentDTO);
			
		}
		//6. 외부 연결 해제 
		//		연결된 순서의 역순으로 끊음
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	
}
