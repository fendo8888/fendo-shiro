package com.fendo.shiro.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fendo.shiro.common.constant.IsMenu;

import java.io.Serializable;
import java.util.*;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MenuEntity
 * @packageName: com.fendo.shiro.node
 * @description: 菜单表
 * @data: 2018-01-15 19:59
 **/
@TableName("sys_menu")
public class MenuEntity extends Model<MenuEntity> implements Comparable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单排序
     */
    private Integer sort;
    /**
     * 链接
     */
    private String href;
    /**
     * 目标
     */
    private String target;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否在菜单中显示
     */
    @TableField("is_show")
    @JsonIgnore
    private String isShow;

    /**
     * 是否是菜单(1是 0不是)
     */
    @TableField("is_menu")
    private String isMenu;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField("update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 父级编号
     */
    @TableField("parent_id")
    private String parentId;
    /**
     * 所有父级编号
     */
    @TableField("parent_ids")
    private String parentIds;
    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单级别
     */
    private String levels;

    /**
     * 查询子节点时候的临时集合
     */
    @TableField(exist = false)
    private List<MenuEntity> linkedList = new ArrayList<MenuEntity>();

    /**
     * 子节点的集合
     */
    @TableField(exist = false)
    private List<MenuEntity> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<MenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEntity> children) {
        this.children = children;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
        ", id=" + id +
        ", name=" + name +
        ", sort=" + sort +
        ", href=" + href +
        ", target=" + target +
        ", icon=" + icon +
        ", isShow=" + isShow +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", remarks=" + remarks +
        ", delFlag=" + delFlag +
        ", parentId=" + parentId +
        ", parentIds=" + parentIds +
        ", permission=" + permission +
        "}";
    }


    @Override
    public int compareTo(Object o) {
        MenuEntity menuNode = (MenuEntity) o;
        Integer Sort = menuNode.getSort();
        if (Sort == null) {
            Sort = 0;
        }
        return this.sort.compareTo(Sort);
    }

    /**
     * 得到子节点列表
     */
    private List<MenuEntity> getChildList(List<MenuEntity> list, MenuEntity node) {
        List<MenuEntity> nodeList = new ArrayList<MenuEntity>();
        Iterator<MenuEntity> it = list.iterator();
        while (it.hasNext()) {
            MenuEntity n = (MenuEntity) it.next();
            if (n.getParentId().equals(node.getId())) {
                nodeList.add(n);
            }
        }
        return nodeList;
    }

    /**
     * 查询子节点的集合
     * */
    public List<MenuEntity> findChildNodes(List<MenuEntity> nodeList, String parentId) {
        if(nodeList == null && parentId == null){
            return null;
        }
        for (Iterator<MenuEntity> iterator = nodeList.iterator(); iterator.hasNext(); ) {
            MenuEntity node = (MenuEntity) iterator.next();
            // 根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() != "1" && parentId.equals(node.getParentId())) {
                recursionFn(nodeList, node, parentId);
            }
        }
        return linkedList;
    }


    /**
     * 构建整个菜单树
     */
    public void buildNodeTree(List<MenuEntity> nodeList) {
        for (MenuEntity treeNode : nodeList) {
            List<MenuEntity> linkedList = treeNode.findChildNodes(nodeList, ""+treeNode.getId());
            if (linkedList.size() > 0) {
                treeNode.setChildren(linkedList);
            }
        }
    }

    /**
     * 遍历一个节点的子节点
     *
     * @author fengshuonan
     */
    public void recursionFn(List<MenuEntity> nodeList, MenuEntity node, String pId) {
        List<MenuEntity> childList = getChildList(nodeList, node);// 得到子节点列表
        if (childList.size() > 0) {// 判断是否有子节点
            if (node.getParentId().equals(pId)) {
                linkedList.add(node);
            }
            Iterator<MenuEntity> it = childList.iterator();
            while (it.hasNext()) {
                MenuEntity n = (MenuEntity) it.next();
                recursionFn(nodeList, n, pId);
            }
        } else {
            if (node.getParentId().equals(pId)) {
                linkedList.add(node);
            }
        }
    }

    /**
     * 清除所有二级菜单
     **/
    public static List<MenuEntity> clearLevelTwo(List<MenuEntity> nodes) {
        ArrayList<MenuEntity> results = new ArrayList<MenuEntity>();
        for (MenuEntity node : nodes) {
            String  levels = node.getLevels();
            if ("1".equals(levels)) {
                results.add(node);
            }
        }
        return results;
    }

    /**
     * 清除掉按钮级别的资源(1是菜单 0不是)
     */
    public static List<MenuEntity> clearBtn(List<MenuEntity> nodes) {
        ArrayList<MenuEntity> noBtns = new ArrayList<MenuEntity>();
        for (MenuEntity node : nodes) {
            if(IsMenu.YES.getCode().equals(node.getIsMenu())){
                noBtns.add(node);
            }
        }
        return noBtns;
    }

    /**
     * 构建菜单列表
     *
     * @date 2017年2月19日 下午11:18:19
     */
    public static List<MenuEntity> buildMenu(List<MenuEntity> nodes) {

        List<MenuEntity> clearBtn = clearBtn(nodes);

        new MenuEntity().buildNodeTree(clearBtn);

        List<MenuEntity> menuNodes = clearLevelTwo(clearBtn);//清理二级菜单

        //对菜单排序
        Collections.sort(menuNodes);

        //对菜单的子菜单进行排序
        for (MenuEntity menuNode : menuNodes) {
            if (menuNode.getChildren() != null && menuNode.getChildren().size() > 0) {
                Collections.sort(menuNode.getChildren());
            }
        }

        return menuNodes;
    }

}
