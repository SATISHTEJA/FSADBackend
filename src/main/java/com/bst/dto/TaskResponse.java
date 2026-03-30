package com.bst.dto;

public class TaskResponse {

	private Long taskId;
    private String taskTitle;
    private Long internshipId;
    private String internshipName;
	private String status;
    private String submissionDescription;
    private String submissionFileData;
    private String submissionFileName;

    public TaskResponse(Long taskId, String taskTitle,
                        Long internshipId, String internshipName,
                        String status,
                        String submissionDescription,
                        String submissionFileData,
                        String submissionFileName) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.internshipId = internshipId;
        this.internshipName = internshipName;
        this.status = status;
        this.submissionDescription = submissionDescription;
        this.submissionFileData = submissionFileData;
        this.submissionFileName = submissionFileName;
    }

    // Getters
    public Long getTaskId() { return taskId; }
    public String getTaskTitle() { return taskTitle; }
    public Long getInternshipId() { return internshipId; }
    public String getInternshipName() { return internshipName; }
}