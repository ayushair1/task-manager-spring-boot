package com.consultadd.Taskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @NotBlank(message = "Please Add Task Name")
    private String taskName;
    private String taskDescription;

    @Temporal(TemporalType.DATE)
    private LocalDate taskCreatedDate;

    @Temporal(TemporalType.DATE)
    private Date taskDueDate;

//    private String taskStatus;
//    @Enumerated(EnumType.STRING)
    private String currentStatus;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="Assign_To")
//    private AssignTask taskAssignTo;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity assignee;






}
