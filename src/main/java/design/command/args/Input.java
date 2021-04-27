package design.command.args;

import java.io.Serializable;

/**
 * @program: test
 * @package design.command.args
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-01 14:30
 **/
public class Input implements Serializable {
    private String serviceId;
    private String serviceName;
    private String methodName;
    private String args;

    public Input() {
    }

    public Input(String serviceId, String serviceName, String methodName, String args) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.args = args;
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

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "Input{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", args='" + args + '\'' +
                '}';
    }
}
