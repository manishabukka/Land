package com.cg.frs;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.service.FlatRegistrationServiceImpl;
import com.cg.frs.service.IFlatRegistrationService;

public class Client {
	 static FlatRegistrationDTO flatRegistrationDTO =new FlatRegistrationDTO();
	
	static Scanner sc = new Scanner(System.in);
	static IFlatRegistrationService iFlatRegistrationService=new FlatRegistrationServiceImpl();
	public static void main(String args[])
	{
	System.out.println("  1.Register Flat \n2. Exit");
	int ch=sc.nextInt();
	ArrayList<Integer> arrayList ;
	arrayList=iFlatRegistrationService.getAllOwnerIds();
	System.out.println("\nExisting IDs are:"+arrayList);
	
	System.out.println("\nplease enter your owner id from above list:");
	flatRegistrationDTO.setOwner_id(sc.nextInt());
	System.out.println("\nselect Flat Type(1-BHK, 2-2BHK):");
	flatRegistrationDTO.setFlat_type(sc.nextInt());
	System.out.println("\nEnter Flat area in sq.ft:");
	flatRegistrationDTO.setFlat_area(sc.nextInt());
	System.out.println("\nEnter desired rent amount Rs:");
	flatRegistrationDTO.setRent_amount(sc.nextInt());
	System.out.println("\nEnter desired deposit amount Rs:");
	flatRegistrationDTO.setDeposit_amount(sc.nextInt());
	
	flatRegistrationDTO=iFlatRegistrationService.registerFlat(flatRegistrationDTO);
	System.out.println("Flat successfully registered. Registration id:<"+flatRegistrationDTO.getFlat_reg_no()+">");
	
	
	switch(ch)
	{
	case 1:
		break;
	case 2:
		System.exit(0);
		break;
	}
	
	}
}
