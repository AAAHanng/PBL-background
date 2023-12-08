package com.pbl.configuration;

import com.pbl.entity.vo.request.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    /**
     * 我们自己的用户实体对象，要调取用户信息时直接获取这个实体对象
     */
    private UserVO userVO;

    public CustomUser(UserVO userVO, Collection<? extends GrantedAuthority> authorities) {
        super(userVO.getUsername(), userVO.getPassword(), authorities);
        this.userVO = userVO;
    }

    public UserVO getuserVO() {
        return userVO;
    }

    public void setuserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}
