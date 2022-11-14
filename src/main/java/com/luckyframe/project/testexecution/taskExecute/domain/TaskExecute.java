package com.luckyframe.project.testexecution.taskExecute.domain;

import com.luckyframe.project.system.project.domain.Project;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.luckyframe.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 测试任务执行表 task_execute
 * 
 * @author luckyframe
 * @date 2022-11-02
 */
public class TaskExecute extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 任务ID */
	private Integer taskId;
	/** 调度ID */
	private Integer schedulingId;
	/** 项目ID */
	private Integer projectId;
	/** 任务名称 */
	private String taskName;
	/** 状态 0未执行 1执行中 2执行完成 3任务超时中断 4唤起客户端失败 */
	private Integer taskStatus;
	/** 总用例数 */
	private Integer caseTotalCount;
	/** 成功数 */
	private Integer caseSuccCount;
	/** 失败数 */
	private Integer caseFailCount;
	/** 锁定数 */
	private Integer caseLockCount;
	/** 未执行用例 */
	private Integer caseNoexecCount;
	/** 任务结束时间 */
	private Date finishTime;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 任务数量 */
	private Integer taskNumber;
	/** 机器人数量 */
	private Integer robotsNumber;
	/** 执行百分比 */
	private Integer taskProgres;
	/** 实例ID，k8s任务唯一id */
	private String exampleId;
	/** 关联项目实体 */
	private Project project;


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setTaskId(Integer taskId)
	{
		this.taskId = taskId;
	}

	public Integer getTaskId() 
	{
		return taskId;
	}
	public void setSchedulingId(Integer schedulingId) 
	{
		this.schedulingId = schedulingId;
	}

	public Integer getSchedulingId() 
	{
		return schedulingId;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setTaskName(String taskName) 
	{
		this.taskName = taskName;
	}

	public String getTaskName() 
	{
		return taskName;
	}
	public void setTaskStatus(Integer taskStatus) 
	{
		this.taskStatus = taskStatus;
	}

	public Integer getTaskStatus() 
	{
		return taskStatus;
	}
	public void setCaseTotalCount(Integer caseTotalCount) 
	{
		this.caseTotalCount = caseTotalCount;
	}

	public Integer getCaseTotalCount() 
	{
		return caseTotalCount;
	}
	public void setCaseSuccCount(Integer caseSuccCount) 
	{
		this.caseSuccCount = caseSuccCount;
	}

	public Integer getCaseSuccCount() 
	{
		return caseSuccCount;
	}
	public void setCaseFailCount(Integer caseFailCount) 
	{
		this.caseFailCount = caseFailCount;
	}

	public Integer getCaseFailCount() 
	{
		return caseFailCount;
	}
	public void setCaseLockCount(Integer caseLockCount) 
	{
		this.caseLockCount = caseLockCount;
	}

	public Integer getCaseLockCount() 
	{
		return caseLockCount;
	}
	public void setCaseNoexecCount(Integer caseNoexecCount) 
	{
		this.caseNoexecCount = caseNoexecCount;
	}

	public Integer getCaseNoexecCount() 
	{
		return caseNoexecCount;
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
	public void setTaskNumber(Integer taskNumber) 
	{
		this.taskNumber = taskNumber;
	}

	public Integer getTaskNumber() 
	{
		return taskNumber;
	}
	public void setRobotsNumber(Integer robotsNumber) 
	{
		this.robotsNumber = robotsNumber;
	}

	public Integer getRobotsNumber() 
	{
		return robotsNumber;
	}
	public void setTaskProgres(Integer taskProgres) 
	{
		this.taskProgres = taskProgres;
	}

	public Integer getTaskProgres() 
	{
		return taskProgres;
	}
	public void setExampleId(String exampleId) 
	{
		this.exampleId = exampleId;
	}

	public String getExampleId() 
	{
		return exampleId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("schedulingId", getSchedulingId())
            .append("projectId", getProjectId())
            .append("taskName", getTaskName())
            .append("taskStatus", getTaskStatus())
            .append("caseTotalCount", getCaseTotalCount())
            .append("caseSuccCount", getCaseSuccCount())
            .append("caseFailCount", getCaseFailCount())
            .append("caseLockCount", getCaseLockCount())
            .append("caseNoexecCount", getCaseNoexecCount())
            .append("finishTime", getFinishTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("taskNumber", getTaskNumber())
            .append("robotsNumber", getRobotsNumber())
            .append("taskProgres", getTaskProgres())
            .append("exampleId", getExampleId())
            .toString();
    }
}
