package cn.mldn.microboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.StartSpringBootMain;
import cn.mldn.microboot.producer.ImessageProducerService;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
	@Resource
	private ImessageProducerService messageProducer;
	@Test
	public void testSend() throws Exception{
	    for (int i = 0; i < 103; i++) {
            this.messageProducer.sendMessage("mldn-"+i);
        }
	}
}
