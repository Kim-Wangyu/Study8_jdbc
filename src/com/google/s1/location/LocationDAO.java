package com.google.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.s1.util.DBConnector;

public class LocationDAO {
	private DBConnector dbConnector;
	
	
	
		public LocationDAO() {
			dbConnector = new DBConnector();
		
	public List<LocationDTO> getList() {
		ArrayList<LocationDTO> ar = new ArrayList<>();
		//1.DB에 로그인
		Connection con = dbConnector.getConnect();
		//2.SQL query문 생성
		String sql = "SELECT * FROM LOCATIONS";
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.물음표 세팅 없으면 통과
		//5.최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPotal_code(rs.getString("potal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			ar.add(locationDTO);
			
		
		
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
		
		
		
		
		//6.자원 해제
		
	}


