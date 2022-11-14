package com.luckyframe.project.grpcapi;

import com.luckyframe.common.constant.CommonMap;
import com.luckyframe.common.utils.client.HttpRequest;
import com.luckyframe.project.testexecution.taskCaseExecute.domain.TaskCaseExecute;
import com.luckyframe.project.testexecution.taskCaseExecute.service.ITaskCaseExecuteService;
import com.luckyframe.project.testexecution.taskExecute.domain.TaskExecute;
import com.luckyframe.project.testexecution.taskExecute.service.ITaskExecuteService;
import com.luckyframe.project.testexecution.taskScheduling.service.ITaskSchedulingService;
import com.luckyframe.project.testmanagmt.projectK8s.domain.HttpSend;
import com.luckyframe.project.testmanagmt.projectK8s.domain.JsonRootBean;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@GrpcService
public class RobotService extends robot.RobotTestServiceGrpc.RobotTestServiceImplBase {
    @Resource
    private ITaskCaseExecuteService taskCaseExecuteService;
    @Resource
    private ITaskExecuteService taskExecuteService;
    @Autowired
    private Environment environment;
    @Override
    public void setTestRobotStatus(robot.Robot.TestRobotStatus request, StreamObserver<robot.Robot.TestRobotStatusResponse> responseObserver) {
        TaskExecute taskExecut =new TaskExecute();
        String url = environment.getProperty("kubernetes.application.url");
        String result = HttpRequest.httpClientGet(url,null, null,15000);
        taskExecut.setTaskStatus(0);
        List<TaskExecute> list = taskExecuteService.selectTaskExecuteList(taskExecut);
        JsonRootBean robotjson = new JsonRootBean();
        robotjson = HttpSend.toBean(result,robotjson.getClass());
        for (int i = 0; i < robotjson.getItems().size(); i++) {
            for (TaskExecute e:list){
                if(robotjson.getItems().get(i).getMetadata().getName().contains(e.getExampleId())&&
                        robotjson.getItems().get(i).getMetadata().getUid().equals(request.getServerId())){
                    List<TaskCaseExecute> taskCaseExecutes = taskCaseExecuteService.selectTaskCaseExecuteListByTaskId(e.getTaskId());
                    for (robot.Robot.StepInfo s : request.getStepInfosList()) {
                        if(taskCaseExecutes.size()==0){
                            TaskCaseExecute taskCaseExecute = new TaskCaseExecute();
                            taskCaseExecute.setTaskId(e.getTaskId());
                            taskCaseExecute.setCaseId(e.getTaskId()+s.getTaskId());
                            taskCaseExecute.setProjectId(e.getProjectId());
                            taskCaseExecute.setCaseSign("0");
                            taskCaseExecute.setCompletedQuantity(s.getFinishCount());
                            taskCaseExecute.setCaseName(request.getServerId());
                            taskCaseExecute.setPodId(request.getServerId());
                            taskCaseExecute.setCaseStatus(3);
                            taskCaseExecute.setPlanId(s.getTaskId());
                            taskCaseExecute.setK8sTaskId(s.getTaskId());
                            taskCaseExecute.setUpdateTime(new Date());
                            taskCaseExecute.setCreateTime(new Date());
                            taskCaseExecuteService.insertTaskCaseExecute(taskCaseExecute);
                        }else {
                            Integer finishcount = 0;

                            for (TaskCaseExecute t:taskCaseExecutes){

                                if(t.getCaseId().equals(e.getTaskId()+s.getTaskId())){
                                    finishcount +=s.getFinishCount();
                                    t.setCompletedQuantity(s.getFinishCount());
                                    t.setPodId(request.getServerId());
                                    t.setCaseStatus(0);
                                    t.setK8sTaskId(s.getTaskId());
                                    t.setUpdateTime(new Date());
                                    taskCaseExecuteService.updateTaskCaseExecute(t);
                                }

                            }

                        }

                    }

                    TaskExecute taskExecute = taskExecuteService.selectTaskExecuteById(e.getTaskId());
                    taskExecute.setRobotsNumber(request.getRobotCount());
                    taskExecuteService.updateTaskExecute(taskExecute);
                }

            }
        }
        robot.Robot.TestRobotStatusResponse a = robot.Robot.TestRobotStatusResponse.newBuilder().setMessage("true").build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }
}
