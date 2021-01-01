package io.spring.dataflow.sample.usagecostprocessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsageCostDetail {

	private String userId;
	private double callCost;
	private double dataCost;
}
