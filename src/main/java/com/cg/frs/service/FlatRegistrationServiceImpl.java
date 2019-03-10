package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlatRegistrationDAOImpl;
import com.cg.frs.dao.IFlatRegistrationDAO;
import com.cg.frs.dto.FlatRegistrationDTO;

public class FlatRegistrationServiceImpl implements IFlatRegistrationService {
	FlatRegistrationDTO flatRegistrationDTO =new FlatRegistrationDTO();
	IFlatRegistrationDAO iFlatRegistrationDAO = new FlatRegistrationDAOImpl();
	
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flatRegistrationDTO) {

		flatRegistrationDTO=iFlatRegistrationDAO.registerFlat(flatRegistrationDTO);
		return flatRegistrationDTO;
	}

	public ArrayList<Integer> getAllOwnerIds() {
		ArrayList<Integer> arrayList ;
		arrayList=iFlatRegistrationDAO.getAllOwnerIds();
		return arrayList;
	}

}
