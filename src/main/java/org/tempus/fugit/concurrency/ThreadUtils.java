/*
 * Copyright (c) 2009, Toby Weston
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

package org.tempus.fugit.concurrency;

import org.tempus.fugit.temporal.Condition;
import org.tempus.fugit.temporal.Duration;

public class ThreadUtils {

    public static void sleep(final Duration duration) {
        resetInterruptFlagWhen(sleepingIsInterrupted(duration));
    }

    private static Interruptable<Void> sleepingIsInterrupted(final Duration duration) {
        return new Interruptable<Void>() {
            public Void call() throws InterruptedException {
                Thread.sleep(duration.inMillis());
                return null;
            }
        };
    }

    public static <T> T resetInterruptFlagWhen(Interruptable<T> interruptable) {
        try {
            return interruptable.call();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public static Condition threadIsWaiting(final Thread thread) {
        return new Condition() {
            public boolean isSatisfied() {
                return thread.getState() == Thread.State.TIMED_WAITING || thread.getState() == Thread.State.WAITING;
            }
        };
    }

}