/**
 * projectName: fendo-plus-boot
 * fileName: DictDialect.java
 * packageName: com.fendo.shiro.common.dialect.dict
 * date: 2018-01-20 12:28
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.dialect.dict;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DictDialect
 * @packageName: com.fendo.shiro.common.dialect.dict
 * @description: 字典方言
 * @data: 2018-01-20 12:28
 **/
public class DictDialect extends AbstractProcessorDialect {

    private static final String DIALECT_NAME = "Dict Dialect";//定义方言名称

    public DictDialect() {
        // 我们将设置此方言与“方言处理器”优先级相同
        // 标准方言, 以便处理器执行交错。
        super(DIALECT_NAME, "Dict", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    /**
     * 元素处理器：“matter”标签。
     * @param dialectPrefix
     * @return
     */
    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new DictProcessor(dialectPrefix));//添加我们定义的标签
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }
}
