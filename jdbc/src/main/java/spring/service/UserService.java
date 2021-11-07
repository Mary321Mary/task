package spring.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.UserDetailsImpl;
import spring.daoi.UserDaoI;
import spring.models.User;

@Service
@Transactional
public class UserService implements UserDetailsService {
	
    private UserDaoI userDao;

	public UserService(UserDaoI userDao){
		this.userDao = userDao;
	}

	@PreAuthorize("hasAnyAuthority('admin')")
    public List<User> findAll() {
        return userDao.findAll();
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);
	}
}
