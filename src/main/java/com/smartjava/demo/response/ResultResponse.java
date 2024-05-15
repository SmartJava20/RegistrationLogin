package com.smartjava.demo.response;

public class ResultResponse {
	
	private MetadataResponse metadata;
	private Object result;
	
	public MetadataResponse getMetadata() {
		return metadata;
	}
	public void setMetadata(MetadataResponse metadata) {
		this.metadata = metadata;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	

}
