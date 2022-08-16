package com.juannobert.library.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.UserDTO;
import com.juannobert.library.api.dto.UserInsertDTO;
import com.juannobert.library.api.entities.User;
import com.juannobert.library.api.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthService authService;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> page = repository.findAll(pageable);
		return page.map(x -> new UserDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public UserDTO userProfileActive() {
		User user = authService.authenticated();
		return new UserDTO(user);
	}
	
	@Transactional
	public UserDTO save(UserInsertDTO dto) {
		User entity = new User();
		BeanUtils.copyProperties(dto, entity,"id","password");
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			logger.error("User not found.Email: " + username);
			throw new UsernameNotFoundException("User not found");
		}
		logger.info("User found: " + username);
		return user;
	}
	
	
	
	
	
	
}
