package basic.basiccrud.repository;

import basic.basiccrud.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {


    void save(Member member);

    Member findById(Long id);

    List<Member> findAll();

    Optional<Member> findByMemId(String userId);
}
