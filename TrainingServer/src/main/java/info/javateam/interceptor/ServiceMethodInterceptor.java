package info.javateam.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author Sascha
 * Do something before and after call 
 */
public class ServiceMethodInterceptor implements MethodInterceptor {

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Log logger = LogFactory.getLog(getClass());
		logger.debug("before call: "
				+ methodInvocation.getMethod().getDeclaringClass().getName()
				+ " / " + methodInvocation.getMethod().getName());
		Object result = methodInvocation.proceed();
		logger.debug("after call: "
				+ methodInvocation.getMethod().getDeclaringClass().getName()
				+ " / " + methodInvocation.getMethod().getName());
		return result;
	}
}
