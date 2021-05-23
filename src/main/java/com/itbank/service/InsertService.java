package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.insert.Hash;
import com.itbank.insert.InsertDAO;
import com.itbank.insert.MemberDTO;

@Service
public class InsertService {

	@Autowired
	private InsertDAO dao;

	public String sameIdCheck(String id) {

		String lowId = id.toLowerCase();

		String resultId = dao.sameIdCheck(lowId);

		return resultId;
	}
	
	// 회원가입
	public int insertNewbie(MemberDTO user) {
		user.setPw(Hash.getHash(user.getPw()));
		return dao.insertNewbie(user);
	}
	
	// 로그인
	public MemberDTO loginCheck(MemberDTO user) {
		user.setPw(Hash.getHash(user.getPw()));
		user.setId(user.getId().toLowerCase());

		return dao.loginCheck(user);
	}

	public int updateFileName(String fileName, String id) {

		MemberDTO updateDto = new MemberDTO();
		updateDto.setProfile(fileName);
		updateDto.setId(id);

		return dao.updateFileName(updateDto);
	}

	public String callUpdateImgName(String id) {

		return dao.callUpdateImgName(id);
	}

	public String firstCall(String id) {

		return dao.firstCall(id);
	}

}