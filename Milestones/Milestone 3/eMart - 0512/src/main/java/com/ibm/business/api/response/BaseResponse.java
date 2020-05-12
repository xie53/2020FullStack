package com.ibm.business.api.response;

public class BaseResponse<T> {

	protected String status;
	protected T result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

    @Override
    public String toString() {
        return "BaseResponse [status=" + status + ", result=" + result + "]";
    }
	
}
