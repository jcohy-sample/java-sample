package com.jcohy.sample.build;

import io.github.jcohy.gradle.conventions.ConventionsPlugin;
import io.github.jcohy.gradle.deployed.DeployedPlugin;
import io.github.jcohy.gradle.optional.OptionalDependenciesPlugin;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.plugins.JavaLibraryPlugin;
import org.gradle.api.plugins.PluginContainer;

import java.util.Collections;

/**
 * 描述: .
 *
 * <p>
 * Copyright © 2023 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 1.0.0 2023/10/9 12:01
 * @since 1.0.0
 */
public class JavaModulePlugins implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        plugins.apply(JavaLibraryPlugin.class);
        plugins.apply(ConventionsPlugin.class);
        plugins.apply(DeployedPlugin.class);
        plugins.apply(OptionalDependenciesPlugin.class);
        configureDependencyManagement(project);
    }

    private void configureDependencyManagement(Project project) {
        Dependency parent = project.getDependencies().enforcedPlatform(project.getDependencies()
                .project(Collections.singletonMap("path", ":bom")));
        project.getConfigurations().getByName("dependencyManagement", (dependencyManagement) -> {
            dependencyManagement.getDependencies().add(parent);
        });
    }
}
