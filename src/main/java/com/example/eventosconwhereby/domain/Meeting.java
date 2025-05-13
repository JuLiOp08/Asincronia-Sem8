package com.example.eventosconwhereby.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String meetingId;
    private String startDate;
    private String endDate;

    @Column(columnDefinition="TEXT", length = 2048)
    private String roomUrl;

    @Column(columnDefinition="TEXT", length = 2048)
    private String hostRoomUrl;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}