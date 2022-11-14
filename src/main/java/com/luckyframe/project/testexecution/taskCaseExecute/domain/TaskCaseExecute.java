package com.luckyframe.project.testexecution.taskCaseExecute.domain;

import com.luckyframe.project.system.project.domain.Project;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.luckyframe.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 任务用例执行记录表 task_case_execute
 * 
 * @author luckyframe
 * @date 2022-11-02
 */
public class TaskCaseExecute extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用例执行ID */
	private Integer taskCaseId;
	/** 任务ID */
	private Integer taskId;
	/** 项目ID */
	private Integer projectId;
	/** 用例ID */
	private Integer caseId;
	/** 用例标识 */
	private String caseSign;
	/** 用例名称 */
	private String caseName;
	/** 用例执行状态 0成功 1失败 2锁定 3执行中 4未执行 */
	private Integer caseStatus;
	/** 用例结束时间 */
	private Date finishTime;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 计划ID */
	private Integer planId;
	/** k8s 任务id */
	private Integer k8sTaskId;
	/** 已完成的数量 */
	private Integer completedQuantity;
	/** k8s pod UID */
	private String podId;
	/** 执行百分比 */
	private Integer progress;
	/** 关联项目实体 */
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setTaskCaseId(Integer taskCaseId)
	{
		this.taskCaseId = taskCaseId;
	}

	public Integer getTaskCaseId() 
	{
		return taskCaseId;
	}
	public void setTaskId(Integer taskId) 
	{
		this.taskId = taskId;
	}

	public Integer getTaskId() 
	{
		return taskId;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setCaseId(Integer caseId) 
	{
		this.caseId = caseId;
	}

	public Integer getCaseId() 
	{
		return caseId;
	}
	public void setCaseSign(String caseSign) 
	{
		this.caseSign = caseSign;
	}

	public String getCaseSign() 
	{
		return caseSign;
	}
	public void setCaseName(String caseName) 
	{
		this.caseName = caseName;
	}

	public String getCaseName() 
	{
		return caseName;
	}
	public void setCaseStatus(Integer caseStatus) 
	{
		this.caseStatus = caseStatus;
	}

	public Integer getCaseStatus() 
	{
		return caseStatus;
	}
	public void setFinishTime(Date finishTime) 
	{
		this.finishTime = finishTime;
	}

	public Date getFinishTime() 
	{
		return finishTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setPlanId(Integer planId) 
	{
		this.planId = planId;
	}

	public Integer getPlanId() 
	{
		return planId;
	}
	public void setK8sTaskId(Integer k8sTaskId) 
	{
		this.k8sTaskId = k8sTaskId;
	}

	public Integer getK8sTaskId() 
	{
		return k8sTaskId;
	}
	public void setCompletedQuantity(Integer completedQuantity) 
	{
		this.completedQuantity = completedQuantity;
	}

	public Integer getCompletedQuantity() 
	{
		return completedQuantity;
	}
	public void setPodId(String podId) 
	{
		this.podId = podId;
	}

	public String getPodId() 
	{
		return podId;
	}
	public void setProgress(Integer progress) 
	{
		this.progress = progress;
	}

	public Integer getProgress() 
	{
		return progress;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskCaseId", getTaskCaseId())
            .append("taskId", getTaskId())
            .append("projectId", getProjectId())
            .append("caseId", getCaseId())
            .append("caseSign", getCaseSign())
            .append("caseName", getCaseName())
            .append("caseStatus", getCaseStatus())
            .append("finishTime", getFinishTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("planId", getPlanId())
            .append("k8sTaskId", getK8sTaskId())
            .append("completedQuantity", getCompletedQuantity())
            .append("podId", getPodId())
            .append("progress", getProgress())
            .toString();
    }
}
