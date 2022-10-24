package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

//  note: jdbc, jdbc template repository 예제
//  private final DataSource dataSource;
//
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }

//  note: jpa repository 예제
//  private final EntityManager em;
//
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }

  private final MemberRepository memberRepository;
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
//  spring data jpa를 제외한 나머지 방식을 사용할때 쓰는 예제
//  return new MemberService(memberRepository());

    return new MemberService(memberRepository);
  }

  @Bean // note: aop를 명시적으로 사용한다고 표현하기 위해서 springconfig에 작성했다.
  public TimeTraceAop timeTraceAop() {
    return new TimeTraceAop();
  }

//  @Bean
//  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//    return new JdbcMemberRepository(dataSource);
//    return new JdbcTemplateMemberRepository(dataSource);
//    return new JpaMemberRepository(em);
//  }
}
