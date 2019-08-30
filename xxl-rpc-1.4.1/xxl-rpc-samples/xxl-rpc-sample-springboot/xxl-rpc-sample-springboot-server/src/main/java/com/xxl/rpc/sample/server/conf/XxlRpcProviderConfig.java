package com.xxl.rpc.sample.server.conf;

import com.xxl.rpc.registry.impl.XxlRegistryServiceRegistry;
import com.xxl.rpc.remoting.provider.impl.XxlRpcSpringProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * xxl-rpc provider config
 *
 * @author xuxueli 2018-10-19
 */
@Configuration
public class XxlRpcProviderConfig {
    private Logger logger = LoggerFactory.getLogger(XxlRpcProviderConfig.class);

    @Value("${xxl-rpc.remoting.port}")
    private int port;

    @Value("${xxl-rpc.registry.xxlregistry.address}")
    private String address;

    @Value("${xxl-rpc.registry.xxlregistry.env}")
    private String env;

    @Bean
    public XxlRpcSpringProviderFactory xxlRpcSpringProviderFactory() {

        XxlRpcSpringProviderFactory providerFactory = new XxlRpcSpringProviderFactory();
        providerFactory.setPort(port);
        providerFactory.setServiceRegistryClass(XxlRegistryServiceRegistry.class);
        providerFactory.setServiceRegistryParam(new HashMap<String, String>(){{
            put(XxlRegistryServiceRegistry.XXL_REGISTRY_ADDRESS, address);
            put(XxlRegistryServiceRegistry.ENV, env);
        }});

        logger.info(">>>>>>>>>>> xxl-rpc provider config init finish.");
        return providerFactory;
    }

}