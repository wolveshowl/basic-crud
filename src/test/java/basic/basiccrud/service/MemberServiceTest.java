package basic.basiccrud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Slf4j
class MemberServiceTest {

    @Autowired
    private MemberService memberService;


}