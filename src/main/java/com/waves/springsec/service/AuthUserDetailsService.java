package com.waves.springsec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.waves.springsec.dto.UserDto;
import com.waves.springsec.entity.Authority;
import com.waves.springsec.entity.User;
import com.waves.springsec.repository.AuthorityRepository;
import com.waves.springsec.repository.UserRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User userOptional = userRepository.getByUserName(userName);
		UserDto userDto = null;
		AuthUserDetail authUserDetail = null;
		if (userOptional != null) {
			List<Authority> authorityList = authorityRepository.findByUserId(userOptional.getUserId());
			if (!authorityList.isEmpty() && authorityList != null) {
				List<GrantedAuthority> grantedAuthorityList = authorityList.stream()
						.map(list -> new SimpleGrantedAuthority(list.getAuthorityName())).collect(Collectors.toList());
				
				userDto= new UserDto(userOptional.getUserId(), userOptional.getUserName(), userOptional.getPassword(), userOptional.isEnabledYN(), grantedAuthorityList);
				authUserDetail = new AuthUserDetail(userDto);
			}
		}else {
			throw new UsernameNotFoundException(userName+" Not Found!");
		}
		return authUserDetail;
	}

}
