package org.joven.consume.hystrix;

import feign.hystrix.FallbackFactory;
import org.joven.consume.client.FeignClientProvide;
import org.springframework.stereotype.Component;


@Component
public class FeignClientProvideFallbackFactory implements FallbackFactory<FeignClientProvide> {
    @Override
    public FeignClientProvide create(Throwable throwable) {
        return new FeignClientProvide(){

            @Override
            public String hello() {
                return "Factory cant touch right service"+throwable.getMessage();
            }

            @Override
            public String hello2(String name) {
                return "Factory cant touch right service2"+throwable.getMessage();
            }
        };
    }
}
