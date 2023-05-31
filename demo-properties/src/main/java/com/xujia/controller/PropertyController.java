package com.xujia.controller;

import cn.hutool.core.lang.Dict;
import com.xujia.properties.ApplicationProperty;
import com.xujia.properties.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index() {
        // 使用 hutool工具类Dict来包装字典对象
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
    }
}