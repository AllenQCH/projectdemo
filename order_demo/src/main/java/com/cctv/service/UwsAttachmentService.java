package com.cctv.service;

import com.cctv.mapper.UwsAttachmentMapper;
import com.cctv.pojo.UwsAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UwsAttachmentService {
    @Autowired
    private UwsAttachmentMapper uwsAttachmentMapper;

    public UwsAttachment selectByPrimaryKey(Long id) {
        return uwsAttachmentMapper.selectByPrimaryKey(id);
    }

}
