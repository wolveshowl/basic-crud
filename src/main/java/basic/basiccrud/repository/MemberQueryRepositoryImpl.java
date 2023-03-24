package basic.basiccrud.repository;

import basic.basiccrud.entity.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository {

    private final EntityManager em;

    @Override
    public List<Member> findMember() {
        return null;
    }
}
