package com.src.starters.Controller;

import java.awt.Image;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.starters.Entities.Teacher;
import com.src.starters.Model.TeacherModel;

@RestController
public class TeacherController {
	
	@RequestMapping("/Teacher/Signup/{password}/{name}/{gender}/{mail}/{age}")
	public  Teacher SignUp( @PathVariable String password , @PathVariable String name ,
			@PathVariable String  gender , @PathVariable String mail , @PathVariable int age) throws SQLException
	{
		TeacherModel x =new TeacherModel();
		String result =x.AddTeacher(password, name, gender, mail, age);
		Teacher t=new Teacher() ;
		t.setAge(age);
		t.setGender(gender);
		t.setPassword(password);
		t.setMail(mail);
		t.setName(name);
		t.setScore(0);
		return t;
	}
	
	@RequestMapping("/Teacher/Login/{password}/{mail}")
	public Teacher Login(@PathVariable String password ,@PathVariable String mail) throws SQLException
	{
		Teacher x =new Teacher();
		TeacherModel y =new TeacherModel();
		x=y.GetTeacher(password , mail);
		return x;
		
	}

	@RequestMapping("/Teacher/Updatescore/{password}/{newscore}")
	public String updateScore(@PathVariable int newscore , @PathVariable String password ) throws SQLException
	{
		TeacherModel x =new TeacherModel();
		x.UpdateScore(newscore , password);
		return "Score Updated"; 
	}

	@RequestMapping("/Teacher/Updatprofilepicture/{password}/{newimage}")
	public void updateProfilepicture(@PathVariable Image newimage ,@PathVariable String password )
	{
		TeacherModel x =new TeacherModel();
		x.UpdateProfilePicture(newimage,password);
	}
}
