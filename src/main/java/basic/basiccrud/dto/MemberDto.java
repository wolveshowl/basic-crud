package basic.basiccrud.dto;

import basic.basiccrud.entity.Member;
import basic.basiccrud.entity.UserRole;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private String memUserId;

    private String memPwd;

    private String memUsername;

    private String memNickname;

    private char memGender;
    private LocalDateTime memRegdate;
    private UserRole role;

    public Member toEntity() {
        Member member = Member.builder()
                .memUserid(memUserId)
                .memPwd(memPwd)
                .memUsername(memUsername)
                .memNickname(memNickname)
                .memGender(memGender)
                .memRegdate(LocalDateTime.now())
                .role(UserRole.normal)
                .build();
        return member;
    }

    public Member login() {
        Member member = Member.builder()
                .memUserid(memUserId)
                .memPwd(memPwd)
                .build();
        return member;
    }
}
