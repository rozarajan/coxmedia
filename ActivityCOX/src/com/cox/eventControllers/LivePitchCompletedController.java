package com.cox.eventControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cox.event.MeetingEventCompletion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class LivePitchCompletedController {

	@RequestMapping(value="/livepitchcompleted", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity livePitchHappenedPost(@RequestBody String livePitchHappenedStr, @RequestHeader("hmac") String hmac){
		System.out.println("Received a live pitch happened event"+livePitchHappenedStr);
		
		//code to convert string to json object and later to java object comes here
		getJavaObject(livePitchHappenedStr);
		 return new ResponseEntity(HttpStatus.OK);
	}
	
	public MeetingEventCompletion getJavaObject(String JsonDataInString){
		
		MeetingEventCompletion email1= new MeetingEventCompletion();
		Gson gson= new GsonBuilder().setPrettyPrinting().create();
		email1= gson.fromJson(JsonDataInString, MeetingEventCompletion.class);
		
		return email1;
	}
	
}