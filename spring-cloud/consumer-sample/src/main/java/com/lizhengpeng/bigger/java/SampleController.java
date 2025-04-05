package com.lizhengpeng.bigger.java;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@RestController
public class SampleController {

    private static final String CONSUMER_SAMPLE = "consumer-sample";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private ProviderFeign providerFeign;

    @Resource
    private NacosConfigManager nacosConfigManager;

    @GetMapping("/test-loader-balancer")
    public void testLoaderBalancer() {
        loadBalancerClient.choose("provider-sample");
    }

    @GetMapping("/hello")
    public String callProvider() {
        return providerFeign.callHello();
    }

    @GetMapping("/hello-by-rest-template")
    public String callProviderByRestTemplate() {
        return restTemplate.getForObject("http://provider-sample/hello", String.class);
    }

    @GetMapping("/config-sample")
    public void configSample() throws NacosException {
        nacosConfigManager.getConfigService().addListener("provider-sample", "DEFAULT_GROUP", new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {

            }
        });
    }

}
