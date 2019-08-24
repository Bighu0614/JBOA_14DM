package cn.jboa.entity;

import java.util.Date;

/**
 * 审核结果实体
 *
 */
public class CheckResult implements java.io.Serializable {

    private static final long serialVersionUID = -6927459782166236900L;
    private Long id;
    private Long claimId;
    private Date checkTime;
    private String result;
    private String comment;
    private Employee checkEmployee;

    /** default constructor */
    public CheckResult() {
    }

   

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



	public Long getClaimId() {
		return claimId;
	}



	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}



	public Employee getCheckEmployee() {
		return checkEmployee;
	}



	public void setCheckEmployee(Employee checkEmployee) {
		this.checkEmployee = checkEmployee;
	}

	
    

}