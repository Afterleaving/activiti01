package com.example.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.junit.Test;

public class TestCreate {

    /**
     *  使用activiti提供的默认方式创建mysql表
     * @author: lwl
     * @date: 2021/11/1 21:15
    */
    @Test
    public void testCreatTables(){
        //该方法会默认从resources目录下读取名字未activiti.cfg.xml的文件
        //创建processEngine时，就会创建mysql的表

//        默认方式：配置文件名字固定：activiti.cfg.xml    bean对象id固定：processEngineConfiguration
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RepositoryService repositoryService = processEngine.getRepositoryService();
//        repositoryService.createDeployment();

        //使用自定义方式：配置文件的名字可以自定义
        //1.一个参数：配置文件名字
        //2.两个参数：配置文件名字     bean对象的名字
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.
                createProcessEngineConfigurationFromResource("activiti.cfg.xml","processEngineConfiguration");
        //获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
