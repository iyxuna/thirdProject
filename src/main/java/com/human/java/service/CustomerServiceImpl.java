package com.human.java.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.java.dao.CustomerDAOImpl;
import com.human.java.domain.CustomerVO;
import com.human.java.domain.ExhibitionVO;
import com.human.java.domain.WishListVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private CustomerDAOImpl customerDAO;
	
	@Override
	public int customerInsert(CustomerVO vo) {
		
		System.out.println("===============");
		System.out.println("customerInsert 서비스 호출");
		System.out.println("VO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		
		return customerDAO.customerInsert(vo);
	}

	@Override
	public CustomerVO customerLogin(CustomerVO vo) {
		
		System.out.println("===============");
		System.out.println("customerLogin 서비스 호출");
		System.out.println("CustomeVO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		
		return customerDAO.customerLogin(vo);
	}
	@Override
	public void customerUpdate(CustomerVO vo) {
		
		System.out.println("===============");
		System.out.println("customerupdate 서비스 호출");
		System.out.println("CustomeVO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		
		customerDAO.customerupdate(vo);
		
	}

	@Override
	public List<WishListVO> WishListService(ExhibitionVO vo, String id, WishListVO wl, HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("-_+_+_+_+_+_+_+_+_+_+_");
		System.out.println("WishListService.do 호출");
		System.out.println("_+_+_+_+_+_+_+_+_+_+_+");
		
		customerDAO.wishListInsert(vo, id, request);
		
		return customerDAO.wishListSearch(wl, id, request);
	}
	
	@Override
	public List<WishListVO> WishListSelectService(ExhibitionVO vo, String id, WishListVO wl, HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("-_+_+_+_+_+_+_+_+_+_+_");
		System.out.println("WishListService.do 호출");
		System.out.println("_+_+_+_+_+_+_+_+_+_+_+");
		
		
		return customerDAO.wishListSearch(wl, id, request);
	}

	@Override
	public int idCheck(CustomerVO vo, String id) {
		if(customerDAO.idCheck(id)==0) {
			return 0;
		}else {
		return 1;
		}
	}

	@Override
	public CustomerVO customerconfirmpassword(CustomerVO vo) {
		System.out.println("===============");
		System.out.println("customerconfirmpassword 서비스 호출");
		System.out.println("VO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		return customerDAO.customerconfirmpassword(vo);
	}
	
	@Override
	public CustomerVO customerFindPassword(CustomerVO vo) {
		System.out.println("===============");
		System.out.println("customerFindPassword 서비스 호출");
		System.out.println("VO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		return customerDAO.customerFindPassword(vo);
	}

	@Override
	public int customerTotalDelete(CustomerVO vo) {
		System.out.println("===============");
		System.out.println("customerTotalDelete 서비스 호출");
		System.out.println(vo.getCustomer_id());
		System.out.println("===============");
		
		return customerDAO.customerTotalDelete(vo);
	}

	@Override
	public int WishDelete(ExhibitionVO vo, String id, WishListVO wl, HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("서비스");
		return customerDAO.WishDelete(vo, id, wl, request);
	}
	
}
