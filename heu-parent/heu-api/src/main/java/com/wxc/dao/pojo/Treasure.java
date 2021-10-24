package com.wxc.dao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Treasure implements Serializable {


    @NotNull
    private Long id;

    @NotNull(message = "位置序号不能为空")
    private Integer locationnum;

    private boolean isdisply;

    @NotNull
    private boolean isget;

    @NotNull(message = "描述不能为空")
    private String description;

    @NotNull(message = "时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime uptime;




    private String url;

    private String upuser;

    private String getuser;

}

