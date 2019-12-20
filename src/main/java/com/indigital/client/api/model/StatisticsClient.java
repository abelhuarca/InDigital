package com.indigital.client.api.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StatisticsClient {

    private double averageAge;
    private double standardDeviationAge;

}
