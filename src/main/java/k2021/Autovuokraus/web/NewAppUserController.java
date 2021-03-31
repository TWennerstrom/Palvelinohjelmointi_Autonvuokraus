package k2021.Autovuokraus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k2021.Autovuokraus.domain.AppUser;
import k2021.Autovuokraus.domain.AppUserRepository;
import k2021.Autovuokraus.domain.NewAppUser;

import javax.validation.Valid;


@Controller
public class NewAppUserController {
	@Autowired
    private AppUserRepository repository; 
	
    @RequestMapping(value = "create")
    public String addStudent(Model model){
    	model.addAttribute("newAppUser", new NewAppUser());
        return "newAppUser";
    }	
    
    @RequestMapping(value = "saveNewAppUser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") NewAppUser newAppUser, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) {
    		if (newAppUser.getPassword().equals(newAppUser.getPasswordCheck())) {		
	    		String pwd = newAppUser.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	AppUser newUser = new AppUser();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(newAppUser.getUsername());
		    	newUser.setRole("USER");
		    	if (repository.findByUsername(newAppUser.getUsername()) == null) {
		    		repository.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "newAppUser";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "newAppUser";
    		}
    	}
    	else {
    		return "newAppUser";
    	}
    	return "redirect:/login";    	
    }    
    
}
