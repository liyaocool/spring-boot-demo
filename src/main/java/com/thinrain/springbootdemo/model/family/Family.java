package com.thinrain.springbootdemo.model.family;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "family")
public class Family {

    //@Value("${family.family-name}")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}
