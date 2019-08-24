package cn.jboa.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import cn.jboa.common.Constants;
import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.ClaimVoucherDetail;
import cn.jboa.entity.Employee;
import cn.jboa.service.ClaimVoucherService;
import cn.jboa.service.EmployeeService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

public class ClaimVoucherAction extends ActionSupport {
    private ClaimVoucherService cvi;

    public ClaimVoucherService getCvi() {
        return cvi;
    }

    public void setCvi(ClaimVoucherService cvi) {
        this.cvi = cvi;
    }

    private ClaimVoucher claimVoucher;  //报销单对象

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    private List<ClaimVoucherDetail> detailList = new ArrayList<>(); //详情单集合

    public List<ClaimVoucherDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<ClaimVoucherDetail> detailList) {
        this.detailList = detailList;
    }

    /**
     * 保存翻页数据
     * @param pageNo 当前页码
     */
    public void savePage(int pageNo){
        Map request = (Map) ActionContext.getContext().get("request");
        Map<String, Object> session = ActionContext.getContext().getSession();
        Employee user = (Employee)session.get("employee");
        int pageCounts = cvi.getPageCount(user.getSn());
        request.put("currentPageNo",pageNo!=0?pageNo:1);
        request.put("totalPageCount",pageCounts%5==0?pageCounts/5:pageCounts/5+1);
        request.put("totalRecordCount",pageCounts);
    }

    /**
     * 保存报销单记录
     */
    List<ClaimVoucher> items = new ArrayList<>();

    public List<ClaimVoucher> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucher> items) {
        this.items = items;
    }

    /**
     * 页号
     */
    private int pageNo;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 报销单id
     */
    private List<Integer> detailListById = new ArrayList<>();

    public List<Integer> getDetailListById() {
        return detailListById;
    }

    public void setDetailListById(List<Integer> detailListById) {
        this.detailListById = detailListById;
    }

    /**
     * 根据工号分页查询自己的报销单
     * @return
     */
    public String searchClaimVoucher(){
        Employee employee = (Employee)ActionContext.getContext().getSession().get("employee");
        ClaimVoucher cv = new ClaimVoucher();
        cv.setCreate_sn(employee.getSn());
        items = cvi.showInfo(cv, (pageNo-1)*5, 5);
        System.out.println(pageNo);
        savePage(pageNo);
        return SUCCESS;
    }

    /**
     *  根据id查询报销详情单
     * @return
     */
    public String toUpdate(){
        claimVoucher = cvi.toUpdate(claimVoucher.getId());
        ActionContext.getContext().getSession().put("claimVoucher",claimVoucher);
        return "toUpdate";
    }

    /**
     * 修改报销单，添加报销详情单
     * @return
     */
    public String updateClaimVoucher(){
        ClaimVoucher claimVoucher = (ClaimVoucher)ActionContext.getContext().getSession().get("claimVoucher");
        claimVoucher.setEvent(this.claimVoucher.getEvent());
        claimVoucher.setTotalAccount(this.claimVoucher.getTotalAccount());
        this.cvi.updateInfo(claimVoucher,detailList,detailListById);
        return "toSearchClaimVoucher.action";
    }

    /**
     * 删除报销单
     * @return
     */
    public String deleteClaimVoucherById(){
        ClaimVoucher claimVoucher = this.cvi.toUpdate(this.claimVoucher.getId());
        this.cvi.delInfo(claimVoucher);
        return "toSearchClaimVoucher.action";
    }

    /**
     * 查看报销单
     * @return
     */
    public String getClaimVoucherById(){
        claimVoucher = cvi.toUpdate(claimVoucher.getId());
        ActionContext.getContext().getSession().put("claimVoucher",claimVoucher);
        return "toGetClaimVoucher";
    }

    /**
     * 确认报销单
     * @return
     */
    public String toCheck(){
        claimVoucher = cvi.toUpdate(claimVoucher.getId());
        ActionContext.getContext().getSession().put("claimVoucher",claimVoucher);
        return "toCheck";
    }

}
