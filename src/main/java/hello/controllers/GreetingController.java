package hello.controllers;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import hello.models.Greeting;
import hello.tasks.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("The counter is now {}", counter);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}