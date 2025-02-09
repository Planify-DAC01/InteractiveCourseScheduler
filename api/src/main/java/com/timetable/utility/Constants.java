package com.timetable.utility;

public class Constants {

	public enum UserRole {
		ROLE_STUDENT("Student"), ROLE_ADMIN("Admin"), ROLE_TEACHER("Teacher");

		private String role;

		private UserRole(String role) {
			this.role = role;
		}

		public String value() {
			return this.role;
		}
	}

	public enum ActiveStatus {
		ACTIVE("Active"), DEACTIVATED("Deactivated");

		private String status;

		private ActiveStatus(String status) {
			this.status = status;
		}

		public String value() {
			return this.status;
		}
	}
	
	public enum DayOfWeekEnum {
	    MONDAY("Monday"),
	    TUESDAY("Tuesday"),
	    WEDNESDAY("Wednesday"),
	    THURSDAY("Thursday"),
	    FRIDAY("Friday"),
	    SATURDAY("Saturday"),
	    SUNDAY("Sunday");

	    private final String day;

	    private DayOfWeekEnum(String day) {
	        this.day = day;
	    }

	    public String value() {
	        return day;
	    }
	}
	
	public enum TimeSlotEnum {
		 SLOT_9AM_10AM("9:00 AM - 10:00 AM"),
		 SLOT_10AM_11AM("10:00 AM - 11:00 AM"),
		 SLOT_11AM_12PM("11:00 AM - 12:00 PM"),
		 SLOT_12PM_1PM("12:00 PM - 1:00 PM"),
		 SLOT_1PM_2PM("1:00 PM - 2:00 PM"),
		 SLOT_2PM_3PM("2:00 PM - 3:00 PM"),
		 SLOT_3PM_4PM("3:00 PM - 4:00 PM"),
		 SLOT_4PM_5PM("4:00 PM - 5:00 PM");

	    private final String slot;

	    private TimeSlotEnum(String slot) {
	        this.slot = slot;
	    }

	    public String value() {
	        return slot;
	    }
	}

}
