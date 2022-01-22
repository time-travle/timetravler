package org.joven.consume.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.joven.consume.client.FeignClientProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consume1")
public class HelloTest {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignClientProvide feignClientProvide;

    // 直接调用另一个的服务 不通过注册中心
    @RequestMapping(value = "/hello")
    public String hello() {
        String res = restTemplate.getForObject("http://localhost:8762/client1/hello ", String .class);
        return res;
    }
    // 通过注册中心 调用
    @RequestMapping(value = "/hello2")
    public String hello2() {
        String res = restTemplate.getForObject("http://serviceProvide1/client1/hello ", String .class);
        return res;
    }
    @HystrixCommand(fallbackMethod = "defaultCallHello")// 当调用失败触发熔断时会用 defaultCallHello 方法来回退具体的内容
    @RequestMapping(value = "/hello3")
    public String hello3() {
        String res = feignClientProvide.hello();
        return res;
    }

    public String defaultCallHello(){
        return "service fail!";
    }
}
