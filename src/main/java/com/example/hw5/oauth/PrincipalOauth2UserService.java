package com.example.hw5.oauth;


import com.example.hw5.user.dto.UserDTO;
import com.example.hw5.user.repo.UserRepo;
import com.example.hw5.user.service.UserService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;




// 구글 , 카톡같이 유저 정보를 OAuth2 를 이용해서 사용하는 것이다 ..?
// 로그인을 처리하는 프로세스이다.

@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepo userRepo;
    private final UserService userService;

    public PrincipalOauth2UserService(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @Override
    public OAuth2User loadUser(
            OAuth2UserRequest oAuth2UserRequest)
            throws OAuth2AuthenticationException {

        log.info("google 에서 받아온 userRequest:"+oAuth2UserRequest );
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        log.info("oauth에서 받아온 정보 : "+ oAuth2User.getAttributes());

        userService.createUser(toDTO(oAuth2User));//err......

        return super.loadUser(oAuth2UserRequest);
    }
    public UserCreateDTO toDTO(OAuth2User oAuth2User){
        String name = oAuth2User.getAttribute("name").toString();
        String email = oAuth2User.getAttribute("email").toString();
        return new UserCreateDTO(name, email);
    }
}

//@Service
//@Slf4j
//public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
//
//    private final UserService userService;
//    public PrincipalOauth2UserService(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @Override
//    public OAuth2User loadUser(
//            OAuth2UserRequest oAuth2UserRequest
//    )throws OAuth2AuthenticationException{
//        log.info("Google 에서 받아온 User req: " + oAuth2UserRequest);
//        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
//
//        log.info("Google에서 받아온 정보"+ oAuth2User);
//        log.info("oauth에서 받아온 정보 : " + oAuth2User.getAttributes());
//
//        String name = (String) oAuth2User.getAttribute("name");
//        String email = (String) oAuth2User.getAttribute("email");
//
//        UserDTO.Create userCreateDTO = UserDTO.Create.builder()
//                .name(name)
//                .email(email)
//                .build();
//        // UserService를 통해 사용자를 저장
//        userService.createUser(userCreateDTO);
//
//
//
//        return super.loadUser(oAuth2UserRequest);
//    }
//}
