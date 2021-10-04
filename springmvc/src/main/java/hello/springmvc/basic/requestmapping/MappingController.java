package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("mappingPath : userId={}", userId);
        return "OK " + userId;
    }
    /** PathVariable의 () 생략 -> 파라미터명이 같을 떄 **/
    @GetMapping("/mapping2/{userId}")
    public String mapping2Path(@PathVariable String userId) {
        log.info("mappingPath : userId={}", userId);
        return "OK " + userId;
    }
    /** 다중 매핑 **/
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}",userId,orderId);
        return "OK " + userId+" 의 " +orderId + "번째 주문건 입니다.";
    }
    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value="/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mapping Header");
        return "OK";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value="/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mapping Header");
        return "OK";
    }
    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json" -> 헤더의 content-type이 application/json 인 경우에만 호출됨
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
//    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(@RequestBody String userId) {
        log.info("mappingConsumes, {}",userId);
        return "ok";
    }
    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
