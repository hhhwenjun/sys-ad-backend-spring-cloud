package com.imooc.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 广告请求返回的数据, ad content
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_creative")
public class Creative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    /** main type of content (video, text, img) **/
    @Basic
    @Column(name = "type", nullable = false)
    private Integer type;

    /** material type, such as jpg, bmp, mp4 **/
    @Basic
    @Column(name = "material_type", nullable = false)
    private Integer materialType;

    /** height of material, img height etc. **/
    @Basic
    @Column(name = "height", nullable = false)
    private Integer height;

    @Basic
    @Column(name = "width", nullable = false)
    private Integer width;

    /** size of content **/
    @Basic
    @Column(name = "size", nullable = false)
    private Long size;

    /** only for video **/
    @Basic
    @Column(name = "size", nullable = false)
    private Integer duration;

    @Basic
    @Column(name = "audit_status", nullable = false)
    private Integer auditStatus;

    /** sponsor user **/
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "url", nullable = false)
    private String url;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
}
