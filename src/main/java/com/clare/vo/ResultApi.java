package com.clare.vo;

import com.clare.util.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("返回的统一结果")
public class ResultApi<T> extends Object implements Serializable {

    private static final long serialVersionUID = 830054763344341448L;

    @ApiModelProperty("错误码,几个固定值为: 0:成功,400:参数不合法,401:未认证，未登录，一般需要跳转到登录界面要求登录,403:已登录，但是无权限，拒绝访问,404:资源找不到,500:错误提示。600:接口请求正常，但是有来自接口的业务提示")
    private String errorCode;
    @ApiModelProperty("对应错误消息描述，适合单个错误消息")
    private Object errorMessage;
    @ApiModelProperty("对应错误消息描述，适合多个错误消息")
    private List<Object> errorMessageList;
    @ApiModelProperty("返回的结果集")
    private T result;

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ResultApi)) return false;
        ResultApi<?> other = (ResultApi) o;
        if (!other.canEqual(this)) return false;
        Object this$errorCode = getErrorCode(), other$errorCode = other.getErrorCode();
        if ((this$errorCode == null) ? (other$errorCode != null) : !this$errorCode.equals(other$errorCode))
            return false;
        Object this$errorMessage = getErrorMessage(), other$errorMessage = other.getErrorMessage();
        if ((this$errorMessage == null) ? (other$errorMessage != null) : !this$errorMessage.equals(other$errorMessage))
            return false;
        Object this$errorMessageList = getErrorMessageList(), other$errorMessageList = other.getErrorMessageList();
        if ((this$errorMessageList == null) ? (other$errorMessageList != null) : !this$errorMessageList.equals(other$errorMessageList))
            return false;
        Object this$result = getResult(), other$result = other.getResult();
        return !((this$result == null) ? (other$result != null) : !this$result.equals(other$result));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResultApi;
    }

    @Override
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $errorCode = getErrorCode();
        result = result * 59 + (($errorCode == null) ? 43 : $errorCode.hashCode());
        Object $errorMessage = getErrorMessage();
        result = result * 59 + (($errorMessage == null) ? 43 : $errorMessage.hashCode());
        Object $errorMessageList = getErrorMessageList();
        result = result * 59 + (($errorMessageList == null) ? 43 : $errorMessageList.hashCode());
        Object $result = getResult();
        return result * 59 + (($result == null) ? 43 : $result.hashCode());
    }

    public String toString() {
        return "ResultApi(errorCode=" + getErrorCode() + ", errorMessage=" + getErrorMessage() + ", errorMessageList=" + getErrorMessageList() + ", result=" + getResult() + ")";
    }



    public void setErrorMessageList(List<Object> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String getErrorCode() {
        return this.errorCode;
    }


    public Object getErrorMessage() {
        return this.errorMessage;
    }


    public List<Object> getErrorMessageList() {
        return this.errorMessageList;
    }


    public T getResult() {
        return (T) this.result;
    }


    public ResultApi() {
    }

    public ResultApi(String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = ErrorCode.errorMap.get(errorCode);
    }

    public ResultApi(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ResultApi(String errorCode, List<Object> errorMessageList) {
        this.errorCode = errorCode;
        this.errorMessageList = errorMessageList;
    }


    public ResultApi(String errorCode, String errorMessage, T result) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.result = result;
    }


    public ResultApi(String errorCode, List<Object> errorMessageList, T result) {
        this.errorCode = errorCode;
        this.errorMessageList = errorMessageList;
        this.result = result;
    }


    public ResultApi(String errorCode, T result) {
        this.errorCode = errorCode;
        this.result = result;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = ErrorCode.errorMap.get(errorCode);
    }
}
