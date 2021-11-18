package com.zegume.springintegration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@EnableIntegration
public class SpringIntegrationConfiguration {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private long id = 1;

    @Autowired
    Handler handler;

    /*
    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setMaxMessagesPerPoll(5);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(5);
        executor.initialize();
        pollerMetadata.setTaskExecutor(executor);
        return pollerMetadata;
    }

    @Bean
    public PollableChannel queueChannel() {
        return new QueueChannel(5);
    }
     */

    @InboundChannelAdapter(channel = "queueChannel", poller = @Poller(fixedRate = "5000"))
    public List<Data> getNewMessages() {
        List<Data> result       = new ArrayList<>();
        Random     random       = new Random();
        int        elementCount = random.nextInt(10);
        for (int i = 0; i < elementCount; i++) {
            Data data = new Data();
            data.setValue(id);
            result.add(data);
            id++;
        }
        logger.info("{} records added", elementCount);
        return result;
    }

    @Splitter(inputChannel = "queueChannel", outputChannel = "requestChannel")
    public Collection<Data> splitMessages(List<Data> records) {
        return records;
    }

    @ServiceActivator(inputChannel = "requestChannel")
    @Async
    public void process(Data value) {
        handler.process(value);
    }

}
