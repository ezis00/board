package com.spectra.board.domain.entity;

import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.granule.UserType;

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
                    this.loginCount = Integer.parseInt(value);
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }

    }
}
