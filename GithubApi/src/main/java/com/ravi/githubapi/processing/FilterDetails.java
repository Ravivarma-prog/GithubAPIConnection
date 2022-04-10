package com.ravi.githubapi.processing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.ravi.githubapi.model.PullRequest;

@Component
public class FilterDetails {

	// To calculate the number of days

	public int getDays(Date d1, Date d2) {
		long diff = d1.getTime() - d2.getTime();
		int days = (int) (diff / (1000 * 60 * 60 * 24));

		return days;
	}

	/*
	 * This method accepts the String resulting from the API call and returns a list
	 * of PullRequests after filtering out the necessary details
	 */

	public List<PullRequest> getPullDetails(String s) throws ParseException {
		List<PullRequest> prList = new ArrayList<PullRequest>();

		// Creating a JSONArray with the input String
		JSONArray jsonArray = new JSONArray(s);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject objectInArray = jsonArray.getJSONObject(i);

			//Getting the fields from json object
			String title = objectInArray.getString("title");
			String lastUpdated = objectInArray.getString("updated_at");
			String created = objectInArray.getString("created_at");
			String state = objectInArray.getString("state");
			String createdBy = objectInArray.getJSONObject("user").getString("login");
			int pullNumber = objectInArray.getInt("number");

			// Calculating the days for created and updated

			Date currDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date createdDate = sdf.parse(created);
			Date updatedDate = sdf.parse(lastUpdated);

			int DaysOld = getDays(currDate, createdDate);
			int DaysSinceUpdate = getDays(currDate, updatedDate);

			// Getting a list of requested reviewers for the pull request
			List<String> reviewers = new ArrayList<String>();
			JSONArray reviewerList = objectInArray.getJSONArray("requested_reviewers");

			for (int j = 0; j < reviewerList.length(); j++)
				reviewers.add(reviewerList.getJSONObject(j).getString("login"));

			// Populating the fields of pullRequest object and adding it to the output list
			PullRequest pr = new PullRequest();
			pr.setTitle(title);
			pr.setState(state);
			pr.setReviewers(reviewers);
			pr.setDaysOld(DaysOld);
			pr.setCreatedBy(createdBy);
			pr.setDaysSinceUpdate(DaysSinceUpdate);
			pr.setLastUpdated(lastUpdated);
			pr.setPullNumber(pullNumber);

			prList.add(pr);

		}

		System.out.println(prList);
		return prList;
	}

}
