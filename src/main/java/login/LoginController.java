package login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    
	@Autowired
	public PersonRepository repository;
	
	@RequestMapping(method = RequestMethod.POST)
    public boolean login(@RequestBody Map<String, String> loginMap) {
    	String userName = loginMap.get("userName");
    	String email = loginMap.get("email");
    	if (userName == null || email == null) {
    		return false;
    	}
        return repository.findByEmailAndUserName(email,userName).stream().count() > 0;
    }
}