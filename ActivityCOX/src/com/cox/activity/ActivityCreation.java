package com.cox.activity;

import java.net.URL;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;

import com.cox.event.MeetingEventCompletion;
import com.cox.eventControllers.LivePitchCompletedController;
import com.oracle.xmlns.adf.svc.types.DataObjectResult;
import com.oracle.xmlns.apps.crmcommon.activities.activitymanagementservice.Activity;
import com.oracle.xmlns.apps.crmcommon.activities.activitymanagementservice.ActivityService;
import com.oracle.xmlns.apps.crmcommon.activities.activitymanagementservice.ActivityService_Service;
import com.oracle.xmlns.apps.crmcommon.activities.activitymanagementservice.ObjectFactory;

public class ActivityCreation {

	static ActivityService activityService;
	
	@Autowired
	static MeetingEventCompletion meeting;
	public static void main(String[] args) {
		

		try {
			Authenticate();
			
			
			Activity result = activityService.createActivity(getActivity(meeting));
			if (result != null){
				System.out.println("activity id"+result.getActivityId());
				System.out.println(" Successful");
			}
		} catch (Exception e) {
			System.out.println("Failure");
			e.printStackTrace();
		}

	}
	
	private static Activity getActivity(MeetingEventCompletion meeting2){
		ObjectFactory objFactory = new ObjectFactory();
		Activity act = objFactory.createActivity();
		act.setSubject(meeting2.getCompany());
		act.setActivityTypeCode(objFactory.createActivityActivityTypeCode("CALL"));
		act.setActivityFunctionCode("TASK");
		return act;
	}

	private static void Authenticate() throws Exception {
		ActivityService_Service activityService_Service = new ActivityService_Service(new URL(
				"https://cbpb-test.crm.us2.oraclecloud.com/appCmmnCompActivitiesActivityManagement/ActivityService?WSDL"));
		activityService = activityService_Service.getActivityServiceSoapHttpPort();

		Map<String, Object> requestCredentials = ((BindingProvider) activityService).getRequestContext();
		requestCredentials.put(BindingProvider.USERNAME_PROPERTY, "MJAGANATHAN");
		requestCredentials.put(BindingProvider.PASSWORD_PROPERTY, "OnDemand$1CX");
		requestCredentials.put("com.sun.xml.internal.ws.request.timeout", 25000);
	}

}
