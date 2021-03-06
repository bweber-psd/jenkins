package hudson.model;

import hudson.model.Job;
import hudson.model.Result;
import hudson.model.Run;

/**
 * Utilities used by the radiator view. 
 */
public class RadiatorUtil {

	public static Result getLastFinishedResult(Job job) {
		Run lastBuild = job.getLastBuild();
		while (lastBuild != null
				&& (lastBuild.hasntStartedYet() || lastBuild.isBuilding()
						|| lastBuild.isLogUpdated() || lastBuild.getResult() == Result.ABORTED)) {
			lastBuild = lastBuild.getPreviousBuild();
		}
		if (lastBuild != null) {
			return lastBuild.getResult();
		} else {
			return Result.NOT_BUILT;
		}
	}
}
