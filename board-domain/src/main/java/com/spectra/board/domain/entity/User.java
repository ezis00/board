package com.spectra.board.domain.entity;

import java.util.Arrays;
import java.util.List;

import com.spectra.board.domain.granule.UserType;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;

public class User extends Entity
{
    private UserType userType;
    private String name;
    private String phone;
    private String email;
    private final long joinDate;
    private int loginCount;

    public User(UserType userType, String name, String phone, String email)
    {
        super();
        this.userType = userType;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.joinDate = System.currentTimeMillis();
        this.loginCount = 0;
    }

    public UserType getUserType()
    {
        return userType;
    }

    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public long getJoinDate()
    {
        return joinDate;
    }

    public int getLoginCount()
    {
        return loginCount;
    }

    public void setLoginCount(int loginCount)
    {
        this.loginCount = loginCount;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", joinDate=" + joinDate +
                ", loginCount=" + loginCount +
                '}';
    }

    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "userType":
                    this.userType = UserType.fromJson(value);
                    break;
                case "name":
                    this.name = value;
                    break;
                case "phone":
                    this.phone = value;
                    break;
                case "email":
                    this.email = value;
                    break;
                case "loginCount":
                    this.loginCount++;
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }

    public static List<User> getSamples()
    {
        return Arrays.asList(
                new User(UserType.ADMIN, "이정호", "010-2002-0014", "leejh@spectra.co.kr"),
                new User(UserType.MANAGER, "홍길동", "010-1234-5678", "hong@spectra.co.kr"),
                new User(UserType.MANAGER, "김좌진", "010-5678-1234", "kim@spectra.co.kr"),
                new User(UserType.USER, "문재인", "010-5678-4321", "moon@spectra.co.kr"),
                new User(UserType.USER, "안철수", "010-1234-6789", "ahn@spectra.co.kr"),
                new User(UserType.USER, "세종대왕", "010-0123-4567", "se@spectra.co.kr"),
                new User(UserType.USER, "이순신", "010-9012-3456", "lee@spectra.co.kr"),
                new User(UserType.USER, "김건모", "010-8901-2345", "kimo@spectra.co.kr"),
                new User(UserType.USER, "아이유", "010-7890-1234", "iu@spectra.co.kr")
        );
    }

    public static User getAdminSample()
    {
        return User.getSamples().stream().filter(user -> user.getUserType().equals(UserType.ADMIN)).findFirst().orElse(null);
    }
}
