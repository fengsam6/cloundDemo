package com.feng.common.auto;

import com.feng.common.config.swagger.SwaggerImportSelector;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableSwagger2
@Import({SwaggerImportSelector.class})
public @interface EnableMySwagger {
}
