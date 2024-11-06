package com.example.job_application_portal.utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SkillMatcher {
    public static double calculateMatchScore(String userSkills, String jobSkills) {
        Set<String> userSkillSet = new HashSet<>(Arrays.asList(userSkills.toLowerCase().split("\\s*,\\s*")));
        Set<String> jobSkillSet = new HashSet<>(Arrays.asList(jobSkills.toLowerCase().split("\\s*,\\s*")));

        userSkillSet.retainAll(jobSkillSet);

        int matchedSkills = userSkillSet.size();
        int totalJobSkills = jobSkillSet.size();

        double score = totalJobSkills > 0 ? (matchedSkills / (double) totalJobSkills) * 100 : 0;

        return Math.round(score * 100.0) / 100.0;
    }
}
