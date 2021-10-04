package hello.springmvc.basic;

import lombok.Data;

@Data
public class HelloData {
    private String username;
    private int age;
}
/** @Data
 * @Getter, @Setter, @ToString, @EquealsAndHashCode
 * @RequiredArgsConstructor 를 자동 적용**/
