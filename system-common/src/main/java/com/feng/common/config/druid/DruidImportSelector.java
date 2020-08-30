package com.feng.common.config.druid;

import com.feng.common.config.swagger.SwaggerConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DruidImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{DruidConfig.class.getName()};
    }
}
