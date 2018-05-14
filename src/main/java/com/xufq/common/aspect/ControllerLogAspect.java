package com.xufq.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xufq.common.annotation.ControllerLog;


@Aspect
@Component
public class ControllerLogAspect {

	// 切入点
	@Pointcut(value = "@annotation(com.xufq.common.annotation.ControllerLog)")
	private void pointcut() {
	}

	/**
	 * 在方法执行前后
	 *
	 * @param point
	 * @param myLog
	 * @return
	 */
	@Around(value = "pointcut() && @annotation(log)")
	public Object printLog(ProceedingJoinPoint point, ControllerLog log) {
		String url = log.requestUrl();
		Class clazz = point.getTarget().getClass();
		Logger logger = getLogger(clazz);
		try {
			logger.debug("请求URL:" + url);
			Object[] args = point.getArgs();
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					logger.debug("请求参数：" + args[i].toString());
				}
			}
			return point.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return throwable.getMessage();
		}
	}

	private Logger getLogger(Class clazz) {
		return LoggerFactory.getLogger(clazz);
	}
}
