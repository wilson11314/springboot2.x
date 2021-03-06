package com.sun.taskservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 执行调用定时任务的回调地址
 * 可以约定定时任务的回执报文，便于进一步解析
 * @author wilson
 */
@Service
public class CallbackExecuteService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CallbackExecuteService.class);
    /**
     * 缓存任务与回调之间的关系
     */
    private static final Map<String, String> CALLBACKINFO = new HashMap<>();

    /**
     * http任务处理接口
     */
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 执行远程任务
     * @param taskId
     */
    public void execute(String taskId) {
        String url = CALLBACKINFO.get(taskId);
        if (url == null) {
            LOGGER.error("任务[" + taskId + "]的回调地址为空");
            //FIXME 可以在此处加上监控或通知，也可以已异常的形式抛出，用aop同一处理
            return;
        }
        try {
            //FIXME 如果制定了返回值规则，则可以详细解析，否则就简单解析状态码
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCodeValue() >= 200 && response.getStatusCodeValue() <300) {
                //成功
                LOGGER.info("定时任务[" + taskId + "]调用完成"+ new Date());
            } else {
                //失败
                LOGGER.error("任务[" + taskId + ":" + url + "]执行失败," + response.toString());
            }
        } catch (Throwable t) {
            LOGGER.error("任务[" + taskId + ":" + url + "]执行异常", t);
            //FIXME 可以在此处加上监控或通知，也可以抛出此部分异常，用aop同一处理
        }
    }

    /**
     * 新增或修改任务回调
     * @param taskId
     * @param callbackUrl
     */
    static String addOrUpdateTask(String taskId, String callbackUrl) {
        return CALLBACKINFO.put(taskId, callbackUrl);
    }

    /**
     * 删除任务回调
     * @param taskId
     * @return
     */
    static String removeTask(String taskId) {
    	System.out.println("删除回调的缓存"+taskId);
        return CALLBACKINFO.remove(taskId);
    }
}
