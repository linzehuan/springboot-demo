package com.dsx.entities;

public class User {
	
	//����ID����
	private int id;
	
	//�û�Ψһ��ʶ
	private String openid;
	
	//�û��ǳ�
	private String nickName;
	
	//�û�ͷ��URL
	private String headPortraitUrl;
	
	//�û��ֻ�����
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPortraitUrl() {
		return headPortraitUrl;
	}

	public void setHeadPortraitUrl(String headPortraitUrl) {
		this.headPortraitUrl = headPortraitUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String openid, String nickName, String headPortraitUrl, String phone) {
		super();
		this.openid = openid;
		this.nickName = nickName;
		this.headPortraitUrl = headPortraitUrl;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", openid=" + openid + ", nickName=" + nickName + ", headPortraitUrl="
				+ headPortraitUrl + ", phone=" + phone + "]";
	}

	public User() {
		super();
	}

}
