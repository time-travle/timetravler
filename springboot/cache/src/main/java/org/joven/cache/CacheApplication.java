package org.joven.cache;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class,
        HibernateJpaAutoConfiguration.class})
@EnableEncryptableProperties
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

//    @Bean(name = "encryptablePropertyDetector")
//    public EncryptablePropertyDetector encryptablePropertyDetector() {
//        return new CustomDecryptionDetector("(system)");
//    }
//
//    @Bean(name = "encryptablePropertyResolver")
//    public EncryptablePropertyResolver encryptablePropertyResolver() {
//        return new CustomDecryptionResolver("(system)", "Encrypt4System20");
//    }
}
