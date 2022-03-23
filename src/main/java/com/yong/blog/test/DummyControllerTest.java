package com.yong.blog.test;



import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.model.RoleType;
import com.yong.blog.model.User;
import com.yong.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	// DI(dependency injection)
	@Autowired 
	private UserRepository userRepository;
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
		
//		pagingUser.isFirst()
//		pagingUser.isLast()
		//can control paging 
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		//Lamda expression
//		User user = userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("There is no matched user");
//		})
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			
		@Override
		public IllegalArgumentException get() {
			return new IllegalArgumentException("There is no matched user" +id);
		}
			
		});
		// request: web browser
		// transfer - > json(Gson library)
		//converted file to the browser (can be readable on web browser)
		return user;
			
	}
	//http://localhost:8000/dummy/join(requset)
	//
	@PostMapping("/dummy/join")
	public String join(User user) { //key = value(protocol)
		System.out.println(user.getUsername());
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "Completed Login.";
	}
	
}
