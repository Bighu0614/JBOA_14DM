package cn.jboa.service.impl;

import cn.jboa.dao.ClaimVoucherDetailDao;
import cn.jboa.entity.ClaimVoucherDetail;
import cn.jboa.service.ClaimVoucherDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("cvd")
public class ClaimVoucherDetailServiceImpl implements ClaimVoucherDetailService {
    @Autowired
    ClaimVoucherDetailDao cvdDao;
    @Override
    public void save(List<ClaimVoucherDetail> cvd) {
        cvdDao.save(cvd);
    }

    @Override
    public void del(String no,List<Integer> item) {
        this.cvdDao.del(no,item);
    }
}
