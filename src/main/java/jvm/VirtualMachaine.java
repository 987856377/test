package jvm;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @program: test
 * @package jvm
 * @description
 * @author: XuZhenkui
 * @create: 2021-01-13 11:17
 **/
public class VirtualMachaine {
    private static final Logger logger = LoggerFactory.getLogger(VirtualMachaine.class);

    public static void main(String[] args) throws IOException {
        String pid = "19504";
        VirtualMachine virtualMachine = null;
        VirtualMachineDescriptor virtualMachineDescriptor = null;

        for (VirtualMachineDescriptor descriptor : VirtualMachine.list()) {
            if (pid.equals(descriptor.id())){
                virtualMachineDescriptor = descriptor;
                break;
            }
        }
        try {
            if (virtualMachineDescriptor != null) {
                virtualMachine = virtualMachine.attach(virtualMachineDescriptor.id());
            } else {
//                virtualMachine = virtualMachine.attach(virtualMachineDescriptor);
            }

//            Properties targetSystemProperties = virtualMachine.getSystemProperties();
//            String targetJavaVersion = targetSystemProperties.getProperty("java.specification.version");
//            String currentJavaVersion = System.getProperty("java.specification.version");
//            if (targetJavaVersion != null && currentJavaVersion != null) {
//                if (!targetJavaVersion.equals(currentJavaVersion)) {
//                    logger.warn("Current VM java version: {} do not match target VM java version: {}, attach may fail.",
//                            currentJavaVersion, targetJavaVersion);
//                    logger.warn("Target VM JAVA_HOME is {}, arthas-boot JAVA_HOME is {}, try to set the same JAVA_HOME.",
//                            targetSystemProperties.getProperty("java.home"), System.getProperty("java.home"));
//                }
//            }

            System.out.println("System.getProperties() = " + System.getProperty("java.library.path"));
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (virtualMachine != null){
                virtualMachine.detach();
            }
        }

    }
}
