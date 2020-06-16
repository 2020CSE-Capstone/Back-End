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
import cse.capstonedesign.Capstone.filter.CustomUserPasswordAuthenticationFilter;
import cse.capstonedesign.Capstone.mapper.UserMapper;
import cse.capstonedesign.Capstone.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		
		log.info("[loadUserByUsername] email : {}, password: **** ", user.getEmail());
		
		return userPrincipal;
	}

	private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
		return list;
	}

}
