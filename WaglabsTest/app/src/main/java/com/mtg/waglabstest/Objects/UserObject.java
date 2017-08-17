package com.mtg.waglabstest.Objects;

/**
 * Created by Matt on 8/17/2017.
 */

public class UserObject {

    private BadgeCount badge_counts;
    private long reputation;
    private String profile_image;
    private String display_name;

    private class BadgeCount {
        private long bronze;
        private long silver;
        private long gold;
    }

    public long getGoldCount() {
        return badge_counts.gold;
    }

    public long getSilverCount() {
        return badge_counts.silver;
    }

    public long getBronzeCount() {
        return badge_counts.bronze;
    }

    public long getReputation() {
        return reputation;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }
}
