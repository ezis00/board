package com.spectra.board.domain.entity;

import java.util.Set;

import com.spectra.board.domain.share.granule.IdSet;
import com.spectra.board.domain.granule.ChannelOptionKey;
import com.spectra.board.domain.granule.ChannelOptionMap;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public class Channel extends Post
{
    private final PostType postType = PostType.CHANNEL;
    private final String name;
    private ChannelOptionMap channelOptionMap;
    private IdSet idSet;

    public Channel(String writerId, String name)
    {
        this(null, writerId, name);
    }

    public Channel(PostInfo parentPostInfo, String writerId, String name)
    {
        super(parentPostInfo, writerId);
        this.name = name;
        this.channelOptionMap = new ChannelOptionMap();
        this.idSet = new IdSet();
    }

    public static Channel getSample()
    {
        Channel channel = new Channel("영업 비밀", User.getAdminSample().getId());
        channel.setMemberIdSet(IdSet.getSample());
        channel.addOption(ChannelOptionKey.PRIVATE, "true");
        channel.addOption(ChannelOptionKey.ATTACH_MAX_SIZE_MB, "1000");
        channel.addOption(ChannelOptionKey.THUMBNAIL_IMAGE_ID, "thumbnail_image_id");
        channel.addOption(ChannelOptionKey.BACKGROUND_IMAGE_ID, "background_image_id");
        return channel;
    }

    public PostType getPostType()
    {
        return postType;
    }

    public String getName()
    {
        return name;
    }

    public String getOption(ChannelOptionKey channelOptionKey)
    {
        return this.channelOptionMap.get(channelOptionKey);
    }

    public void addOption(ChannelOptionKey channelOptionKey, String value)
    {
        this.channelOptionMap.put(channelOptionKey, value);
    }

    public Set<String> getMemberIdSet()
    {
        return idSet.getAll();
    }

    public void addMemberId(String memberId)
    {
        this.idSet.add(memberId);
    }

    public void setMemberIdSet(IdSet idSet)
    {
        this.idSet = idSet;
    }

    @Override
    public String toString()
    {
        return "Channel{" +
                "name='" + name + '\'' +
                ", channelOptionMap=" + channelOptionMap +
                ", idSet=" + idSet +
                "} " + super.toString();
    }

    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "channelOptionMap":
                    this.channelOptionMap = ChannelOptionMap.fromJson(value);
                    break;
                case "idSet":
                    this.idSet = IdSet.fromJson(value);
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
