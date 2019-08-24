package cn.jboa.dao.impl;

import cn.jboa.dao.ClaimVoucherDao;
import cn.jboa.entity.ClaimVoucher;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClaimVoucherDaoImpl extends HibernateDaoSupport implements ClaimVoucherDao {

    /**
     * 条件分页查询数据
     * @param cv  条件对象
     * @param first 起始记录数
     * @param last 最大记录数
     * @return 报销单集合
     */
    @Override
    public List<ClaimVoucher> showInfo(ClaimVoucher cv, int first, int last) {
        return (List<ClaimVoucher>)this.getHibernateTemplate().findByExample(cv,first,last);
    }
    /**
     * 获取总记录数
     * @param sn 创建者id
     * @return 返回记录数
     */
    @Override
        public int getPageCount(String sn) {
        String hql = "select count(*) from ClaimVoucher where create_sn = ?";
        Long count = (Long)this.getHibernateTemplate().find(hql, sn).listIterator().next();
        return count.intValue();
    }
    /**
     * 根据id查询报销单返回到页面
     * @param id 报销单id
     * @return 报销单详情
     */
    @Override
    public ClaimVoucher toUpdate(int id) {
        String hql = "from ClaimVoucher where id = ?";
        List<ClaimVoucher> cv = (List<ClaimVoucher>)this.getHibernateTemplate().find(hql, id);
        return cv.get(0);
    }
    /**
     * 根据对象修改报销单信息
     * @param cv 报销单对象
     */
    @Override
    public void updateInfo(ClaimVoucher cv) {
        this.getHibernateTemplate().update(cv);
    }

    /**
     * 根据对象删除报销单
     * @param claimVoucher
     */
    @Override
    public void delInfo(ClaimVoucher claimVoucher) {
        this.getHibernateTemplate().delete(claimVoucher);
    }
}
