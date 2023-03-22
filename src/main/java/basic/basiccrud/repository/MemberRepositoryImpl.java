package basic.basiccrud.repository;

import basic.basiccrud.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository{

    private final EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findByMemId(String userId) {
        return em.createQuery("select m from Member m where m.memUserid = :userId", Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m order by m.id DESC")
                .getResultList();
    }
}
