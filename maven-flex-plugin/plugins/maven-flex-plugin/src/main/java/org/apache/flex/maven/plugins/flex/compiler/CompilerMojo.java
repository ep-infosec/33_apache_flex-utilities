/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.flex.maven.plugins.flex.compiler;

import org.apache.flex.maven.plugins.flex.AbstractFlexMojo;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cdutz
 * Date: 01.12.12
 * Time: 17:48
 */
@Mojo(name = "compile",
        defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE,
        threadSafe = true)
public class CompilerMojo extends AbstractFlexMojo {

    @Parameter(defaultValue = "false")
    protected boolean useLegacyCompiler;

    @Component
    protected Map<String, Compiler> compilerMap;

    @Component
    protected MavenProject project;

    @Component
    protected MojoExecution mojoEcecution;

    public void execute() {
        if(mojoEcecution.getLifecyclePhase().equals(LifecyclePhase.COMPILE.id())) {
            if(useLegacyCompiler) {
                if(project.getPackaging().equalsIgnoreCase("SWC")) {
                    compilerMap.get("compc").compile(project);
                } else if(project.getPackaging().equalsIgnoreCase("SWF")) {
                    compilerMap.get("mxmlc").compile(project);
                } else {
                    throw new RuntimeException("Wrong packaging");
                }
            } else {
                compilerMap.get("falcon").compile(project);
            }
        } else if(mojoEcecution.getLifecyclePhase().equals(LifecyclePhase.PROCESS_SOURCES.id())) {
            compilerMap.get("asdoc").compile(project);
        }
    }

}
