package com.cox.event;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MeetingEventCompletion {

	private String company;
	private String pitchDetailsLink;
	private String senderEmail;

	@SerializedName("time")
	private String emailTime;
	private List<String> recepients;
	private List<String> decks;

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPitchDetailsLink() {
		return pitchDetailsLink;
	}
	public void setPitchDetailsLink(String pitchDetailsLink) {
		this.pitchDetailsLink = pitchDetailsLink;
	}
	public String getEmailTime() {
		return emailTime;
	}
	public void setEmailTime(String emailTime) {
		this.emailTime = emailTime;
	}
	public List<String> getRecepients() {
		return recepients;
	}
	public void setRecepients(List<String> recepients) {
		this.recepients = recepients;
	}
	public List<String> getDecks() {
		return decks;
	}
	public void setDecks(List<String> decks) {
		this.decks = decks;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	@Override
	public String toString() {
		return "EmailContents [company=" + company + ", pitchDetailsLink=" + pitchDetailsLink + ", senderEmail="
				+ senderEmail + ", emailTime=" + emailTime + ", recepients=" + recepients + ", decks=" + decks + "]";
	}
	
}
