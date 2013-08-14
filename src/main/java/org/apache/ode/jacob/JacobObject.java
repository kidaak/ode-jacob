/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ode.jacob;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.ode.jacob.oo.Channel;
import org.apache.ode.jacob.oo.ChannelListener;
import org.apache.ode.jacob.oo.ClassUtil;
import org.apache.ode.jacob.vpu.JacobVPU;

/**
 * Base class for constructs which rely on a Java method body to represent some
 * aspect of the process.
 */
@SuppressWarnings("serial")
public abstract class JacobObject implements Serializable {
    public Set<Method> getImplementedMethods() {
    	return null;
    }

    /**
     * Get the unadorned (no package) name of this class.
     */
    protected String getClassName() {
        return getClass().getSimpleName();
    }


    public Method getMethod(String methodName) {
        Set<Method> implementedMethods = getImplementedMethods();
        implementedMethods = implementedMethods == null ? ClassUtil.runMethodSet() : implementedMethods;
        for (Method m : implementedMethods) {
            if (m.getName().equals(methodName)) {
                return m;
            }
        }
        throw new IllegalArgumentException("No such method \"" + methodName + "\"!");
    }

    public String toString() {
        return "<JacobObject:" + getClassName() + ">";
    }

}
