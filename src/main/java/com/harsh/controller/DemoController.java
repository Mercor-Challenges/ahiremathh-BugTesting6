package com.harsh.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
	@GetMapping("/forusers")
	 @RolesAllowed({"user","admin"})
	public ResponseEntity<?> testUsers(){
		Object a = new Object() {
			private String msg = "For users only";

			public String getMsg() {
				return msg;
			}

			public void setMsg(String msg) {
				this.msg = msg;
			}
			
		};
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	@GetMapping("/foradmin")
	 @RolesAllowed("admin")
	public ResponseEntity<?> testAdmin(){
		Object a = new Object() {
			private String msg = "For admin only";

			public String getMsg() {
				return msg;
			}

			public void setMsg(String msg) {
				this.msg = msg;
			}
			
		};
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
}
