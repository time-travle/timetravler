package org.joven.consume.hystrix;


import org.joven.consume.client.FeignClientProvide;
import org.springframework.stereotype.Component;

@Component
public class FeignClientProvideHystrix implements FeignClientProvide {
    @Override
    public String hello() {
        return "cant touch right service";
    }

    @Override
    public String hello2(String name) {
        return "cant touch right service2";
    }
}
