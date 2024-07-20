package com.alacriti.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionInfo {

	private String errCode;
	private String message;
	private LocalDateTime timestamp;

}
