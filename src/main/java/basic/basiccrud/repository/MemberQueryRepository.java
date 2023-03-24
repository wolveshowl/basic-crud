package basic.basiccrud.repository;

import basic.basiccrud.entity.Member;

import java.util.List;

public interface MemberQueryRepository {

    List<Member> findMember();
}
