package com.yong.blog.test;



import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.model.RoleType;
import com.yong.blog.model.User;
import com.yong.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	// DI(dependency injection)
	@Autowired 
	private UserRepository userRepository;
	

	//email, passowrd
	@Transactional // when function is closed, a commit will happen
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User requestUser) {
		System.out.println("id" +id);
		System.out.println("password" +requestUser.getPassword());
		System.out.println("email" + requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Fail to update");
		});
		user.setUsername(requestUser.getUsername());
		user.setEmail(requestUser.getEmail());
		
//		userRepository.save(user);
		return user;
	}
	
	@DeleteMapping("/dymmy/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			
			userRepository.deleteById(id);
		}catch(IllegalArgumentException e){
			return "failed to delete id";
		}
		
		return "Successfully delete id"+id;
	}
	
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
