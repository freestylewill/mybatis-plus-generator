package com.guigu;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 生成的代码放哪里
        final String projectPath = System.getProperty("user.dir") + "/sv-member/";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setAuthor("majun");
        gc.setOpen(false);

        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        //gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        generator.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_demo?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        generator.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName("mytest");
        // 工程的包名
        pc.setParent("com.guigu");
        generator.setPackageInfo(pc);

        //要想输出xml文件，需要额外自定义添加进去
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/freemaker/mapper.xml.ftl";
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setController("/templates/mybatis-plus/controller.java");
//        templateConfig.setEntity("/templates/mybatis-plus/entity.java");
        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);

        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setController("/templates/mybatis-plus/controller.java");
//        templateConfig.setEntity("/templates/mybatis-plus/entity.java");
//        templateConfig.setXml(null);

        templateConfig.setController("/templates/freemaker/controller.java");
        templateConfig.setEntity("/templates/freemaker/entity.java");
        templateConfig.setMapper("/templates/freemaker/mapper.java");
        templateConfig.setService("/templates/freemaker/service.java");
        templateConfig.setServiceImpl("/templates/freemaker/serviceImpl.java");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        //可选择要生成的表名，多个英文逗号分割
        strategy.setInclude("account");
        // 表名生成策略：下划线连转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 表字段生成策略：下划线连转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // controller映射地址：驼峰转连字符
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setRestControllerStyle(true);
        // 去除表前缀
        String ENTITY_IGNORE_PREFIX = "";
        strategy.setTablePrefix(ENTITY_IGNORE_PREFIX);
        // 是否启用builder 模式
        strategy.setEntityBuilderModel(true);
        // 是否为lombok模型; 需要lombok依赖
        strategy.setEntityLombokModel(true);
        // 生成实体类字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);

        generator.setStrategy(strategy);

        // set freemarker engine
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        // set beetl engine
        // generator.setTemplateEngine(new BeetlTemplateEngine());

        // set custom engine (reference class is your custom engine class)
        // generator.setTemplateEngine(new CustomTemplateEngine());
        // generator.setTemplateEngine(new BeetlTemplateEngine());
        generator.execute();
        System.out.println("======完成=====");
    }
}
