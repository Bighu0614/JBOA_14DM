package cn.jboa.dao;


import cn.jboa.entity.ClaimVoucher;

import javax.persistence.Id;
import java.util.List;

public interface ClaimVoucherDao {

	List<ClaimVoucher> showInfo(ClaimVoucher cv,int first,int last);


	int getPageCount(String sn);


	ClaimVoucher toUpdate(int id);


	void updateInfo(ClaimVoucher cv);

	void delInfo(ClaimVoucher claimVoucher);
 }
