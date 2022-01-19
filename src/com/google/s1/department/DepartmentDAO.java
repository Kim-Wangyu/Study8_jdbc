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
