package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JoinDTO {
    private String user_id;
    private String user_name;
    private String user_pw;
    private String user_pw_check;
    private String gender;
    private List<String> hobby;
    private boolean machine;
    private Long year;
    private Long month;
    private Long day;
    private MultipartFile up_file;
}
