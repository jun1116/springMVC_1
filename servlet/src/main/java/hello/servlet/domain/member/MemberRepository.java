package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** 동시성 문제가 고려되지 않아있기에, 실무에선 ConcurrentHashMap, AtomicLong 사용 고려 **/
public class MemberRepository {
    //== 사실 싱글톤으로 했기에 store, sequence는 static키워드가 없어도 됨 ==//
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence=0L;

    /** 싱글톤으로 쓸거야 -> static final  싱글톤으로 쓸 땐 private으로 생성자를 막아줘야해,
     * 조회는 무조건 getInstance()로 해야해 **/
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository(){}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }
    public List<Member> findAll(){
        /** store의 모든 값들을 꺼내서 새로운 ArrayList에 넣어줌
         * 물론 이렇게 해도 list에 담긴녀석 수정하면 직접적으로 수정됨**/
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
