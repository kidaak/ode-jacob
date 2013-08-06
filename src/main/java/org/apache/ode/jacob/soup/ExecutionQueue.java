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
package org.apache.ode.jacob.soup;

import java.io.PrintStream;

import org.apache.ode.jacob.Message;

/**
 * The soup, the reactive "broth" that underlies the JACOB system. The {@link ExecutionQueue}
 * implementation is responsible for implementing the JACOB reactive rules and
 * maintaining the state of the reactive broth.
 *
 * @author Maciej Szefler <a href="mailto:mbs@fivesight.com">mbs</a>
 */
public interface ExecutionQueue {

  /**
   * Are there any reactions that can be executed in the broth?
   *
   * @return <code>true</code> if there are "enabled" reactions
   */
  boolean hasReactions();

  /**
   * Add a continuation to the broth. This operation is sometimes
   * referred to as an "injection"; it can be used to inject into the
   * broth the "original" continuation.
   * @param message the {@link Message} to add to the broth
   */
  public void enqueueReaction(Message message);

  public Message dequeueReaction();

  public void add(CommChannel channel);

  public void add(CommGroup group);

  public String createExport(CommChannel channel);

  public CommChannel consumeExport(String exportId);

  public int cycle();

  public void flush();

  public void setClassLoader(ClassLoader classLoader);

  public void setReplacementMap(ReplacementMap replacementMap);

  public boolean isComplete();

  public void dumpState(PrintStream err);

}
