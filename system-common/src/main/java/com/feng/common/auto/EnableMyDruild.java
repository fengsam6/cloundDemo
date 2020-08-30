package com.feng.common.auto;

import com.feng.common.config.druid.DruidImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DruidImportSelector.class})
public @interface EnableMyDruild {
}
