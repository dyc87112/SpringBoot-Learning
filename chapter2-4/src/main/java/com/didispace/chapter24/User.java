package com.didispace.chapter24;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ApiModel(description = "用户实体")
public class User {

    @ApiModelProperty(value = "用户编号", position = 1)
    private Long id;

    @NotNull
    @Size(min = 2, max = 5)
    @ApiModelProperty(value = "用户姓名", position = 2)
    private String name;

    @NotNull
    @Max(100)
    @Min(10)
    @ApiModelProperty(value = "用户年龄", position = 3)
    private Integer age;

    @NotNull
    @Email
    @ApiModelProperty(value = "用户邮箱", position = 4)
    private String email;

}