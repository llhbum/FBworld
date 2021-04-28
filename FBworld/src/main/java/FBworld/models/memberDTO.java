package FBworld.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class memberDTO implements Serializable{
	private long no;
	private String id;
	private String password;
	private String nickname;
	private long score;
	private String memberlevel;
}
