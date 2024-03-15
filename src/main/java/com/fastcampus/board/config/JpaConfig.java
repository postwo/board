package com.fastcampus.board.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing /*JPA auditing은 데이터베이스의 특정 엔티티를 생성하거나 수정할 때 자동으로 시간 정보를 추적하고
엔티티에 적절한 auditing 정보를 채우는 기능을 제공합니다. 보통은 엔티티의
 생성일자, 수정일자, 생성자, 수정자 등을 추적하기 위해 사용됩니다.*/
@Configuration //각종 설정을 잡을때 사용
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware(){ //이름 String
        return () -> Optional.of("uno");//TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때 ,수정  // Auditing 을 할때마다 "uno" 이거를 넣어준다
    }
}
