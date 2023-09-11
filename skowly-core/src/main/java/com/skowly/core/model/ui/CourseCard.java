package com.skowly.core.model.ui;

import lombok.Data;

@Data public class CourseCard {

	private String courseName;
	private byte[] courseIcon;
	private String teacherName;
	private byte[] teacherIcon;
	private Boolean hasNotifications;
	
}
