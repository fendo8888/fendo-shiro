/**
 * projectName: fendo-plus-boot
 * fileName: zTreeNode.java
 * packageName: com.fendo.shiro.common.node
 * date: 2018-01-20 17:47
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.node;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: zTreeNode
 * @packageName: com.fendo.shiro.common.node
 * @description: zTree数据
 * @data: 2018-01-20 17:47
 **/
public class zTreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;	//节点id

    private Integer pId;//父节点id

    private String name;//节点名称

    private Boolean open;//是否打开节点

    private Boolean checked;//是否被选中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getIsOpen() {
        return open;
    }

    public void setIsOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public static zTreeNode createParent(){
        zTreeNode zTreeNode = new zTreeNode();
        zTreeNode.setChecked(true);
        zTreeNode.setId(0);
        zTreeNode.setName("顶级");
        zTreeNode.setOpen(true);
        zTreeNode.setpId(0);
        return zTreeNode;
    }

}
