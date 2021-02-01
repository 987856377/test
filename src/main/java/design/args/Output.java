package design.args;

import java.io.Serializable;

/**
 * @program: test
 * @package design.args
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-01 14:31
 **/
public class Output implements Serializable {
    private String serviceId;
    private String serviceName;
    private String methodName;
    private String returnValue;

    public Output() {
    }

    public Output(String serviceId, String serviceName, String methodName, String returnValue) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.returnValue = returnValue;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public String toString() {
        return "Output{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", returnValue='" + returnValue + '\'' +
                '}';
    }
}
