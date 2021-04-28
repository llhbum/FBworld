package FBworld.models;

import java.util.Date;

import lombok.Data;

@Data
public class quizboardDTO {
	private long no;
	private String title;
	private String content;
	private String imagepath;
	private String hint1;
	private String hint2;
	private String hint3;
	private String hint4;
	private String hint5;
	private String answer;
	private String hitman;
	private Date regdate;
	private long readcount;
	private Date expdate;
	private long expirecheck;
}
