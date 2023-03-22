package basic.basiccrud.repository;

import basic.basiccrud.entity.Member;

import java.util.List;

public interface MemberRepository {


    void save(Member member);

    Member findById(Long id);

    List<Member> findAll();

    Member findByMemId(String userId);
}
