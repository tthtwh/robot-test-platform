package com.luckyframe.project.testmanagmt.projectSuite.controller;

import com.luckyframe.common.utils.StringUtils;
import com.luckyframe.common.utils.security.PermissionUtils;
import com.luckyframe.framework.aspectj.lang.annotation.Log;
import com.luckyframe.framework.aspectj.lang.enums.BusinessType;
import com.luckyframe.framework.web.controller.BaseController;
import com.luckyframe.framework.web.domain.AjaxResult;
import com.luckyframe.framework.web.page.TableDataInfo;
import com.luckyframe.project.system.project.service.IProjectService;
import com.luckyframe.project.testmanagmt.projectPlan.domain.ProjectPlan;
import com.luckyframe.project.testmanagmt.projectPlan.service.IProjectPlanService;
import com.luckyframe.project.testmanagmt.projectSuite.domain.ProjectSuite;
import com.luckyframe.project.testmanagmt.projectSuite.domain.ProjectSuitePlan;
import com.luckyframe.project.testmanagmt.projectSuite.service.IprojectSuitePlanService;
import com.luckyframe.project.testmanagmt.projectSuite.service.IprojectSuiteService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author jerelli
 * @date 2021年1月5日
 */

@Controller
@RequestMapping("/testmanagmt/projectSuitePlan")
public class ProjectSuitePlanController extends BaseController {

    @Autowired
    private IprojectSuitePlanService projectSuitePlanService;

    @Autowired
    private IprojectSuiteService projectSuiteService;

    @Autowired
    private IProjectPlanService projectPlanService;

    @Autowired
    private IProjectService projectService;

    @RequiresPermissions("testmanagmt:projectSuite:view")
    @GetMapping("/{suiteId}")
    public String projectSuitePlan(@PathVariable("suiteId")Integer suiteId,ModelMap mmap){
        ProjectSuite projectSuite=projectSuiteService.selectProjectSuiteById(suiteId);
        mmap.put("projectSuite",projectSuite);
        return "testmanagmt/projectSuite/projectSuitePlan";
    }


    /**
     * 查询测试计划用例列表
     */
    @RequiresPermissions("testmanagmt:projectSuite:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectPlan projectPlan)
    {
        startPage();
        List<ProjectPlan> projectPlanList=projectPlanService.selectProjectPlanListForSuite(projectPlan);
        return getDataTable(projectPlanList);
    }

    @RequiresPermissions("testmanagmt:projectSuite:edit")
    @Log(title = "测试计划用例", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/saveSuitePlan",method=RequestMethod.POST,consumes="application/json")
    @ResponseBody
    public AjaxResult saveSuitePlan(@RequestBody List<ProjectPlan> projectPlans)
    {
        int resultCount=0;
        int suiteId;

        if(projectPlans.size()==0){
            return toAjax(1);
        }else{
            suiteId=projectPlans.get(0).getSuiteId();
        }

        ProjectSuite projectSuite = projectSuiteService.selectProjectSuiteById(suiteId);

        if(!PermissionUtils.isProjectPermsPassByProjectId(projectSuite.getProjectId())){
            return error("没有此项目保存测试计划用例权限");
        }

        for(ProjectPlan projectPlan:projectPlans){
            if(StringUtils.isNotEmpty(projectPlan.getSuitePlanId())&&!projectPlan.isFlag()){
                resultCount = resultCount+projectSuitePlanService.deleteProjectSuitePlanById(projectPlan.getSuitePlanId());
            }

            if(projectPlan.isFlag()&&StringUtils.isEmpty(projectPlan.getSuitePlanId())){
                ProjectSuitePlan projectSuitePlan = new ProjectSuitePlan();
                projectSuitePlan.setSuiteId(projectPlan.getSuiteId());
                projectSuitePlan.setPlanId(projectPlan.getPlanId());
                projectSuitePlan.setPriority(projectPlan.getPriority());
                resultCount = resultCount+projectSuitePlanService.insertProjectSuitePlan(projectSuitePlan);
            }else{
                resultCount++;
            }
        }

        Integer suitePlanCount=projectSuitePlanService.selectProjectSuitePlanCountBySuiteId(suiteId);
        projectSuite.setSuitePlanCount(suitePlanCount);
        projectSuiteService.updateProjectSuite(projectSuite);

        return toAjax(resultCount);
    }

    /**
     * 编辑测试计划优先级
     */
    @RequiresPermissions("testmanagmt:projectSuite:edit")
    @Log(title = "聚合测试计划", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit",method=RequestMethod.POST,consumes="application/json")
    @ResponseBody
    public AjaxResult edit(@RequestBody ProjectPlan projectPlan)
    {
        if(!PermissionUtils.isProjectPermsPassByProjectId(projectPlan.getProjectId())){
            return error("没有此项目保存计划用例优先级权限");
        }

        int resultCount;
        ProjectSuitePlan projectSuitePlan = new ProjectSuitePlan();
        if(StringUtils.isEmpty(projectPlan.getSuitePlanId())){
            projectSuitePlan.setSuiteId(projectPlan.getSuiteId());
            projectSuitePlan.setPlanId(projectPlan.getPlanId());
            projectSuitePlan.setPriority(projectPlan.getPriority());
            resultCount = projectSuitePlanService.insertProjectSuitePlan(projectSuitePlan);
            ProjectSuite projectSuite = projectSuiteService.selectProjectSuiteById(projectPlan.getSuiteId());
            projectSuiteService.updateProjectSuite(projectSuite);
        }else{
            projectSuitePlan.setSuitePlanId(projectPlan.getSuitePlanId());
            projectSuitePlan.setSuiteId(projectPlan.getSuiteId());
            projectSuitePlan.setPlanId(projectPlan.getPlanId());
            projectSuitePlan.setPriority(projectPlan.getPriority());
            resultCount = projectSuitePlanService.updateProjectSuitePlan(projectSuitePlan);
        }

        return toAjax(resultCount);
    }

}
