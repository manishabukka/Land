package com.cg.frs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public class FlatRegistrationDAOImpl implements IFlatRegistrationDAO {
	FlatRegistrationDTO flatRegistrationDTO =new FlatRegistrationDTO();
static int x=0;
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flatRegistrationDTO) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into flat_registration(flat_owner_id,flat_type,flat_area,rent_amount,deposit_amount) values(?,?,?,?,?)");
			ps.setInt(1, flatRegistrationDTO.getOwner_id());
			ps.setInt(2, flatRegistrationDTO.getFlat_type());
			ps.setInt(3, flatRegistrationDTO.getFlat_area());
			ps.setInt(4, flatRegistrationDTO.getRent_amount());
			ps.setInt(5, flatRegistrationDTO.getDeposit_amount());
			x=ps.executeUpdate();
			
			
			
			con.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
				PreparedStatement ps = con.prepareStatement("select flat_reg_no from flat_registration where flat_owner_id=?");
				ps.setInt(1, flatRegistrationDTO.getOwner_id());
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					flatRegistrationDTO.setFlat_reg_no(rs.getInt(1));
				}
				
				
				
				con.close();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		if(x==1)
			return flatRegistrationDTO;
		else
			return null;
		
	}
	

	public ArrayList<Integer> getAllOwnerIds() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement ps = con.prepareStatement("select owner_id from flat_owners");
			ResultSet  rs= ps.executeQuery();
			while(rs.next())
			{
				arrayList.add(rs.getInt(1));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayList;
	}

}
