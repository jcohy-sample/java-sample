package com.jcohy.sample.build;

import java.util.HashMap;
import java.util.Map;

import io.github.jcohy.gradle.asciidoctor.AsciidoctorConventionsPlugin;
import io.github.jcohy.gradle.conventions.ConventionsPlugin;
import io.github.jcohy.gradle.deployed.DeployedPlugin;
import org.asciidoctor.gradle.jvm.AbstractAsciidoctorTask;
import org.asciidoctor.gradle.jvm.AsciidoctorJPlugin;
import org.gradle.api.JavaVersion;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.tasks.compile.JavaCompile;

/**
 * Copyright: Copyright (c) 2021 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2021/7/5:23:11
 * @since 1.0.0
 */
public class JcohyAsciidoctorPlugins implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        plugins.apply(AsciidoctorJPlugin.class);
        plugins.apply(ConventionsPlugin.class);
        plugins.apply(AsciidoctorConventionsPlugin.class);
        plugins.apply(DeployedPlugin.class);
        configureJavaCompileConventions(project);
        plugins.withType(AsciidoctorJPlugin.class,(asciidoctorPlugin) -> project.getTasks().withType(AbstractAsciidoctorTask.class, (asciidoctorTask) -> configureAsciidoctorTask(project, asciidoctorTask)));
    }

    private void configureJavaCompileConventions(Project project) {
        project.getTasks().withType(JavaCompile.class, compile -> {
            compile.setSourceCompatibility(JavaVersion.VERSION_11.toString());
            compile.setTargetCompatibility(JavaVersion.VERSION_11.toString());
        });
    }

    private void configureAsciidoctorTask(Project project, AbstractAsciidoctorTask asciidoctorTask) {
        configureCommonAttributes(project, asciidoctorTask);
    }

    private void configureCommonAttributes(Project project, AbstractAsciidoctorTask asciidoctorTask) {
        Map<String, Object> attributes = new HashMap<>();
        addAsciidoctorTaskAttributes(project,attributes);
        asciidoctorTask.attributes(attributes);
    }

    private void addAsciidoctorTaskAttributes(Project project,Map<String, Object> attributes) {
        attributes.put("author", "Author: Jcohy ");
        attributes.put("email", "Email: jia_chao23@126.com ");
        attributes.put("rootProject", project.getRootProject().getProjectDir());
        attributes.put("java-code", project.getRootProject().getProjectDir() + "/src/main/java/com/jcohy/sample");
        attributes.put("kotlin-code", project.getRootProject().getProjectDir() + "/src/main/kotlin/com/jcohy/sample");
        attributes.put("go-code", project.getRootProject().getProjectDir() + "/src/main/go/com/jcohy/sample");
        attributes.put("oss-images", "https://study.jcohy.com/images/java");
    }
}
