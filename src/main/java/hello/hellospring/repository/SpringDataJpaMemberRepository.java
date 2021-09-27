package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,
        MemberRepository {

    //구현체 생성할 필요없이, SQL Query도 작성할 필요없이 기능 구현 완성.
    //스프링데이터는 메서드 이름만으로 Query가 생성되게끔 만들어졌다.
    //findByName은 select * from Member m where m.name = ? 와 같다.
    //findByNameAndEmail 은 select * from Member m where m.name = ? and m.email = ? 와 같다.
    Optional<Member> findByName(String name);

}
