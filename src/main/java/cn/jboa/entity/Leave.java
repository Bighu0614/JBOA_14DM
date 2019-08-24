package cn.jboa.entity;
// default package

import java.util.Date;


/**
 * Leave entity. @author MyEclipse Persistence Tools
 */

public class Leave  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Employee creator;
     private Date startTime;
     private Date endTime;
     private Double leaveDay;
     private String reason;
     private String status;
     private String leaveType;
     private Employee nextDeal;
     private String approveOpinion;
     private Date createTime;
     private Date modifyTime;


    // Constructors

    /** default constructor */
    public Leave() {
    }
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

   

    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getLeaveDay() {
        return this.leaveDay;
    }
    
    public void setLeaveDay(Double leaveday) {
        this.leaveDay = leaveday;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeaveType() {
        return this.leaveType;
    }
    
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

   

    public String getApproveOpinion() {
        return this.approveOpinion;
    }
    
    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Employee getCreator() {
		return creator;
	}

	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	public Employee getNextDeal() {
		return nextDeal;
	}

	public void setNextDeal(Employee nextDeal) {
		this.nextDeal = nextDeal;
	}

	


}