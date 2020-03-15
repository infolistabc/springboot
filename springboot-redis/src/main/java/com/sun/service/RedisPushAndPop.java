package com.sun.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class RedisPushAndPop implements DisposableBean {
	private static final Logger logger = LoggerFactory.getLogger(RedisPushAndPop.class);
	@Autowired
    private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private ExecutorConfig executorConfig;
	
	public Object lpush(String key,Object value) {
		return redisTemplate.opsForList().leftPush(key, value);
	}
	@Async("asyncServiceExecutor")
	public void execute() {
		new Thread(new Consumer()).start();;
	}
	@Async("asyncServiceExecutor")
    public void asyncTask1 (){
		executorConfig.asyncServiceExecutor().execute(new Consumer());
//        while(true) {
//			try {
//				Object obj = redisTemplate.opsForList().leftPop("test");
//				logger.info("start executeAsync"+obj);
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
    }
	
	private class Consumer implements Runnable{
		@Override
		public void run() {
			consumerMsg();
		}
		
		public void consumerMsg() {
			while(true) {
				try {
					Object obj = redisTemplate.opsForList().leftPop("test");
					logger.info("start executeAsync"+obj);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void destroy() throws Exception {
		asyncTask1 ();
	}
}
