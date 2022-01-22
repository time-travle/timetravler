package org.joven.subscriber.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyExpensesInfoEntity implements Serializable {
    private Integer id;
    private String name;
    private String value;
    private String currency;
    private String paymentMethod;
    private String reason;
    private Date eff_time;
    private Date inputTime;
    private String haveCertificate;
    private String isreturn;
    private String sub_id;
    private String informationSources;
    private String remark1;
    private String remark2;
}
