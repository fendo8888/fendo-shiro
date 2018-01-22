/**
 * projectName: fendo-plus-boot
 * fileName: DictProcessor.java
 * packageName: com.fendo.shiro.common.dialect.dict
 * date: 2018-01-20 12:39
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.dialect.dict;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fendo.shiro.entity.DictEntity;
import com.fendo.shiro.mapper.DictMapper;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DictTagProcessor
 * @packageName: com.fendo.shiro.common.dialect.dict
 * @description: 字典标签处理器
 * @data: 2018-01-20 12:39
 **/
public class DictTagProcessor extends AbstractElementTagProcessor {

    private static final String TAG_NAME  = "matter";//标签名
    private static final int PRECEDENCE = 10000;//优先级

    public DictTagProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML, // 此处理器将仅应用于HTML模式
                dialectPrefix,     // 要应用于名称的匹配前缀
                TAG_NAME,          // 标签名称：匹配此名称的特定标签
                true,              // 将标签前缀应用于标签名称
                null,              // 无属性名称：将通过标签名称匹配
                false,             // 没有要应用于属性名称的前缀
                PRECEDENCE);       // 优先(内部方言自己的优先)

    }

    /**
     * context 页面上下文
     * tag  标签
     */
    @Override
    protected void doProcess(
            final ITemplateContext context,
            final IProcessableElementTag tag,
            final IElementTagStructureHandler structureHandler) {

        /**
         * 获取应用程序上下文。
         */
        ApplicationContext appCtx = SpringContextUtils.getApplicationContext(context);
        DictMapper mapper = appCtx.getBean(DictMapper.class);
       /*
        * 从标签读取“matterid”属性。标签中的这个可选属性将告诉我们需要什么样的数据
        */
        final String  type= tag.getAttributeValue("dictType");
        EntityWrapper parame = new EntityWrapper();
        parame.setEntity(new DictEntity());
        parame.where("type = {0}",type);
        List<DictEntity> dictEntityList = mapper.selectList(parame);
        String dictValue = null;
        //DictEntity dictEntity = null;
        if(null != dictEntityList){
            dictValue = dictEntityList.get(0).getValue();
        }else{
            dictValue = "无素材信息" ;
        }
       /*
        *  创建将替换自定义标签的DOM结构。
        * logo将显示在“<div>”标签内, 因此必须首先创建,
        * 然后必须向其中添加一个节点。
        */
        final IModelFactory modelFactory = context.getModelFactory();

        final IModel model = modelFactory.createModel();

        model.add(modelFactory.createOpenElementTag("div"));
        model.add(modelFactory.createText(dictValue));
        model.add(modelFactory.createCloseElementTag("div"));

       /*
        * 指示引擎用指定的模型替换整个元素。
        */
        structureHandler.replaceWith(model, false);

    }
}
