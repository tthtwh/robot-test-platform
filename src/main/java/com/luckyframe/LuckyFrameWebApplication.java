package com.luckyframe;

import java.net.InetSocketAddress;

import com.luckyframe.framework.config.NettyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.luckyframe.common.netty.NettyServer;

/**
 * 启动LuckyFrameWeb程序
 * =================================================================
 * 这是一个受限制的自由软件！您不能在任何未经允许的前提下对程序代码进行修改和用于商业用途；也不允许对程序代码修改后以任何形式任何目的的再发布。
 * 为了尊重作者的劳动成果，LuckyFrame关键版权信息严禁篡改 有任何疑问欢迎联系作者讨论。 QQ:1573584944 Seagull
 * =================================================================
 * @author Seagull
 * @date 2019年2月12日
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,FlywayAutoConfiguration.class })
@MapperScan("com.luckyframe.project.*.*.mapper")
public class LuckyFrameWebApplication  implements CommandLineRunner
{
    @Autowired
    private NettyServer server;

    @Autowired
    private NettyConfig nettyConfig;

    private static final Logger log = LoggerFactory.getLogger(LuckyFrameWebApplication.class);

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(nettyConfig.getUrl(),nettyConfig.getPort());
        log.info("服务端启动成功："+nettyConfig.getUrl()+":"+nettyConfig.getPort());
        server.start(address);
    }
    
    public static void main(String[] args)
    {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(LuckyFrameWebApplication.class, args);
        log.info("LuckyFrameWeb启动成功......");
    }

}