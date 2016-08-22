package com.SpringMongo.LoginModule;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mongodb.Alloperation.AllMongoOperation;

@Controller
public class LoginModuleController {
		
	
		// insert data user registration methods....
		@RequestMapping("/signUpHere.html")
		public ModelAndView getSignUpPage(){
			ModelAndView model=new ModelAndView("/SignUpForm");
			return model;
		}
		
		@RequestMapping(value="/completeRegistration.html", method = RequestMethod.POST)
		public ModelAndView insertUserData(@ModelAttribute("userregistration1")UserRegistration userregistration1,BindingResult result){
			if(result.hasErrors()){
				ModelAndView model=new ModelAndView("/SignUpForm");
				return model;
			}
			AllMongoOperation allmongooperation=new AllMongoOperation();
			boolean flag=false;
			flag=allmongooperation.insertData(userregistration1);
			if(!flag){
				ModelAndView model=new ModelAndView("/SignUpForm");
				model.addObject("message","Email duplicate entry not allowed...");
				return model;
			}
			ModelAndView model=new ModelAndView("/SignUpSuccessForm");
			return model;
		}
		
		//login methods......
		@RequestMapping("/SignIn.html")
		public ModelAndView getSignInForm(){
			ModelAndView model=new ModelAndView("/index");
			return model;
		}
		@RequestMapping(value="/loginPair.html",method = RequestMethod.POST)
		public ModelAndView matchLoginPair(@ModelAttribute("userregistration1")UserRegistration userregistration1,BindingResult result){
			System.out.println("--------in method------");
			if(result.hasErrors()){
				ModelAndView model=new ModelAndView("/index");
				return model;
			}
			AllMongoOperation allmongooperation=new AllMongoOperation();
			boolean flag=false;
			flag=allmongooperation.checkUserLogin(userregistration1);
			System.out.println("--------flag value------"+flag);
			if(!flag){
				ModelAndView model=new ModelAndView("/index");
				model.addObject("message","wrong email Id or Password");
				return model;
			}
			ModelAndView model=new ModelAndView("/successLogin");
			return model;
		}
		
		
		//forgot password methos,,,,,,,
		@RequestMapping("/forgotPassword.html")
		public ModelAndView getForgotPasswordForm(){
			ModelAndView model=new ModelAndView("/ForgotPassword");
			return model;
		}
		@RequestMapping(value="/updateYourPassword.html",method = RequestMethod.POST)
		public ModelAndView updateYourPassword(@ModelAttribute("userregistration1")UserRegistration userregistration1,BindingResult result){
			if(result.hasErrors()){
				ModelAndView model=new ModelAndView("/ForgotPassword");
				return model;
			}
			boolean flag=false;
			AllMongoOperation mongooperation=new AllMongoOperation();
			flag=mongooperation.updatePassword(userregistration1);
			if(!flag){
				ModelAndView model=new ModelAndView("/ForgotPassword");
				model.addObject("message","your password has not been updated!!!");
				return model;
			}
			ModelAndView model=new ModelAndView("/successUpdate");
			return model;
		}
		
}
