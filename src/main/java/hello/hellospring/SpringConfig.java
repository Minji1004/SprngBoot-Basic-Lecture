package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //내부에 @Component가 있어서 컴포넌트 스캔 대상
public class SpringConfig {

    /*
       private final DataSource dataSource;
       //@Autowired 안붙여줘도 생성자가 한 개 뿐이라 스프링 컨테이너에서 의존성 객체를 넣어준다.
       public SpringConfig(/DataSource dataSource) {
           this.dataSource = dataSource;
       }
*/

/*
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
*/

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
*/

}



