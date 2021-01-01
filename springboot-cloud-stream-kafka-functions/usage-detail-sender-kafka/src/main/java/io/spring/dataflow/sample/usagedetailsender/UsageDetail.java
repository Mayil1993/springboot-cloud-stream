package io.spring.dataflow.sample.usagedetailsender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsageDetail {

	private String userId;
	private long duration;
	private long data;
}
