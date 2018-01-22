/**
 * projectName: fendo-plus-boot
 * fileName: TreeViewNode.java
 * packageName: com.fendo.shiro.common.node
 * date: 2018-01-20 17:38
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: TreeViewNode
 * @packageName: com.fendo.shiro.common.node
 * @description: TreeView数据
 * @data: 2018-01-20 17:38
 **/
public class TreeViewNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String text;
    private String href;
    private String pid;
    private String level;
    private boolean isLeaf = true; //leaf 表示当前分类是叶子节点，是表示没有子分类
    private boolean selectable = false;//默认不能被选中，这里实现的只有叶子节点才能被选中，在TreeManager.java中有判断
    private List<TreeViewNode> nodes = new ArrayList<TreeViewNode>();
    private State state = new State();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<TreeViewNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeViewNode> nodes) {
        this.nodes = nodes;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //内部类，定义节点的状态，这是根据bootstrap tree api中的节点结构定义的，其中的定义要求
    //是：state：Object Optional Describes a node's initial state. 所以必须是类成员，
    //该内部类也可以单独拿出来，但是还是定义为内部类比较合适
    public class State {
        private boolean checked = false;
        private boolean disabled = false;
        private boolean expanded = false;
        private boolean selected = false;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public boolean isExpanded() {
            return expanded;
        }

        public void setExpanded(boolean expanded) {
            this.expanded = expanded;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }


}
