/*
 * Copyright (c) 2009-2014, toby weston & tempus-fugit committers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.tempusfugit.temporal;

import com.google.code.tempusfugit.concurrency.Callable;
import org.hamcrest.SelfDescribing;

/**
 * A lazy evaluation probe for specific value.
 * <p></p>
 * Implementations should implement {@link #describeTo(org.hamcrest.Description)} to describe the specific probe, for example, a probe to check 'the time on a clock'.
 * <p></p>
 * @param <T> the value to lazily probe for
 */
public interface ProbeFor<T> extends Callable<T, RuntimeException>, SelfDescribing {

}
