package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.ChannelOptionMap;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.UserType;

public class User extends Entity
{
    private UserType userType;
    private String name;
    private String phone;
    private String email;
    private long joinDate;
    private int loginCount;

    public User()
    {
    }

    public User(String id)
    {
        super(id);
    }

    public User(UserType userType, String name, String phone, String email)
    {
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

    public void setJoinDate(long joinDate)
    {
        this.joinDate = joinDate;
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
                    this.name = name;
                    break;
                case "phone":
                    this.phone = phone;
                    break;
            }
        }

    }
}
