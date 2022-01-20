package com.google.s1.location;

import java.util.List;

public class LocationView {
	
	public void view(List<LocationDTO>ar) {
		
		for(int i=0;i<ar.size();i++) {
			
			System.out.println(ar.get(i).getLocation_id()+"\t");
			System.out.println(ar.get(i).getStreet_address()+"\t");
			System.out.println(ar.get(i).getPotal_code()+"\t");
			System.out.println(ar.get(i).getState_province()+"\t");
			System.out.println(ar.get(i).getCity()+"\t");
			System.out.println(ar.get(i).getCountry_id()+"\t");
		
		
		
		}
		
	}

}
