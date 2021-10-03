package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        System.out.println("name = " + name+"\n");

        log.trace("Trace log={}", name);
        log.debug("Debug log={}", name);
        log.info("info log = {}",name);
        log.warn("Warn log={}",name);
        log.error("Error Message={}",name);
        return "OK";
    }
}
/**
 * @Controller 라고 하면 View가 반환
 * @RestController 라고 어노테이션을 붙이면, 문자열 반환하면 그대로 반환됨
 * HTTP Message Body에 "OK"를 박아버린것
 * trace > debug > info > warn > error
 *   **/