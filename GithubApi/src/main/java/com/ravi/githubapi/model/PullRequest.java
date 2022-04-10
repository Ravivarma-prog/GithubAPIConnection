package com.ravi.githubapi.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PullRequest {

	private int pullNumber;
	private String title;
	private String createdBy; 
	private String state;
	private String lastUpdated; 
	private int DaysOld; //Days since the pr is created
	private int DaysSinceUpdate;
	private List<String> reviewers;
	
	public int getPullNumber() {
		return pullNumber;
	}
	public void setPullNumber(int pullNumber) {
		this.pullNumber = pullNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getDaysOld() {
		return DaysOld;
	}
	public void setDaysOld(int daysOld) {
		DaysOld = daysOld;
	}
	public int getDaysSinceUpdate() {
		return DaysSinceUpdate;
	}
	public void setDaysSinceUpdate(int daysSinceUpdate) {
		DaysSinceUpdate = daysSinceUpdate;
	}
	public List<String> getReviewers() {
		return reviewers;
	}
	public void setReviewers(List<String> reviewers) {
		this.reviewers = reviewers;
	}
	@Override
	public String toString() {
		return "PullRequest [pullNumber=" + pullNumber + ", title=" + title + ", createdBy=" + createdBy + ", state="
				+ state + ", lastUpdated=" + lastUpdated + ", DaysOld=" + DaysOld + ", DaysSinceUpdate="
				+ DaysSinceUpdate + ", reviewers=" + reviewers + "]";
	}

	
	
}
