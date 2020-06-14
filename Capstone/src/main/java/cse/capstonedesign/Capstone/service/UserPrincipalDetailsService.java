package cse.capstonedesign.Capstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cse.capstonedesign.Capstone.dto.request.UserPrincipal;
import cse.capstonedesign.Capstone.mapper.UserMapper;
import cse.capstonedesign.Capstone.model.User;
import cse.capstonedesign.Capstone.model.UserLogin;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private static final String ROLE_PREFIX = "ROLE_";
    
	private UserMapper userMapper;

	public UserPrincipalDetailsService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userMapper.findByEmail(email);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		System.out.println(user.getEmail() + " " + user.getPassword() + ": Detail 가져옴");
		System.out.println(userPrincipal.getUsername() + " " + userPrincipal.getPassword() + ": Detail 가져옴");

//        if(user != null) {
//        	user.setAuthorities(makeGrantedAuthority(userPrincipal.getAuthorities());
//        }
//        return new SecurityMember(member);
		
		return userPrincipal;
	}

	private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
		return list;
	}

}
