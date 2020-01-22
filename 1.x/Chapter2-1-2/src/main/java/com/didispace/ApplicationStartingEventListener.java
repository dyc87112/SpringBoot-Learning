package com.didispace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("......ApplicationStartingEvent......");
    }

}
