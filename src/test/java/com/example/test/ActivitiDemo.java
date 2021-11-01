package com.example.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class ActivitiDemo {

    /**
     * 测试流程部署
     * @author: lwl
     * @date: 2021/11/1 22:15
    */
    @Test
    public void testDeployment() {
        //1.创建流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.使用service进行流程部署，定义一个流程的名字，把BPMN和png部署到数据中
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请")
                .addClasspathResource("bpmn/evection.bpmn")
                .addClasspathResource("bpmn/evection.png")
                .deploy();
        //4.输出部署信息
        System.out.println("流程部署id ------->"+deploy.getId());
        System.out.println("流程部署名字 ------->"+deploy.getName());
    }

    /**
     *  启动流程示例
     *  act_hi_actinst      流程实例执行历史
     *  act_hi_identitylink     流程参与者历史信息
     *  act_hi_procinst     流程实例历史信息
     *  act_hi_taskinst     任务历史信息
     *  act_ru_execution    流程执行信息
     *  act_ru_indentitylink    流程参与者信息
     *  act_ru_task        任务信息
    */
    @Test
    public void testStartProcess() {
        //1.创建流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.根据流程定义的id启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("myEvection");
        //4.输出内容信息
        System.out.println("流程定义ID："+ instance.getProcessDefinitionId());
        System.out.println("流程实例ID："+ instance.getId());
        System.out.println("当前活动ID："+ instance.getActivityId());
    }

}
