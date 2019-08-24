package cn.jboa.service.impl;

import cn.jboa.dao.ClaimVoucherDao;
import cn.jboa.dao.ClaimVoucherDetailDao;
import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.ClaimVoucherDetail;
import cn.jboa.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("cvi")
@Transactional
public class ClaimVoucherServiceImpl implements ClaimVoucherService {
    @Autowired
    private ClaimVoucherDao cvi;
    @Autowired
    private ClaimVoucherDetailDao cvd;

    @Override
    public List<ClaimVoucher> showInfo(ClaimVoucher cv, int first, int last) {
        return this.cvi.showInfo(cv,first,last);
    }

    @Override
    public int getPageCount(String sn) {
        return this.cvi.getPageCount(sn);
    }

    @Override
    public ClaimVoucher toUpdate(int id) {
        return this.cvi.toUpdate(id);
    }

    @Override
    public void updateInfo(ClaimVoucher cv,List<ClaimVoucherDetail> cvds,List<Integer> ids) {
        for (ClaimVoucherDetail item : cvds){
                item.setBizClaimVoucher(cv);
        }
        this.cvi.updateInfo(cv);
        this.cvd.del(cv.getId().toString(),ids);
        this.cvd.save(cvds);
    }

    @Override
    public void delInfo(ClaimVoucher claimVoucher) {
        this.cvi.delInfo(claimVoucher);
    }
}
